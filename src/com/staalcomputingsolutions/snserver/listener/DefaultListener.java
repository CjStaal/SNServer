/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;


public class DefaultListener implements Listener{

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
    
    public String listen() throws IOException{
        return dataInputStream.readUTF();
    }
    
}
