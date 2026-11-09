package com.lldDesignPractice.Elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator implements IElevator {
    private Direction currentDirection;
    private final List<Integer> stops;
    private final int first;
    private final int last;
    private int currentFloor;
    private IElevator state;


    public Elevator(int first, int last) {
        this.currentDirection = Direction.IDLE;
        this.stops = new ArrayList<>();
        this.first = first;
        this.last = last;
        this.currentFloor = first;
        this.state = new IdleElevatorState(this);

    }

    public boolean canSchedule(int floor) {
        if(floor > last || floor < first) return  false;
        if(currentDirection == Direction.IDLE) return true;
        if(currentDirection == Direction.DOWN) {
            return floor <= currentFloor;
        }
        return floor >= currentFloor;
    }

    @Override
    public void schedule(int floor) {
        state.schedule(floor);
    }

    void scheduleCore(int floor) {
        if(canSchedule(floor))
            this.stops.add(floor);
    }

    void setElevatorState(IElevator elevatorState) {
        this.state = elevatorState;
    }

    int getCurrentFloor() {
        return this.currentFloor;
    }

    void setCurrentDirection(Direction direction) {
        this.currentDirection = direction;
    }

    Direction getCurrentDirection() {
        return this.currentDirection;
    }
}
