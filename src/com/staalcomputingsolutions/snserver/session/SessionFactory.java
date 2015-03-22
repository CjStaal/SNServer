/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.session.context.DefaultSessionContext;
import com.staalcomputingsolutions.snserver.session.client.Client;
import com.staalcomputingsolutions.snserver.session.client.information.ClientInformationFactory;
import com.staalcomputingsolutions.snserver.session.client.DefaultClient;
import com.staalcomputingsolutions.snserver.session.listener.DefaultListener;
import com.staalcomputingsolutions.snserver.session.listener.Listener;
import com.staalcomputingsolutions.snserver.session.replier.DefaultReplier;
import com.staalcomputingsolutions.snserver.session.replier.Replier;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class SessionFactory {

    public static Session createSession(Socket socket) throws Exception {

        DefaultSessionContext sessionContext = new DefaultSessionContext();

        Listener listener = new DefaultListener(socket.getInputStream(), sessionContext.getUUID());
        Replier replier = new DefaultReplier(socket.getOutputStream());
        Client client = new DefaultClient(ClientInformationFactory.createInformation(listener, replier));

        sessionContext.setSocket(socket);
        sessionContext.setListener(listener);
        sessionContext.setReplier(replier);
        sessionContext.setClient(client);
        sessionContext.setStatus("OK");
        
        return new DefaultSession(sessionContext);
    }
}
