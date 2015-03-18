/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package serversn;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Charles Joseph Staal
 */
class ClientConnection implements AutoCloseable {

    private final Object writeLock = new Object();
    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final Handler handler;

    private ClientInformation clientInformation;

    public ClientConnection(Socket socket, Handler handler) throws IOException {
        this.socket = socket;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.handler = handler;
        this.startPing();
        this.startListener();
    }

    private void startPing() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                sendCommand("PING");
            }
        };

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(task, 5000, 5000);
    }

    /**
     * This sends a command and message to the local server. Parses the command
     * and message in to a single string.
     *
     * @param command The command to the server.
     * @param message The message to the server.
     */
    public void sendCommand(String command, String message) {
        if (message != null && command.equals("HELP") || command.equals("ADD")) {
            command += ":" + message;
        }
        sendCommand(command);
    }

    /**
     * This sends a command to the local server.
     *
     * @param command The command to the server.
     */
    public void sendCommand(String command) {
        try {
            synchronized (writeLock) {
                this.dataOutputStream.writeUTF(command);
                this.dataOutputStream.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            try {
                this.close();
            } catch (Exception ex1) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
    }

    @Override
    public void close() throws Exception {
        this.socket.close();
        this.dataInputStream.close();
        this.dataOutputStream.close();
        JOptionPane.showMessageDialog(null, "PING FAILED, HELP NEEDED " + clientInformation.toString());
        this.handler.removeHandler(this);
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void startListener() {
        new Thread(this::listen).start();
    }

    private void listen() {
        while (true) {
            try {
                String message = this.dataInputStream.readUTF();
                if (message.contains("INFO:")) {
                    String[] info = message.split(":");
                    String name = info[1].split(":")[1];
                    String phoneNumber = info[2].split(":")[1];
                    clientInformation = new ClientInformation(name, phoneNumber);
                } else if (message.contains("ADDC:")) {
                    if (clientInformation != null) {
                        String[] info = message.split(":");
                        String name = info[1].split(":")[1];
                        String localIP = info[2].split(":")[1];
                        clientInformation.addComputer(new Computer(name, localIP));
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
