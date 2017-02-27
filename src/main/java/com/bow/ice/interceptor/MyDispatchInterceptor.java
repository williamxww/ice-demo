package com.bow.ice.interceptor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ice.DispatchInterceptor;
import Ice.DispatchStatus;
import Ice.Identity;
import Ice.Request;

public class MyDispatchInterceptor extends DispatchInterceptor {
    private static Logger logger = LoggerFactory.getLogger(MyDispatchInterceptor.class);

    // 用来存放我们需要拦截的Ice服务对象，Key为服务ID，value为对应的Servant
    private static final Map<Identity, Ice.Object> idObjectMap = new ConcurrentHashMap();

    // 单例模式
    private static final MyDispatchInterceptor instance = new MyDispatchInterceptor();

    public static MyDispatchInterceptor getInstance() {
        return instance;
    }

    // 添加我们要拦截的服务Servant
    public static DispatchInterceptor addIceObject(Identity id, Ice.Object iceObj) {
        idObjectMap.put(id, iceObj);
        return instance;
    }

    @Override
    public DispatchStatus dispatch(Request request) {
        Identity theId = request.getCurrent().id;
        // request.getCurrent().con 会打印出来local address=localhost:50907
        // (回车换行)remote address=localhost:51147这样的信息
        // 其中local address为被访问的服务地址端口，remote address为客户端的地址端口
        String msg = "dispatch request,method: " + request.getCurrent().operation + " service:" + theId.name
                + " server address:" + request.getCurrent().con;
        logger.info(msg + " begin");
        try {
            DispatchStatus status = idObjectMap.get(request.getCurrent().id).ice_dispatch(request);
            logger.info(msg + " success");
            return status;
        } catch (Exception e) {
            logger.info(msg + " error " + e);
            throw e;

        }
    }

    public static void removeIceObject(Identity id) {
        logger.info("remove ice object " + id);
        idObjectMap.remove(id);
    }

}
