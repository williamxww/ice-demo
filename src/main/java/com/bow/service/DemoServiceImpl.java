package com.bow.service;

import Ice.Communicator;
import IceBox.Service;
import com.bow.api._DemoServiceDisp;

import Ice.Current;

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
    public void say(String s, Current __current) {
        System.out.println("Hello World!" + " the string s is " + s);
    }

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
        System.out.println(this._adapter.getName() + "is stoped!");
        // 销毁adapter
        _adapter.destroy();
    }
}
