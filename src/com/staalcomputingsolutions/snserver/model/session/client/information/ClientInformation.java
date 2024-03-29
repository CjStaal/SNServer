/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session.client.information;

/**
 *
 * @author Charles Joseph Staal
 */
public interface ClientInformation {

    public String getName();

    public String getPhoneNumber();

    @Override
    public String toString();
}
