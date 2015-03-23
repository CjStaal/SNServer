/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.context;

import com.staalcomputingsolutions.snserver.session.client.Client;
import com.staalcomputingsolutions.snserver.session.listener.Listener;
import com.staalcomputingsolutions.snserver.session.replier.Replier;
import java.net.Socket;

/**
 * This is the interface that default session context uses.
 *
 * @author Charles Joseph Staal
 */
public interface SessionContext {

    public Listener getListener();

    public Replier getReplier();

    public Client getClient();

    public Socket getSocket();

    public String getUUID();

    public void setStatus(String status);

    public String getStatus();
}
