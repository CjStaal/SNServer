/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

/**
 *
 * @author Charles Joseph Staal
 */
public interface ClientInformation {

    public String getName();

    public String getPhoneNumber();

    /**
     *
     * @return
     */
    @Override
    public String toString();
}
