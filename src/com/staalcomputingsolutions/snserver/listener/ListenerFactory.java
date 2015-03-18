/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ListenerFactory {
    
    public static Listener createListener(Socket socket) throws IOException{
        Listener temp = new DefaultListener(socket.getInputStream());
        return temp;
    }
}
