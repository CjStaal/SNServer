/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session;

import com.staalcomputingsolutions.snserver.model.session.context.SessionContext;
import com.staalcomputingsolutions.snserver.model.session.client.Client;
import com.staalcomputingsolutions.snserver.model.session.listener.Listener;
import com.staalcomputingsolutions.snserver.model.session.replier.Replier;
import java.net.Socket;

/**
 * This is the object used while creating a session.
 *
 * @author Charles Joseph Staal
 */
public class DefaultSession implements Session {

    private final SessionContext sessionContext;

    public DefaultSession(SessionContext sessionContext) {
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

    @Override
    public void updateStatus(String status) {
        this.sessionContext.setStatus(status);
    }

    @Override
    public String getStatus() {
        return this.sessionContext.getStatus();
    }
}
