package com.bow.plugin;

public class Server extends Ice.Application {
    public int run(String[] args) {
        if (args.length > 0) {
            System.err.println(appName() + ": too many arguments");
            return 1;
        }

        communicator().waitForShutdown();
        return 0;
    }

    public static void main(String[] args) {
        Server app = new Server();
        int status = app.main("Server", args, "config.server");
        System.exit(status);
    }
}
