/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client;

import com.staalcomputingsolutions.snserver.session.client.information.ClientInformation;

/**
 *
 * @author Charles Joseph Staal
 */
public class ClientFactory {

    public static Client createClient(ClientInformation clientInformation) {
        return new DefaultClient(clientInformation);
    }
}
