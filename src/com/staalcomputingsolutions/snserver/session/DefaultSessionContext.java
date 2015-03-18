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
public class DefaultSessionContext implements SessionContext {

    private Socket socket;
    private Client client;
    private Listener listener;
    private Replier replier;
    private MessageQueue messageQueue;
    private Pinger pinger;

    @Override
    public void addListener(Listener listener) {
        this.listener = listener;
    }

    @Override
    public void addReplier(Replier replier) {
        this.replier = replier;
    }

    @Override
    public void addMessageQueue(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    @Override
    public void addPinger(Pinger pinger) {
        this.pinger = pinger;
    }

    @Override
    public void addClient(Client client) {
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
    public MessageQueue getMessageQueue() {
        return this.messageQueue;
    }

    @Override
    public Pinger getPinger() {
        return this.pinger;
    }

    @Override
    public Client getClient() {
        return this.client;
    }
    
    @Override
    public void startPinger(){
        pinger.startPinger();
    }
    
    @Override
    public void stopPinger(){
        pinger.stopPinger();
    }
}
