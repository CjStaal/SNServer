/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.messagequeue;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.listener.Listener;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultMessageQueue implements MessageQueue{
    private final Listener listener;
    private final Queue<String> messageQueue;
    private final Client client;
    public DefaultMessageQueue(Listener listener, Client callback){
        this.messageQueue = new LinkedList();
        this.listener = listener;
        this.client  = callback;
    }
    
    private void addToQueue(String message){
        this.messageQueue.add(message);
    }
    
    @Override
    public void run(){
        while(true){
            try {
                this.addToQueue(listener.listen());
                this.callBack();
            } catch (IOException ex) {
                Logger.getLogger(DefaultMessageQueue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
    private void callBack(){
        client.notifyOfMessage();
    }
}
