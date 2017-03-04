package com.bow.plugin;

import Demo.*;

public class Hello2I extends _Hello2Disp {
    public void sayHello(Ice.Current current) {
        current.adapter.getCommunicator().getLogger().print("Hello World!");
    }

    public void shutdown(Ice.Current current) {
        current.adapter.getCommunicator().getLogger().print("Shutting down...");
        current.adapter.getCommunicator().shutdown();
    }
}
