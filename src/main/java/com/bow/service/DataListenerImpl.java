package com.bow.service;

import com.bow.api._DataListenerDisp;

import Ice.Current;

/**
 * @author vv
 * @since 2017/3/4.
 */
public class DataListenerImpl extends _DataListenerDisp {
    @Override
    public void changeState(int state, Current __current) {
        System.out.println("State change: " + state);
    }
}
