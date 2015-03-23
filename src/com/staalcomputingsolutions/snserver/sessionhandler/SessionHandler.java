/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.sessionhandler;

import com.staalcomputingsolutions.snserver.session.Session;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the session handler object. It stores, removes, and retrieves
 * sessions.
 *
 * @author Charles Joseph Staal
 */
public class SessionHandler {

    private final List<Session> sessions;

    public SessionHandler() {
        this.sessions = new ArrayList();
    }

    public void addHandler(Session session) {
        this.sessions.add(session);
    }

    public void removeHandler(Session session) {
        this.sessions.remove(session);
    }

    public Session retrieveSession(String uuid) throws Exception {
        for (Session session : sessions) {
            if (session.getUUID().equals(uuid)) {
                return session;
            }
        }
        throw new Exception("UUID does not correspond to a session.");
    }
}
