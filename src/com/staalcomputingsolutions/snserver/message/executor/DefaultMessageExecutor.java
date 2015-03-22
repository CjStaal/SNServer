/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.message.executor;

import com.staalcomputingsolutions.snserver.message.Message;
import com.staalcomputingsolutions.snserver.message.queue.MessageQueue;
import com.staalcomputingsolutions.snserver.session.Session;
import com.staalcomputingsolutions.snserver.session.client.computer.Computer;
import com.staalcomputingsolutions.snserver.sessionhandler.SessionHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultMessageExecutor implements MessageExecutor {

    private final SessionHandler sessionHandler;

    public DefaultMessageExecutor(SessionHandler sessionHandler) {
        this.sessionHandler = sessionHandler;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = MessageQueue.take();
                Session session = sessionHandler.retrieveSession(message.getUUID());
                String args0[] = message.getMessage().split(":");
                String args1[] = args0[1].split(";");
                String args2[][] = new String[args0.length][];
                for (int i = 0; i < args1.length; i++) {
                    String temp[] = args1[i].split("=");
                    System.arraycopy(temp, 0, args2[i], 0, temp.length);
                }
                switch (args0[0]) {
                    case "ADDCOMP":
                        if (args2.length == 3
                                && (args2[0][0].equals("UUID")
                                && (args2[1][0].equals("NAME")
                                && (args2[2][0].equals("LOCALIP")
                                && (args2[3][0].equals("STATUS")))))) {
                            session.getClient().getComputerContainer().addComputer(new Computer(args2[0][1], args2[1][1], args2[2][1], args2[3][1]));
                        }
                        break;
                    case "REMCOMP":
                        if (args2.length == 1 && args2[0][0].equals("UUID")) {
                            session.getClient().getComputerContainer().removeComputer(
                                    session.getClient().getComputerContainer().findWithUUID(args2[0][1]));
                        }
                        break;
                    case "UPDCOMP":
                        if (args2.length == 2 && (args2[0][0].equals("UUID")
                                && args2[1][0].equals("STATUS"))) {
                            session.getClient().getComputerContainer().findWithUUID(args2[0][1]).updateStatus(args2[1][1]);
                        }
                        break;
                    case "UPDCLST":
                        if(args2.length == 1 && (args2[0][0].equals("STATUS")))
                            session.updateStatus(args2[0][1]);
                        break;
                    case "UPDCLIE":
                        break;
                    case "REGCLIE":
                        break;
                }
            } catch (Exception ex) {
                Logger.getLogger(DefaultMessageExecutor.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
