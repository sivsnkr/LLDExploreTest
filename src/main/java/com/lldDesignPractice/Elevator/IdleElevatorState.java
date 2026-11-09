package com.lldDesignPractice.Elevator;

public class IdleElevatorState extends ElevatorStateBase {

    public IdleElevatorState(Elevator elevatorCore) {
        super(elevatorCore);
    }

    @Override
    public void schedule(int floor) {
        if(this.elevatorCore.getCurrentFloor() < floor) {
            this.elevatorCore.setCurrentDirection(Direction.UP);
            this.elevatorCore.scheduleCore(floor);
        } else {
            this.elevatorCore.setCurrentDirection(Direction.DOWN);
            this.elevatorCore.scheduleCore(floor);
        }
        System.out.println("Elevator scheduled for floor: " + floor);
    }
}
