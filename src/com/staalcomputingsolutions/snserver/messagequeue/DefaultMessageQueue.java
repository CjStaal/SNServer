/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.messagequeue;

import com.staalcomputingsolutions.snserver.client.messageExecutor.MessageExecutor;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultMessageQueue implements MessageQueue {

    private final Queue<String> messageQueue;
    private final MessageExecutor msgExec;

    public DefaultMessageQueue(MessageExecutor msgExec) {
        this.messageQueue = new LinkedList();
        this.msgExec = msgExec;
    }

    private void addToQueue(String message) {
        this.messageQueue.add(message);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
