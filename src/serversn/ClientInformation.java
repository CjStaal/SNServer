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
class ClientInformation {
    
    private final List<Computer> computerList = new ArrayList();
    
    private final String name, phoneNumber;
    
    public ClientInformation(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    @Override
    public String toString(){
        return "Name: " + this.getName() + "\nPhone number: " + this.getPhoneNumber();
    }

    public void addComputer(Computer computer) {
        this.computerList.add(computer);
    }
}
