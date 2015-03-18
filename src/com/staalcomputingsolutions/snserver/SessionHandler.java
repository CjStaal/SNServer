/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver;

import com.staalcomputingsolutions.snserver.session.Session;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class SessionHandler {
    private List<Session> listeners = new ArrayList();
    
    public SessionHandler(){
        
    }
    
    public void addHandler(Session session){
        this.listeners.add(session);
    }
    
    public void removeHandler(Session session){
        this.listeners.remove(session);
    }
}
