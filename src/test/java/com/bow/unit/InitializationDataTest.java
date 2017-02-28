package com.bow.unit;

import Ice.Communicator;
import Ice.InitializationData;
import Ice.OutputStream;
import Ice.OutputStreamI;
import Ice.Util;
import IceInternal.Network;
import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @author vv
 * @since 2017/2/27.
 */
public class InitializationDataTest {

    @Test
    public void test() {
        InitializationData initData = new InitializationData();
        initData.properties = Util.createProperties();
        initData.properties.setProperty("Ice.MessageSizeMax","1048576");
        initData.properties.setProperty("Ice.ACM.Client","300");
        Communicator communicator = Util.initialize(initData);
        OutputStream os = new OutputStreamI(communicator);

    }


    @Test
    public void socket() throws IOException {
        //TcpTransceiver
        SocketChannel fd = Network.createTcpSocket();
        Network.doConnect(fd, new InetSocketAddress("127.0.0.1", 10000), null);
    }


}
