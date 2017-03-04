package com.bow.callback;

import Demo.*;

public final class CallbackReceiverI extends _CallbackReceiverDisp {
    public void callback(Ice.Current current) {
        System.out.println("received callback");
    }
}
