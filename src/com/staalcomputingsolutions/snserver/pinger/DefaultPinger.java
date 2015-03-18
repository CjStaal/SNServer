/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.pinger;

import com.staalcomputingsolutions.snserver.replier.Replier;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultPinger implements Pinger {

    private final Replier replier;
    private TimerTask task;

    public DefaultPinger(Replier replier) {
        this.replier = replier;
    }
    @Override
    public void startPinger() {
        task = new TimerTask() {
            @Override
            public void run() {
                replier.reply("PING");
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 5000, 5000);
    }

    @Override
    public void stopPinger() {
        task.cancel();
    }
}
