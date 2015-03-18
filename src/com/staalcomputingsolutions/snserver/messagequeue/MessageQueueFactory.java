/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.messagequeue;

import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.session.Session;

/**
 *
 * @author Charles Joseph Staal
 */
public class MessageQueueFactory {

    public static MessageQueue createQueue(Listener listener, Session callback) {
        return new DefaultMessageQueue(listener, callback);
    }
}
