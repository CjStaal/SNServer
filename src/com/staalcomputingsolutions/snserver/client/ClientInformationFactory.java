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

    public static ClientInformation createInformation(Listener listener, Replier replier) throws IOException, Exception {
        for (int i = 0; i < 3; i++) {
            replier.reply("READY");
            String[] info = listener.listen().split(":");
            if (info[0].equals("INFO")) {
                return new DefaultClientInformation(info[1].split(":")[1], info[2].split(":")[1]);
            }
        }
        throw new Exception("Could not get information for client.");
    }
}
