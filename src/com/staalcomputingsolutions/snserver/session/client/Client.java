/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client;

import com.staalcomputingsolutions.snserver.session.client.computer.ComputerContainer;

/**
 * This is the interface default client uses.
 *
 * @author Charles Joseph Staal
 */
public interface Client {

    public ComputerContainer getComputerContainer();

    public String getName();

    public String getPhoneNumber();
}
