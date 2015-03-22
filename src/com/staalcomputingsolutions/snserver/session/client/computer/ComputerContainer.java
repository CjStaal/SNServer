/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client.computer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class ComputerContainer {

    private final List<Computer> computerList;

    public ComputerContainer() {
        this.computerList = new ArrayList();
    }

    public void addComputer(Computer computer) {
        this.computerList.add(computer);
    }

    public List<Computer> getComputers() {
        return this.computerList;
    }

    public void removeComputer(Computer computer) {
        this.computerList.remove(computer);
    }
    
    public Computer findWithUUID(String uuid) throws Exception{
        for(Computer computer : computerList){
            if(computer.getUUID().equals(uuid)){
                return computer;
            }
        }
        throw new Exception("Could not find computer pertaining to UUID");
    }

    public void RemoveComputer(Computer computer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
