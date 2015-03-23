/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver;

import com.staalcomputingsolutions.snserver.message.executor.DefaultMessageExecutor;
import com.staalcomputingsolutions.snserver.message.executor.MessageExecutor;
import com.staalcomputingsolutions.snserver.sessionhandler.SessionHandler;
import com.staalcomputingsolutions.snserver.message.queue.MessageQueue;
import com.staalcomputingsolutions.snserver.session.SessionFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        SessionHandler sessionHandler = new SessionHandler();
        ServerSocket serverSocket = new ServerSocket(1001);
        MessageQueue mqueue = new MessageQueue(100); //This is used statically. Says it's not used, but it is.
        MessageExecutor mExec = new DefaultMessageExecutor(sessionHandler);
        Thread t = new Thread(mExec);
        t.start();

        while (true) {
            try {
                sessionHandler.addHandler(SessionFactory
                        .createSession(serverSocket.accept()));
            } catch (Exception ex) {
                Logger.getLogger(ServerSN.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
