/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.messagequeue.MessageQueue;
import com.staalcomputingsolutions.snserver.pinger.Pinger;
import com.staalcomputingsolutions.snserver.replier.Replier;

/**
 *
 * @author Charles Joseph Staal
 */
public interface SessionContext {

    public void addListener(Listener listener);

    public void addReplier(Replier replier);

    public void addMessageQueue(MessageQueue messageQueue);

    public void addPinger(Pinger pinger);

    public void addClient(Client client);

    public Listener getListener();

    public Replier getReplier();

    public MessageQueue getMessageQueue();

    public Pinger getPinger();

    public Client getClient();
    
    public void startPinger();
    
    public void stopPinger();
    
}
