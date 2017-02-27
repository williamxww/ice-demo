package com.bow.unit;

import com.bow.ticket.Order;
import com.bow.ticket.TicketServicePrx;
import com.bow.utils.IceClientUtil;
import org.junit.Test;

/**
 * @author vv
 * @since 2017/2/27.
 */
public class IceTest {

    @Test
    public void test() {
        TicketServicePrx ticketServicePrx = (TicketServicePrx) IceClientUtil.getServicePrx(TicketServicePrx.class);
        Order[] orders = ticketServicePrx.queryMyOrders("13631276694");
        System.out.println("orders.length:" + orders.length);
    }
}
