package com.bow.ice.service;

import Ice.Object;

public class MyTicketService extends AbstractIceBoxService {

	@Override
	public Object createMyIceServiceObj(String[] args) {
		//创建servant并返回
		Object object = new TicketServiceI();
		return object;
	}

}
