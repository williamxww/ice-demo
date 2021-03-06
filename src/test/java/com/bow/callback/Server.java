package com.bow.callback;

public class Server extends Ice.Application {
	public int run(String[] args) {
		if (args.length > 0) {
			System.err.println(appName() + ": too many arguments");
			return 1;
		}

		Ice.ObjectAdapter adapter = communicator().createObjectAdapter("Callback.Server");
		adapter.add(new CallbackSenderI(), communicator().stringToIdentity("callbackSender"));
		adapter.activate();
		communicator().waitForShutdown();
		return 0;
	}

	public static void main(String[] args) {
		Server app = new Server();
		int status = app.main("Server", args, "com/bow/callback/config.server");
		System.exit(status);
	}
}
