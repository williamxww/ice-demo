package com.bow.plugin;

import Ice.PluginFactory;
import Ice.LoggerPlugin;

public class LoggerPluginFactoryI implements PluginFactory {
    public Ice.Plugin create(Ice.Communicator communicator, String name, String[] args) {
        return new LoggerPlugin(communicator, new LoggerI());
    }
}
