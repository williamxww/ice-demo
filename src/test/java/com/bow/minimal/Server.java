package com.bow.minimal;

public class Server {
    public static void main(String[] args) {
        try {
            Ice.Communicator communicator = Ice.Util.initialize(args);
            Ice.ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Hello",
                    "tcp  -p 10000");
            adapter.add(new HelloI(), communicator.stringToIdentity("hello"));
            adapter.activate();
            System.out.println("Started");
            communicator.waitForShutdown();
            communicator.destroy();
        } catch (Ice.LocalException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
