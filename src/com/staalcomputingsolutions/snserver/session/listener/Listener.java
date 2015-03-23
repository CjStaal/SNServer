/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.listener;

import java.io.DataInputStream;
import java.io.InputStream;

/**
 * This is the interface that default listener uses.
 *
 * @author Charles Joseph Staal
 */
public interface Listener {

    public InputStream getInputStream();

    public DataInputStream getDataInputStream();
}
