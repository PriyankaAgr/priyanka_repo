import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 10 floor
 * 3 elev
 * 0 7 2 5
 */

public class ElevatorDesign {

    public static void main(String[] args) {


        Elevator elevator = new Elevator("E1", 0);

        Elevator elevator2 = new Elevator("E2", 5);
        Elevator elevator3 = new Elevator("E3", 7);
// 5  7   upq
// 2  1 dq



        ElevatorController elevatorController = new ElevatorController();
        elevatorController.addElevator(elevator);
        elevatorController.addElevator(elevator2);
        elevatorController.addElevator(elevator3);
        Request upRequest1 = new Request(2, 5, Direction.UP, Location.INSIDE_ELEVATOR);

        Elevator chosenElev = elevatorController.findClosestElevator(upRequest1);
        System.out.println("The request " + upRequest1.desiredFloorNo + " will be processed by-> " + chosenElev.name + " which is currently at floor -> "+ chosenElev.currentFloor);
        elevator.sendUpRequest(upRequest1);

        Request upRequest2 = new Request(1, 3, Direction.UP, Location.INSIDE_ELEVATOR);
        chosenElev = elevatorController.findClosestElevator(upRequest2);
        System.out.println("The request " + upRequest2.desiredFloorNo + " will be processed by-> " + chosenElev.name + " which is currently at floor -> "+ chosenElev.currentFloor);
        chosenElev.sendUpRequest(upRequest2);

        Request downRequest1 = new Request(5, 1, Direction.DOWN, Location.INSIDE_ELEVATOR);
        chosenElev = elevatorController.findClosestElevator(downRequest1);
        System.out.println("The request " + downRequest1.desiredFloorNo + " will be processed by-> " + chosenElev.name + " which is currently at floor -> "+ chosenElev.currentFloor);
        chosenElev.sendDownRequest(downRequest1);

        Request downRequest2 = new Request(8, 2, Direction.DOWN, Location.INSIDE_ELEVATOR);
        chosenElev = elevatorController.findClosestElevator(downRequest2);
        System.out.println("The request " + downRequest2.desiredFloorNo + " will be processed by-> " + chosenElev.name + " which is currently at floor -> "+ chosenElev.currentFloor);
        chosenElev.sendDownRequest(downRequest2);
        chosenElev.run();

        Request downRequest3 = new Request(4, 0, Direction.DOWN, Location.OUTSIDE_ELEVATOR);
        chosenElev = elevatorController.findClosestElevator(downRequest3);
        System.out.println("The request " + downRequest3.desiredFloorNo + " will be processed by-> " + chosenElev.name + " which is currently at floor -> "+ chosenElev.currentFloor);
        chosenElev.sendDownRequest(downRequest3);



        chosenElev.run();

        //5 3 2 7 10 1 -2 -1
        //5 7 10 3 2 1 -1 -2

        System.out.println("The current state of elevator is "+ elevator.displayIdleState());




    }


}

class Elevator{
    String name;
    int currentFloor;
    Direction direction;
    PriorityQueue<Request> upQ;
    PriorityQueue<Request> downQ;

    Elevator(String name,int floorNo){
        this.name = name;
        this.currentFloor=floorNo;
        this.direction=Direction.IDLE;
        upQ = new PriorityQueue<>((a,b)-> a.desiredFloorNo-b.desiredFloorNo);
        downQ = new PriorityQueue<>((a,b)-> b.desiredFloorNo-a.desiredFloorNo);

    }


    void sendUpRequest(Request req){
        upQ.add(req);
    }

    void sendDownRequest(Request req){
        downQ.add(req);
    }

    public void run() {
        while (!upQ.isEmpty() || !downQ.isEmpty()) {
            processRequest();
        }
        System.out.println("Finished All Requests!");
        this.direction=Direction.IDLE;
    }

    void processRequest() {
        if (this.direction == Direction.UP || this.direction == Direction.IDLE) {
            processUpRequest();
            processDownRequest();
        } else {
            processDownRequest();
            processUpRequest();
        }
    }

    //
    private void processUpRequest() {
        while (!upQ.isEmpty()) {
            Request upRequest = upQ.poll();
            // Communicate with hardware
            this.currentFloor = upRequest.desiredFloorNo;
            System.out.println("Processing up requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!downQ.isEmpty()) {
            this.direction = Direction.DOWN;
        } else {
            this.direction = Direction.IDLE;
        }
    }

    private void processDownRequest() {
        while (!downQ.isEmpty()) {
            Request downRequest = downQ.poll();
            // Communicate with hardware
            this.currentFloor = downRequest.desiredFloorNo;
            System.out.println("Processing down requests. Elevator stopped at floor " + this.currentFloor + ".");
        }
        if (!upQ.isEmpty()) {
            this.direction = Direction.UP;
        } else {
            this.direction = Direction.IDLE;
        }
    }



    int displayIdleState(){
        return this.currentFloor;
    }



}

enum Direction{
    UP,
    DOWN,
    IDLE;
}

class Request{
    int currentFLoor;
    int desiredFloorNo;
    Direction direction;
    Location location;

    Request(int currentFLoor, int desiredFloorNo, Direction direction, Location location){
        this.currentFLoor = currentFLoor;
        this.desiredFloorNo = desiredFloorNo;
        this.direction = direction;
        this.location = location;
    }



}

class UpReq extends Request{


    UpReq(int currentFLoor, int desiredFloorNo, Direction direction, Location location) {
        super(currentFLoor, desiredFloorNo, direction, location);
    }
}

class DownReq extends Request{


    DownReq(int currentFLoor, int desiredFloorNo, Direction direction, Location location) {
        super(currentFLoor, desiredFloorNo, direction, location);
    }
}



enum Location{

    INSIDE_ELEVATOR,
    OUTSIDE_ELEVATOR;
}

class ElevatorController{

    List<Elevator> elevators = new ArrayList<>();
    Elevator defaultElevator = new Elevator("E0", 0);

    void addElevator(Elevator elevator){
        elevators.add(elevator);
    }
    Elevator findClosestElevator(Request req){
        int desiredFloor= req.desiredFloorNo;
        int min = Integer.MAX_VALUE;
        Elevator closest = defaultElevator;
        for(Elevator e : elevators) {
            if (Math.abs(e.currentFloor - desiredFloor) < min) {
                min = Math.abs(e.currentFloor-desiredFloor);
                closest = e;


            }
        }
        return closest;

        }
    }

//closest elevator-> considering direction

