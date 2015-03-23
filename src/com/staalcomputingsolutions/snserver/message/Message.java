/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.message;

/**
 *
 * @author Charles Joseph Staal
 */
public class Message {

    private final String uuid, message;

    public Message(String uuid, String message) {
        this.uuid = uuid;
        this.message = message;
    }

    public String getUUID() {
        return this.uuid;
    }

    public String getMessage() {
        return this.message;
    }
}
