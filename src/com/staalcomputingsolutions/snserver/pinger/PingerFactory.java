/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.pinger;

import com.staalcomputingsolutions.snserver.replier.Replier;

/**
 *
 * @author Charles Joseph Staal
 */
public class PingerFactory {

    public static Pinger createPinger(Replier replier) {
        return new DefaultPinger(replier);
    }
    
}
