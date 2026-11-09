package com.lldDesignPractice.Elevator;

public class MovingElevatorState extends ElevatorStateBase {

    public MovingElevatorState(Elevator elevatorCore) {
        super(elevatorCore);
    }

    @Override
    public void schedule(int floor) {
        throw new IllegalStateException("Elevator is moving");
    }
}
