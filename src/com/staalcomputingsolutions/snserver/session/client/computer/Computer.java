/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client.computer;

/**
 * This is the computer object.
 *
 * @author Charles Joseph Staal
 */
public class Computer {

    private final String name, localIP, uuid;
    private String status;

    public Computer(String uuid, String name, String localIP, String status) {
        this.uuid = uuid;
        this.name = name;
        this.localIP = localIP;
        this.status = status;
    }

    public Computer(String[][] args) throws Exception {
        if (args.length == 3
                && (args[0][0].equals("UUID")
                && (args[1][0].equals("NAME")
                && args[2][0].equals("LOCALIP")))) {
            this.uuid = args[0][1];
            this.name = args[1][1];
            this.localIP = args[2][1];
        } else {
            throw new Exception("Input formatted incorrectly. Could not create computer.");
        }
    }

    public String getUUID() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }

    public String getLocalIP() {
        return this.localIP;
    }

    public void updateStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + "\nLocalIP: " + this.getLocalIP()
                + "\nStaus: " + this.getStatus();
    }
}
