package com.bow.service;

import Ice.AsyncResult;
import Ice.Identity;
import com.bow.api.DataListenerPrx;
import com.bow.api.DataListenerPrxHelper;
import com.bow.api.DemoServicePrx;
import com.bow.api.DemoServicePrxHelper;
import org.junit.Before;
import org.junit.Test;


/**
 * @author vv
 * @since 2017/1/24.
 */

public class Client {

    private Ice.Communicator communicator;

    private DemoServicePrx servicePrx;

    @Before
    public void setup() {
        try {
            String[] initParams = new String[] { "--Ice.Default.Locator=IceGrid/Locator:tcp -h localhost -p 4061" };
            communicator = Ice.Util.initialize(initParams);

            // 通过servant信息(servant名称:地址)获取代理
//            Ice.ObjectPrx proxy = communicator.stringToProxy("DemoService:default -p 10000");
            // 通过注册中心获取地址信息
             Ice.ObjectPrx proxy = communicator.stringToProxy("DemoService@DemoServiceAdapter");

            // 获取远端接口的代理
            servicePrx = DemoServicePrxHelper.checkedCast(proxy);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void call() {
        servicePrx.say("vv");
        int a = servicePrx.calculate(1, 1);
        System.out.println(a);
    }

    @Test
    public void callback() {

        // 将监听器暴露为一个服务
        Identity id = communicator.stringToIdentity("DataListener");
        Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("DataListenerAdapter", "default -p 10001");
        adapter.add(new DataListenerImpl(), id);
        adapter.activate();

        // 订阅
        DataListenerPrx listenerPrx = DataListenerPrxHelper.uncheckedCast(adapter.createProxy(id));
        servicePrx.subscribe(listenerPrx);

        communicator.waitForShutdown();
    }

    @Test
    public void async(){
        AsyncResult result = servicePrx.begin_async(10, new Callback_DemoService_asyncI());
        result.waitForCompleted();
        System.out.println("end");
    }
}
