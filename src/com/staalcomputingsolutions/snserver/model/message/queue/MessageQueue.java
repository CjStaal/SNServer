/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.message.queue;

import com.staalcomputingsolutions.snserver.model.message.Message;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 *
 * @author Charles Joseph Staal
 */
public class MessageQueue {

    private static BlockingQueue<Message> messageQueue;

    public MessageQueue(int queueLength) {
        messageQueue = new ArrayBlockingQueue(queueLength);
    }

    public static void addToQueue(Message message) {
        messageQueue.add(message);
    }

    public static Message take() throws InterruptedException {
        return messageQueue.take();
    }
}
