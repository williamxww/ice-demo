package com.bow.ice.util;

import org.slf4j.LoggerFactory;

import Ice.Logger;

public class Sl4jLoggerI implements Logger {
    private final org.slf4j.Logger logger;

    private final String prefix;

    public Sl4jLoggerI(String prefix) {
        logger = LoggerFactory.getLogger(prefix);
        this.prefix = prefix;
    }

    @Override
    public void print(String message) {
        logger.info(message);
    }

    @Override
    public void trace(String category, String message) {
        logger.debug(category + " " + message);
    }

    @Override
    public void warning(String message) {
        logger.warn(message);
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public Logger cloneWithPrefix(String prefix) {
        return new Sl4jLoggerI(prefix);
    }

}
