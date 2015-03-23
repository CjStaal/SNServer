/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session;

import com.staalcomputingsolutions.snserver.model.session.client.Client;
import com.staalcomputingsolutions.snserver.model.session.listener.Listener;
import com.staalcomputingsolutions.snserver.model.session.replier.Replier;
import java.net.Socket;

/**
 * This is the interface the default session object uses.
 *
 * @author Charles Joseph Staal
 */
public interface Session {

    public Listener getListener();

    public Replier getReplier();

    public Client getClient();

    public Socket getSocket();

    public String getUUID();

    public void updateStatus(String status);

    public String getStatus();
}
