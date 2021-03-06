package com.bow.async;// **********************************************************************

//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

public class Server extends Ice.Application {

    private WorkQueue _workQueue;

    class ShutdownHook extends Thread {
        public void run() {
            _workQueue._destroy();
            communicator().shutdown();
        }
    }

    public int run(String[] args) {
        if (args.length > 0) {
            System.err.println(appName() + ": too many arguments");
            return 1;
        }

        setInterruptHook(new ShutdownHook());

        Ice.ObjectAdapter adapter = communicator().createObjectAdapter("Hello");
        _workQueue = new WorkQueue();
        adapter.add(new HelloAsyncI(_workQueue), communicator().stringToIdentity("hello"));
        _workQueue.start();
        adapter.activate();

        communicator().waitForShutdown();

        try {
            _workQueue.join();
        } catch (InterruptedException ex) {
        }

        return 0;
    }

    public static void main(String[] args) {
        Server app = new Server();
        int status = app.main("Server", args, "com/bow/async/config.server");
        System.exit(status);
    }

}
