/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultClient implements Client {

    private ClientInformation clientInformation;

    public DefaultClient(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
    }

    public ClientInformation getClientInformation() {
        return this.clientInformation;
    }
}
