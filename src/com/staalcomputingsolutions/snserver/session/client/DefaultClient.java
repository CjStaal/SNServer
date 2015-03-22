/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client;

import com.staalcomputingsolutions.snserver.session.client.information.ClientInformation;
import com.staalcomputingsolutions.snserver.session.client.computer.ComputerContainer;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultClient implements Client {

    private final ComputerContainer computerContainer;
    private final ClientInformation clientInformation;

    public DefaultClient(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
        computerContainer = new ComputerContainer();
    }

    public ClientInformation getClientInformation() {
        return this.clientInformation;
    }

    @Override
    public ComputerContainer getComputerContainer() {
        return this.computerContainer;
    }

    @Override
    public String getName() {
        return this.clientInformation.getName();
    }

    @Override
    public String getPhoneNumber() {
        return this.clientInformation.getPhoneNumber();
    }
}
