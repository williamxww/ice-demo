package com.bow.service;

/**
 * @author vv
 * @since 2017/1/24.
 */
public class Server {

    public static void main(String[] args) {
        int status = 0;
        Ice.Communicator ic = null;
        try {
            // args为初使化参数，如连接超时时间，初使化客户连接池的数量等
            ic = Ice.Util.initialize(args);

            // 对象适配器，负责把请求传给正确的Servant
            Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints("DemoServiceAdapter", "default -p 10000");

            // 为DemoService接口创建一个servant, 给其指定名字后加入到adapter
            Ice.Object object = new DemoServiceImpl();
            adapter.add(object, Ice.Util.stringToIdentity("DemoService"));

            // 激活adapter后，服务器开始处理请求。
            adapter.activate();
            System.out.println("Server started");

            // 挂起当前线程
            ic.waitForShutdown();
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
