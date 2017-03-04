package com.bow.service;

import Ice.Communicator;
import IceBox.Service;
import com.bow.api.DataListenerPrx;
import com.bow.api._DemoServiceDisp;

import Ice.Current;

import java.util.concurrent.TimeUnit;

/**
 * 业务实现类<br/>
 * {@link _DemoServiceDisp} 实现了 {@link com.bow.api.DemoService}
 *
 *
 * @author vv
 * @since 2017/1/24.
 */
public class DemoServiceImpl extends _DemoServiceDisp implements Service {

    private static final long serialVersionUID = 1L;

    private Ice.ObjectAdapter _adapter;

    @Override
    public void start(String name, Communicator communicator, String[] strings) {
        _adapter = communicator.createObjectAdapter(name);
        // 创建servant, 并给其一个名字
        _adapter.add(this, communicator.stringToIdentity(name));
        _adapter.activate();
        System.out.println(name + "is started!");
    }

    @Override
    public void stop() {
        System.out.println(this._adapter.getName() + "is stop!");
        // 销毁adapter
        _adapter.destroy();
    }

    @Override
    public void say(String s, Current __current) {
        System.out.println("The string s is " + s);
    }

    @Override
    public int calculate(int a, int b, Current __current) {
        return (a + b) * 2;
    }

    @Override
    public void subscribe(DataListenerPrx listener, Current __current) {
        for (int i = 0; i < 3; i++) {
            listener.changeState(i);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int async(int a, Current __current) {
        System.out.println("enter async");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a*10;
    }

}
