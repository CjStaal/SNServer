/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client.information;

import com.staalcomputingsolutions.snserver.session.listener.Listener;
import com.staalcomputingsolutions.snserver.session.replier.Replier;
import java.io.IOException;

/**
 *
 * @author Charles Joseph Staal
 */
public class ClientInformationFactory {

    public static ClientInformation createInformation(Listener listener, Replier replier) throws IOException, Exception {
        replier.reply("READY");
        String[] info = listener.listen().split(":");
        if (info[0].equals("INFO")) {
            return new DefaultClientInformation(info[1].split(";")[1], info[2].split(";")[1]);
        }
        throw new Exception("Could not get information for client.");
    }
}
