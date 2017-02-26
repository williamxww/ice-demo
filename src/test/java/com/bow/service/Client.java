package com.bow.service;

import com.bow.api.DemoServicePrx;
import com.bow.api.DemoServicePrxHelper;

/**
 * @author vv
 * @since 2017/1/24.
 */

public class Client {

    public static void main(String[] args) {
        int status = 0;
        //通信器
        Ice.Communicator ic = null;
        try {
            String[] initParams = new String[]{"--Ice.Default.Locator=IceGrid/Locator:tcp -h localhost -p 4061"};
            ic = Ice.Util.initialize(initParams);

            // 通过servant信息(servant名称:地址)获取代理
            Ice.ObjectPrx base = ic.stringToProxy("DemoService:default -p 10000");
            //通过注册中心获取地址信息
//            Ice.ObjectPrx base = ic.stringToProxy("DemoService@DemoServiceAdapter");

            // 获取远端接口的代理
            DemoServicePrx servicePrx = DemoServicePrxHelper.checkedCast(base);
            if (servicePrx == null) {
                throw new RuntimeException("Invalid proxy");
            }

            servicePrx.say("vv");
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            e.printStackTrace();
            status = 1;
        } finally {
            if (ic != null) {
                ic.destroy();
            }
        }
        System.exit(status);
    }
}
