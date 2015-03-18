/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

import com.staalcomputingsolutions.sns.model.client.Computer;


/**
 *
 * @author Charles Joseph Staal
 */
public interface ClientInformation {

    void addComputer(Computer computer);

    String getName();

    String getPhoneNumber();

    /**
     *
     * @return
     */
    @Override
    String toString();
    
}
