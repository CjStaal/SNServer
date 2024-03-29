/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session.context;

import com.staalcomputingsolutions.snserver.model.session.client.Client;
import com.staalcomputingsolutions.snserver.model.session.listener.Listener;
import com.staalcomputingsolutions.snserver.model.session.replier.Replier;
import java.net.Socket;

/**
 * This is the default session context used while creating sessions.
 *
 * @author Charles Joseph Staal
 */
public class DefaultSessionContext implements SessionContext {

    private Socket socket;
    private Client client;
    private Listener listener;
    private Replier replier;
    private String status;

    private final String uuid;

    public DefaultSessionContext() {
        this.uuid = java.util.UUID.randomUUID().toString();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public void setReplier(Replier replier) {
        this.replier = replier;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public Listener getListener() {
        return this.listener;
    }

    @Override
    public Replier getReplier() {
        return this.replier;
    }

    @Override
    public Client getClient() {
        return this.client;
    }

    @Override
    public Socket getSocket() {
        return this.socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public String getUUID() {
        return this.uuid;
    }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return this.status;
    }
}
