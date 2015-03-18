/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver;

import com.staalcomputingsolutions.snserver.session.Session;
import com.staalcomputingsolutions.snserver.session.SessionFactory;
import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ServerSN {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        SessionHandler handler = new SessionHandler();
        ServerSocket serverSocket = new ServerSocket(1001);
        while(true){
            Session session = SessionFactory
                    .createSession(serverSocket.accept());
        }
    }
    
}