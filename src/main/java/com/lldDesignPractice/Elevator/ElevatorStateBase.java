package com.lldDesignPractice.Elevator;

public abstract class ElevatorStateBase implements IElevator {

    protected final Elevator elevatorCore;

    public ElevatorStateBase(Elevator elevatorCore) {
        this.elevatorCore = elevatorCore;
    }

    protected void setElevatorState(ElevatorStateBase state) {
        elevatorCore.setElevatorState(state);
    }
}
