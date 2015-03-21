/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.messagequeue.MessageQueue;
import com.staalcomputingsolutions.snserver.pinger.Pinger;
import com.staalcomputingsolutions.snserver.replier.Replier;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultSession implements Session {

    private SessionContext sessionContext;

    DefaultSession(SessionContext sessionContext) {
        this.sessionContext = sessionContext;
    }

    @Override
    public Listener getListener() {
        return this.sessionContext.getListener();
    }

    @Override
    public Replier getReplier() {
        return this.sessionContext.getReplier();
    }

    @Override
    public MessageQueue addMessageQueue() {
        return this.sessionContext.getMessageQueue();
    }

    @Override
    public Pinger getPinger(Pinger pinger) {
        return this.sessionContext.getPinger();
    }

    @Override
    public Client getClient() {
        return this.sessionContext.getClient();
    }

    @Override
    public void startPinger() {
        this.sessionContext.startPinger();
    }

    @Override
    public void stopPinger() {
        this.sessionContext.stopPinger();
    }

    @Override
    public Socket getSocket() {
        return this.sessionContext.getSocket();
    }
}
