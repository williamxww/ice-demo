package com.bow.minimal;

import Demo.*;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        try {
            Ice.Communicator communicator = Ice.Util.initialize(args);
            HelloPrx hello = HelloPrxHelper
                    .checkedCast(communicator.stringToProxy("hello:tcp -h 192.168.1.104 -p 10000"));
            int c = 0;
            while (c < 3) {
                hello.sayHello();
                c++;
                TimeUnit.SECONDS.sleep(10);
            }
            communicator.destroy();
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
}
