/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.client;

import com.staalcomputingsolutions.snserver.client.computer.Computer;
import com.staalcomputingsolutions.snserver.client.computer.ComputerContainer;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public interface Client {

    public ComputerContainer getComputerContainer();

    public List<Computer> getComputers();

    public void addComputer(Computer computer);

    public void removeComputer(Computer computer);

    public String getName();

    public String getPhoneNumber();
}
