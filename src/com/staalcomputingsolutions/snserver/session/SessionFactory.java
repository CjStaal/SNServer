/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.session.context.DefaultSessionContext;
import com.staalcomputingsolutions.snserver.session.client.information.ClientInformationFactory;
import com.staalcomputingsolutions.snserver.session.client.DefaultClient;
import com.staalcomputingsolutions.snserver.session.listener.DefaultListener;
import com.staalcomputingsolutions.snserver.session.replier.DefaultReplier;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * This creates a session.
 *
 * @author Charles Joseph Staal
 */
public class SessionFactory {

    public static Session createSession(Socket socket) throws Exception {

        DefaultSessionContext sessionContext = new DefaultSessionContext();

        DefaultClient client = new DefaultClient(ClientInformationFactory.createInformation(new DataInputStream(socket.getInputStream()), new DataOutputStream(socket.getOutputStream())));

        DefaultReplier replier = new DefaultReplier(socket.getOutputStream());
        DefaultListener listener = new DefaultListener(socket.getInputStream(), sessionContext.getUUID());

        listener.startListening();

        sessionContext.setSocket(socket);
        sessionContext.setListener(listener);
        sessionContext.setReplier(replier);
        sessionContext.setClient(client);
        sessionContext.setStatus("OK");

        return new DefaultSession(sessionContext);
    }
}
