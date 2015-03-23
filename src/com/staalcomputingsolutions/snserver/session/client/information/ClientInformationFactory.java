/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client.information;

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
            return new DefaultClientInformation(info[1].split(";")[1], info[2].split(";")[1]);
        }
        throw new Exception("Could not get information for client.");
    }
}
