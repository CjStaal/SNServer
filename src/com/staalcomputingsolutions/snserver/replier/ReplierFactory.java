/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.replier;

import com.staalcomputingsolutions.snserver.session.Session;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ReplierFactory {

    public static Replier createReplier(Socket socket, Session session) throws IOException {
        return new DefaultReplier(socket.getOutputStream(), session);
    }
}
