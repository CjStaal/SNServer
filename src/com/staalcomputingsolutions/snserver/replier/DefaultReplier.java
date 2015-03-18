/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.replier;

import com.staalcomputingsolutions.snserver.session.Session;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultReplier implements Replier {

    private final OutputStream outputStream;
    private final DataOutputStream dataOutputStream;
    private final Session callback;

    public DefaultReplier(OutputStream outputStream, Session callback) {
        this.outputStream = outputStream;
        this.dataOutputStream = new DataOutputStream(outputStream);
        this.callback = callback;
    }

    @Override
    public void reply(String message) {
        try {
            this.dataOutputStream.writeUTF(message);
        } catch (IOException ex) {
            Logger.getLogger(DefaultReplier.class.getName()).log(Level.SEVERE, null, ex);
            callback.notifyOfReplyError();
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
