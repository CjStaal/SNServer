/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client.computer;

/**
 *
 * @author Charles Joseph Staal
 */
public class Computer {

    private final String name, localIP;

    public Computer(String name, String localIP) {
        this.name = name;
        this.localIP = localIP;
    }

    public String getName() {
        return this.name;
    }

    public String getLocalIP() {
        return this.localIP;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nLocalIP: " + this.getLocalIP();
    }
}
