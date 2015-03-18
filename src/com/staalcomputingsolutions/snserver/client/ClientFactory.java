/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

/**
 *
 * @author Charles Joseph Staal
 */
public class ClientFactory {

    public static Client createClient(ClientInformation clientInformation) {
        return new DefaultClient(clientInformation);
    }
}
