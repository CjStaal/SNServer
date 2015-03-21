/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.message.queue;

import com.staalcomputingsolutions.snserver.message.Message;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Charles Joseph Staal
 */
public class MessageQueue {

    private static final BlockingQueue<Message> messageQueue = new ArrayBlockingQueue(100);

    public MessageQueue() {
    }

    public static void addToQueue(Message message) {
        messageQueue.add(message);
    }

    public static Message take() throws InterruptedException {
        return messageQueue.take();
    }
}
