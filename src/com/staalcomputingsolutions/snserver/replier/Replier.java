/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.replier;

import java.io.DataOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Charles Joseph Staal
 */
public interface Replier {

    public void reply(String message);

    public OutputStream getOutputStream();

    public DataOutputStream getDataOutputStream();
}
