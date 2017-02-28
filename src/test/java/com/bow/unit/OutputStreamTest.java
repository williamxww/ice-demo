package com.bow.unit;

import Ice.ByteSeqHolder;
import Ice.Communicator;
import Ice.InitializationData;
import Ice.OutputStream;
import Ice.OutputStreamI;
import Ice.Util;
import org.junit.Test;

/**
 * @author vv
 * @since 2017/2/27.
 */
public class OutputStreamTest {

    @Test
    public void test() {
        InitializationData initData = new InitializationData();
        initData.properties.setProperty("size", "1");
        Communicator communicator = Util.initialize(initData);
        OutputStream os = new OutputStreamI(communicator);

    }

    public void byteSeqHold(){
        ByteSeqHolder holder = new ByteSeqHolder();
    }
}
