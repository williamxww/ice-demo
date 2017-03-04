package com.bow.plugin;

import Ice.Logger;

public class LoggerI implements Logger {
    public void print(String message) {
        System.out.println("PRINT: " + message);
    }

    public void trace(String category, String message) {
        System.out.println("TRACE(" + category + "): " + message);
    }

    public void warning(String message) {
        System.out.println("WARNING: " + message);
    }

    public void error(String message) {
        System.out.println("ERROR: " + message);
    }

    @Override
    public String getPrefix() {
        return null;
    }

    public Logger cloneWithPrefix(String prefix) {
        return new LoggerI();
    }
}
