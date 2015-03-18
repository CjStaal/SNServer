/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package serversn;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
class Handler {
    private List<ClientConnection> listeners = new ArrayList();
    
    public Handler(){
        
    }
    
    public void addHandler(ClientConnection clientConnection){
        this.listeners.add(clientConnection);
    }
    
    public void removeHandler(ClientConnection clientConnection){
        this.listeners.remove(clientConnection);
    }
}
