/**
 * SMsgService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.wzt;

public interface SMsgService extends javax.xml.rpc.Service {
    public java.lang.String getSMsgAddress();

    public com.wzt.SMsg_PortType getSMsg() throws javax.xml.rpc.ServiceException;

    public com.wzt.SMsg_PortType getSMsg(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
