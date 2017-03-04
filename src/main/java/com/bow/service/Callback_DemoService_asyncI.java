package com.bow.service;

import Ice.LocalException;
import com.bow.api.Callback_DemoService_async;

/**
 * @author vv
 * @since 2017/3/4.
 */
public class Callback_DemoService_asyncI extends Callback_DemoService_async {
    @Override
    public void response(int arg) {
        System.out.println(arg);
    }

    @Override
    public void exception(LocalException __ex) {

    }
}
