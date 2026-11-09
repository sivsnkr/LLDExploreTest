package com.lldDesignPractice.Elevator;

public class StoppedElevatorState extends ElevatorStateBase {

    public StoppedElevatorState(Elevator elevator) {
        super(elevator);
    }

    @Override
    public void schedule(int floor) {
        if(this.elevatorCore.getCurrentDirection() == Direction.DOWN) {
            if(floor > this.elevatorCore.getCurrentFloor()) {
                throw new IllegalArgumentException("Elevator cannot be scheduled");
            }
            this.elevatorCore.scheduleCore(floor);
        }else {
            if(floor < this.elevatorCore.getCurrentFloor()) {
                throw new IllegalArgumentException("Elevator cannot be scheduled");
            }
            this.elevatorCore.scheduleCore(floor);
        }
    }
}
