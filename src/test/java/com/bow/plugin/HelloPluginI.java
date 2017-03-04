package com.bow.plugin;

public class HelloPluginI implements Ice.Plugin {
    public HelloPluginI(Ice.Communicator communicator) {
        _communicator = communicator;
    }

    public void initialize() {
        Ice.ObjectAdapter adapter = _communicator.createObjectAdapter("Hello");
        adapter.add(new Hello2I(), _communicator.stringToIdentity("hello"));
        adapter.activate();
    }

    public void destroy() {
    }

    private Ice.Communicator _communicator;
}
