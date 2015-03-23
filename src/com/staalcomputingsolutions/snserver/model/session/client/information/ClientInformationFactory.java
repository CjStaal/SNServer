/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.model.session.client.information;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * This creates the client information used in the client object.
 *
 * @author Charles Joseph Staal
 */
public class ClientInformationFactory {

    public static ClientInformation createInformation(DataInputStream dataInputStream, DataOutputStream dataOutputStream) throws IOException, Exception {
        dataOutputStream.writeUTF("READY");
        String[] info = dataInputStream.readUTF().split(":");
        if (info[0].equals("INFO")) {
            String[] info1 = info[1].split(";");
            
            return new DefaultClientInformation(info1[0].split("=")[1], info1[1].split("=")[1]);
        }
        throw new Exception("Could not get information for client.");
    }
}
