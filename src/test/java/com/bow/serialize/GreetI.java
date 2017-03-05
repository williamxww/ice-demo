package com.bow.serialize;

import Demo.*;
import com.bow.entity.MyGreeting;

public class GreetI extends _GreetDisp {
	public void sendGreeting(MyGreeting greeting, Ice.Current current) {
		if (greeting != null) {
			System.out.println(greeting.text);
		} else {
			System.out.println("Received null greeting");
		}
	}

	public void shutdown(Ice.Current current) {
		System.out.println("Shutting down...");
		current.adapter.getCommunicator().shutdown();
	}
}
