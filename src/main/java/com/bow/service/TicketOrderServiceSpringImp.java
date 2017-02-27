package com.bow.service;

import com.bow.entity.TBOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TicketOrderServiceSpringImp {
    private Logger logger = LoggerFactory.getLogger(TicketOrderServiceSpringImp.class);

    public boolean createOrder(TBOrder theOrder) {
        logger.info("create order ..." + theOrder);
        return true;
    }

    public List<TBOrder> queryMyOrders(String phoneNum) {
        return null;
    }

    public boolean cancelOrder(long orderId) {
        return true;
    }
}
