/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.replier;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ReplierFactory {

    public static Replier createReplier(Socket socket) throws IOException {
        return new DefaultReplier(socket.getOutputStream());
    }
}
