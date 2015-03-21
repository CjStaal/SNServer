/*
 * Copyright [2015] [Charles Joseph Staal]
 */
package com.staalcomputingsolutions.snserver.session.client;

import com.staalcomputingsolutions.snserver.session.client.computer.Computer;
import com.staalcomputingsolutions.snserver.session.client.computer.ComputerContainer;
import java.util.List;

/**
 *
 * @author Charles Joseph Staal
 */
public class DefaultClient implements Client {

    private final ComputerContainer computerContainer;
    private final ClientInformation clientInformation;

    public DefaultClient(ClientInformation clientInformation) {
        this.clientInformation = clientInformation;
        computerContainer = new ComputerContainer();
    }

    public ClientInformation getClientInformation() {
        return this.clientInformation;
    }

    @Override
    public ComputerContainer getComputerContainer() {
        return this.computerContainer;
    }

    @Override
    public List<Computer> getComputers() {
        return this.computerContainer.getComputers();
    }

    @Override
    public void addComputer(Computer computer) {
        this.computerContainer.addComputer(computer);
    }

    @Override
    public void removeComputer(Computer computer) {
        this.computerContainer.removeComputer(computer);
    }

    @Override
    public String getName() {
        return this.clientInformation.getName();
    }

    @Override
    public String getPhoneNumber() {
        return this.clientInformation.getPhoneNumber();
    }
}
