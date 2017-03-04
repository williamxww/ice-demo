package com.bow.plugin;// **********************************************************************
//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Ice.PluginFactory;

public class HelloPluginFactoryI implements PluginFactory
{
     public Ice.Plugin
     create(Ice.Communicator communicator, String name, String[] args)
     {
         return new HelloPluginI(communicator);
     }
}
