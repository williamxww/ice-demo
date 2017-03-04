package com.bow.async;// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Demo.*;

public class HelloAsyncI extends _HelloAsyncDisp
{
    public HelloAsyncI(WorkQueue workQueue)
    {
        _workQueue = workQueue;
    }

    public void
    sayHello_async(AMD_HelloAsync_sayHello cb, int delay, Ice.Current current)
    {
        if(delay == 0)
        {
            System.out.println("Hello World!");
            cb.ice_response();
        }
        else
        {
            _workQueue.add(cb, delay);
        }
    }

    public void
    shutdown(Ice.Current current)
    {
        System.out.println("Shutting down...");

        _workQueue._destroy();
        current.adapter.getCommunicator().shutdown();
    }

    private WorkQueue _workQueue;
}
