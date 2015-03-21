/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.message.executor;

import com.staalcomputingsolutions.snserver.message.Message;
import com.staalcomputingsolutions.snserver.message.queue.MessageQueue;
import com.staalcomputingsolutions.snserver.session.Session;
import com.staalcomputingsolutions.snserver.sessionhandler.SessionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultMessageExecutor implements MessageExecutor{
    private final SessionHandler sessionHandler;
    
    public DefaultMessageExecutor(SessionHandler sessionHandler){
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void run() {
        while(true){
            try {
                Message message = MessageQueue.take();
                String msg = message.getMessage();
                Session session = sessionHandler.retrieveSession(message.getUUID());
                
            } catch (Exception ex) {
                Logger.getLogger(DefaultMessageExecutor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
}
