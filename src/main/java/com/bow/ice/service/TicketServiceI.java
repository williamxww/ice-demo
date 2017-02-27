package com.bow.ice.service;

import java.util.List;

import com.bow.entity.TBOrder;
import com.bow.service.TicketOrderServiceSpringImp;
import com.bow.ticket.Order;
import com.bow.ticket._TicketServiceDisp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Ice.Current;

public class TicketServiceI extends _TicketServiceDisp {

    Logger logger = LoggerFactory.getLogger(TicketServiceI.class);

    @Override
    public boolean createOrder(Order myOrder, Current __current) {
        TBOrder tbOrder = new TBOrder();
        tbOrder.setPhone(myOrder.phone);
        tbOrder.setOrderDate(myOrder.orderDate);
        tbOrder.setOrderNum(myOrder.orderNum);
        tbOrder.setTicketType(myOrder.ticketType);
        tbOrder.setAmount(myOrder.amount);
        tbOrder.setOrderStatus(0);
        TicketOrderServiceSpringImp service = new TicketOrderServiceSpringImp();
        return service.createOrder(tbOrder);
    }

    @Override
    public Order[] queryMyOrders(String phone, Current __current) {
        TicketOrderServiceSpringImp service = new TicketOrderServiceSpringImp();
        List<TBOrder> tbOrders = service.queryMyOrders(phone);
        Order[] orders = new Order[tbOrders.size()];
        int i = 0;
        for (TBOrder tbOrder : tbOrders) {
            orders[i++] = tBOrder2Order(tbOrder);
        }
        return orders;
    }

    private static Order tBOrder2Order(TBOrder tbOrder) {
        Order order = new Order(tbOrder.getId(), tbOrder.getPhone(), tbOrder.getOrderNum(), tbOrder.getOrderDate(),
                tbOrder.getTicketType(), tbOrder.getAmount(), tbOrder.getOrderStatus());
        return order;
    }

    @Override
    public boolean cancelOrder(long orderId, Current __current) {
        TicketOrderServiceSpringImp service = new TicketOrderServiceSpringImp();
        return service.cancelOrder(orderId);
    }

}
