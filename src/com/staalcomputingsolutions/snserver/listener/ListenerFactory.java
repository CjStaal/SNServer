/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import com.staalcomputingsolutions.snserver.session.Session;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ListenerFactory {

    public static Listener createListener(Socket socket, Session session) throws IOException {
        return new DefaultListener(socket.getInputStream(), session);
    }
}
