/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.client.ClientInformationFactory;
import com.staalcomputingsolutions.snserver.client.DefaultClient;
import com.staalcomputingsolutions.snserver.listener.DefaultListener;
import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.pinger.DefaultPinger;
import com.staalcomputingsolutions.snserver.pinger.Pinger;
import com.staalcomputingsolutions.snserver.replier.DefaultReplier;
import com.staalcomputingsolutions.snserver.replier.Replier;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class SessionFactory {

    public static Session createSession(Socket socket) throws Exception {

        Listener listener = new DefaultListener(socket.getInputStream());
        Replier replier = new DefaultReplier(socket.getOutputStream());
        Pinger pinger = new DefaultPinger(replier);
        Client client = new DefaultClient(ClientInformationFactory.createInformation(listener, replier));

        SessionContext sessionContext = new DefaultSessionContext();

        sessionContext.setSocket(socket);
        sessionContext.setListener(listener);
        sessionContext.setReplier(replier);
        sessionContext.setPinger(pinger);
        sessionContext.setClient(client);
        
        return new DefaultSession(sessionContext);
    }
}
