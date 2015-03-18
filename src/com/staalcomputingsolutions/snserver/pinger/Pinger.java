/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.pinger;

/**
 * This uses multicast and pings all the sessions, homie.
 *
 * @author Charles Joseph Staal
 */
public interface Pinger {

    public void startPinger();

    public void stopPinger();
}
