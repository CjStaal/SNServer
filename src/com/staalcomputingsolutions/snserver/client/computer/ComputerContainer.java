/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client.computer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class ComputerContainer {
    
    private final List<Computer> computerList;
    
    public ComputerContainer(){
        this.computerList = new ArrayList();
    }
    
    public void addComputer(Computer computer){
        this.computerList.add(computer);
    }
}
