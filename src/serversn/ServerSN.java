/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package serversn;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author Charles Joseph Staal
 */
public class ServerSN {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Handler handler = new Handler();
        ServerSocket serverSocket = new ServerSocket(1001);
        while(true){
            handler.addHandler(new ClientConnection(serverSocket.accept(), handler));
        }
    }
    
}
