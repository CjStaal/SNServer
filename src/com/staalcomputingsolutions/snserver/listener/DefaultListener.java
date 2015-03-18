/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import java.io.DataInputStream;
import java.io.InputStream;


public class DefaultListener implements Listener {

    private InputStream inputStream;
    private DataInputStream dataInputStream; 
    public DefaultListener(InputStream inputStream){
        this.inputStream = inputStream;
        this.dataInputStream = new DataInputStream(inputStream);
    }
    
    public InputStream getInputStream(){
        return this.inputStream;
    }
    
    public DataInputStream getDataInputStream(){
        return this.dataInputStream;
    }
    
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
