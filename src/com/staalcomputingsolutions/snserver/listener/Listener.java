/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.listener;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Charles Joseph Staal
 */
public interface Listener {

    public InputStream getInputStream();

    public DataInputStream getDataInputStream();

    public String listen() throws IOException;
}
