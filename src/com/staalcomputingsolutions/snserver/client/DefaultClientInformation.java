/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

import com.staalcomputingsolutions.snserver.client.computer.Computer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultClientInformation implements ClientInformation {
    private final List<Computer> computerList = new ArrayList();
    
    private final String name, phoneNumber;
    
    public DefaultClientInformation(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public String getName(){
        return this.name;
    }
    
    @Override
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.getName() + "\nPhone number: " + this.getPhoneNumber();
    }

    @Override
    public void addComputer(Computer computer) {
        this.computerList.add(computer);
    }
}
