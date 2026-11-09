package com.lldDesignPractice.Elevator;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ElevatorManagement implements Runnable {
    private final List<IElevator> elevators;
    private final List<Floor> floors;
    private final Queue<Request> requests;

    public ElevatorManagement(int numElevators, int numFloors, int first, int last) {
        this.elevators = new ArrayList<>();
        for(int i = 0; i < numElevators; i++) {
            this.elevators.add(new Elevator(first, last));
        }
        this.floors = new ArrayList<>();
        for (int i = 0; i < numFloors; i++) {
            this.floors.add(new Floor(i));
        }
        this.requests = new ArrayDeque<>();
    }

    public void schedule(Request request) {
        requests.add(request);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (!requests.isEmpty()) {
                    System.out.println("Scheduling, number of requests: " + requests.size());
                    Request firstRequest = requests.peek();
                    for (IElevator elevator : elevators) {
                        try {
                            elevator.schedule(firstRequest.getFrom());
                            requests.remove();
                            break;
                        } catch (Exception ex) {

                        }
                    }
                }
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Ending");
                break;
            }
        }
    }
}
