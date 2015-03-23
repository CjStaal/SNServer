/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.replier;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the default replier object. It is used to send replies to clients.
 *
 * @author Charles Joseph Staal
 */
public class DefaultReplier implements Replier {

    private final OutputStream outputStream;
    private final DataOutputStream dataOutputStream;

    public DefaultReplier(OutputStream outputStream) {
        this.outputStream = outputStream;
        this.dataOutputStream = new DataOutputStream(outputStream);
    }

    @Override
    public void reply(String message) {
        try {
            this.dataOutputStream.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(DefaultReplier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override
    public DataOutputStream getDataOutputStream() {
        return this.dataOutputStream;
    }
}
