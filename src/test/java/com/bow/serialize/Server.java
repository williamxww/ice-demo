package com.bow.serialize;// **********************************************************************

//
// Copyright (c) 2003-2010 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************

import Demo.*;

public class Server extends Ice.Application {
	public int run(String[] args) {
		if (args.length > 0) {
			System.err.println(appName() + ": too many arguments");
			return 1;
		}

		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("Greet");
		adapter.add(new GreetI(), communicator().stringToIdentity("greet"));
		adapter.activate();
		communicator().waitForShutdown();
		return 0;
	}

	public static void main(String[] args) {
		Server app = new Server();
		int status = app.main("Server", args, "com/bow/serialize/config.server");
		System.exit(status);
	}
}
