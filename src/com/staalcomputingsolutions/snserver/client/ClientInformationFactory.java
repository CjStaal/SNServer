/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.replier.Replier;
import java.io.IOException;

/**
 *
 * @author Charles Joseph Staal
 */
public class ClientInformationFactory {

    public static ClientInformation createInformation(Listener listener, Replier replier) throws IOException {
        replier.reply("READY");
        String[] info = listener.listen().split(":");
        return new DefaultClientInformation(info[1].split(":")[1], info[2].split(":")[1]);
    }
}
