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
public interface SessionContext {

    public void setListener(Listener listener);

    public void setReplier(Replier replier);

    public void setPinger(Pinger pinger);

    public void setClient(Client client);

    public Listener getListener();

    public Replier getReplier();

    public Pinger getPinger();

    public Client getClient();

    public void startPinger();

    public void stopPinger();

    public Socket getSocket();

    public void setSocket(Socket socket);
}
