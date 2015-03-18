/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session;

import com.staalcomputingsolutions.snserver.client.Client;
import com.staalcomputingsolutions.snserver.listener.Listener;
import com.staalcomputingsolutions.snserver.messagequeue.MessageQueue;
import com.staalcomputingsolutions.snserver.pinger.Pinger;
import com.staalcomputingsolutions.snserver.replier.Replier;
import java.net.Socket;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultSessionContext implements SessionContext {

    private Socket socket;
    private Client client;
    private Listener listener;
    private Replier replier;
    private MessageQueue messageQueue;
    private Pinger pinger;
}
