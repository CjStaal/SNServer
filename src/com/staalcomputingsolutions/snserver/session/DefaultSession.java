/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;


/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultSession implements Session{
    private SessionContext sessionContext;
    
    public DefaultSession(SessionContext sessionContext){
        this.sessionContext = sessionContext;
    }
}
