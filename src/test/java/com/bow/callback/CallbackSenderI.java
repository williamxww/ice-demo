package com.bow.callback;

import Demo.*;

public final class CallbackSenderI extends _CallbackSenderDisp {
    public void initiateCallback(CallbackReceiverPrx proxy, Ice.Current current) {
        System.out.println("initiating callback");
        try {
            proxy.callback();
        } catch (Ice.LocalException ex) {
            ex.printStackTrace();
        }
    }

    public void shutdown(Ice.Current current) {
        System.out.println("Shutting down...");
        try {
            current.adapter.getCommunicator().shutdown();
        } catch (Ice.LocalException ex) {
            ex.printStackTrace();
        }
    }
}
