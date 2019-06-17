/**
 * SMsgServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzt;

public class SMsgServiceTestCase extends junit.framework.TestCase {
    public SMsgServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testSMsgWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new com.wzt.SMsgServiceLocator().getSMsgAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new com.wzt.SMsgServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SMsgInvoke() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.Object value = null;
        value = binding.invoke(new java.lang.String());
        // TBD - validate results
    }

    public void test2SMsgMain() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        binding.main(new java.lang.String[0]);
        // TBD - validate results
    }

    public void test3SMsgInit() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.init(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test4SMsgRelease() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.release();
        // TBD - validate results
    }

    public void test5SMsgFlushHost() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.flushHost();
        // TBD - validate results
    }

    public void test6SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), 0);
        // TBD - validate results
        System.out.println(value);
    }

    public void test7SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test8SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), 0, new java.lang.String());
        // TBD - validate results
    }

    public void test9SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), 0, 0, new java.lang.String());
        // TBD - validate results
    }

    public void test10SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test11SMsgSendSM() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendSM(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new java.lang.String(), 0, 0, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test12SMsgRecvRPT() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.recvRPT(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test13SMsgSendPDU() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendPDU(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new byte[0], 0, 0, 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test14SMsgSendPDU() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        int value = -3;
        value = binding.sendPDU(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String[0], new byte[0], 0, 0, 0, 0, 0, new java.lang.String(), new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test15SMsgRecvMo() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.recvMo(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test16SMsgCheckTime() throws Exception {
        com.wzt.SMsgSoapBindingStub binding;
        try {
            binding = (com.wzt.SMsgSoapBindingStub)
                          new com.wzt.SMsgServiceLocator().getSMsg();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkTime(new java.lang.String());
        // TBD - validate results
    }

}
