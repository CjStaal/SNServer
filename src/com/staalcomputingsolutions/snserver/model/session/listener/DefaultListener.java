/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session.listener;

import com.staalcomputingsolutions.snserver.model.message.Message;
import com.staalcomputingsolutions.snserver.model.message.queue.MessageQueue;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the default listener object. It listens for a sessions input.
 *
 * @author Charles Joseph Staal
 */
public class DefaultListener implements Listener {

    private final InputStream inputStream;
    private final DataInputStream dataInputStream;
    private final String uuid;
    private Thread t;

    public DefaultListener(InputStream inputStream, String uuid) {
        this.inputStream = inputStream;
        this.dataInputStream = new DataInputStream(inputStream);
        this.uuid = uuid;
    }

    @Override
    public InputStream getInputStream() {
        return this.inputStream;
    }

    @Override
    public DataInputStream getDataInputStream() {
        return this.dataInputStream;
    }

    public void startListening() {
        t = new Thread(this::listen);
        t.start();
    }

    public void stopListening() {
        t.stop();
    }

    private void listen() {
        try {
            while (true) {
                MessageQueue.addToQueue(new Message(uuid, dataInputStream.readUTF()));
            }
        } catch (IOException ex) {
            Logger.getLogger(DefaultListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
