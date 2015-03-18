/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import com.staalcomputingsolutions.snserver.session.Session;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DefaultListener implements Listener{

    private final InputStream inputStream;
    private final DataInputStream dataInputStream;
    private final Session callback;
    
    public DefaultListener(InputStream inputStream, Session callback){
        this.inputStream = inputStream;
        this.dataInputStream = new DataInputStream(inputStream);
        this.callback = callback;
    }
    
    @Override
    public InputStream getInputStream(){
        return this.inputStream;
    }
    
    @Override
    public DataInputStream getDataInputStream(){
        return this.dataInputStream;
    }
    
    @Override
    public String listen(){
        try {
            return dataInputStream.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(DefaultListener.class.getName()).log(Level.SEVERE, null, ex);
            callback.notifyListenError();
        }
        return null;
    }
}
