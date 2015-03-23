/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.session.client.Client;
import com.staalcomputingsolutions.snserver.session.listener.Listener;
import com.staalcomputingsolutions.snserver.session.replier.Replier;
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
