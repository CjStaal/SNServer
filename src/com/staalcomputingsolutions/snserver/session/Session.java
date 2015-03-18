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
public interface Session {

    public void notifyOfMessage();

    public Listener getListener();

    public Replier getReplier();

    public MessageQueue addMessageQueue();

    public Pinger getPinger(Pinger pinger);

    public Client getClient();

    public void startPinger();

    public void stopPinger();

    public Socket getSocket();
}
