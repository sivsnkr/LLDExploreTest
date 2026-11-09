package com.lldDesignPractice.Elevator;

public class Main {
    public static void main(String[] args) {
        ElevatorManagement elevatorManagement = new ElevatorManagement(2, 10, 0, 10);
        Thread runningThread = new Thread(elevatorManagement);
        runningThread.start();

        elevatorManagement.schedule(new Request(0, Direction.UP));





//        runningThread.interrupt();;
    }
}
