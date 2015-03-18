/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.client.ClientFactory;
import com.staalcomputingsolutions.snserver.client.ClientInformation;
import com.staalcomputingsolutions.snserver.client.ClientInformationFactory;
import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.listener.ListenerFactory;
import com.staalcomputingsolutions.snserver.messagequeue.MessageQueue;
import com.staalcomputingsolutions.snserver.messagequeue.MessageQueueFactory;
import com.staalcomputingsolutions.snserver.pinger.Pinger;
import com.staalcomputingsolutions.snserver.pinger.PingerFactory;
import com.staalcomputingsolutions.snserver.replier.Replier;
import com.staalcomputingsolutions.snserver.replier.ReplierFactory;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class SessionFactory {

    public static Session createSession(Socket socket) throws Exception {

        Listener listener = ListenerFactory.createListener(socket);
        Replier replier = ReplierFactory.createReplier(socket);
        MessageQueue messageQueue = MessageQueueFactory.createQueue();
        Pinger pinger = PingerFactory.createPinger(replier);
        ClientInformation clientInformation = ClientInformationFactory.createInformation(listener, replier);
        Client client = ClientFactory.createClient(clientInformation);

        SessionContext sessionContext = new DefaultSessionContext();

        sessionContext.addListener(listener);
        sessionContext.addReplier(replier);
        sessionContext.addMessageQueue(messageQueue);
        sessionContext.addPinger(pinger);
        sessionContext.addClient(client);

        Session session = new DefaultSession(sessionContext);

        return session;
    }

}
