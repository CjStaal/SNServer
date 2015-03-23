/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client.information;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultClientInformation implements ClientInformation {

    private final String name, phoneNumber;

    public DefaultClientInformation(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nPhone number: " + this.getPhoneNumber();
    }
}
