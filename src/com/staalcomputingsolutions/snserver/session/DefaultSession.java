/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.session.client.Client;
import com.staalcomputingsolutions.snserver.session.listener.Listener;
import com.staalcomputingsolutions.snserver.session.replier.Replier;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultSession implements Session {

    private final SessionContext sessionContext;

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
    public Client getClient() {
        return this.sessionContext.getClient();
    }

    @Override
    public Socket getSocket() {
        return this.sessionContext.getSocket();
    }

    @Override
    public String getUUID() {
        return this.sessionContext.getUUID();
    }
}
