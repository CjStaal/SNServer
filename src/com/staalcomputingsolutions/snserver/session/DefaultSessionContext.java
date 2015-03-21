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
public class DefaultSessionContext implements SessionContext {

    private Socket socket;
    private Client client;
    private Listener listener;
    private Replier replier;

    private final String uuid = java.util.UUID.randomUUID().toString();

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
}
