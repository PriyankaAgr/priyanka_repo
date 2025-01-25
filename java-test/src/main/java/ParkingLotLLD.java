import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotLLD {

    public static void main(String[] args) throws Exception {

        ParkingSpotFactoryManager spotManager = new ParkingSpotFactoryManager();
        ParkingSpot spot = new ParkingSpot(1234, ParkingSpotType.LARGE, 1, Boolean.TRUE);
        spotManager.addParkingSpot(spot);
        ParkingLot parkingLot = ParkingLot.createParkingLotInstance();
        parkingLot.createRateCard();
        VehicleFactory vehicleFactory = new CarImplementation();
        Car car = (Car) vehicleFactory.createVehicle();
        spot.assignVehicle(car);

        ParkingTicket ticket = parkingLot.getNewParkingTicket(car);
        double fare = parkingLot.calculateFare(ticket, car.vehicleType);
        System.out.println("The total fare to be paid is "+ fare);

    }

}

class ParkingSpot{

    int spotId;
    Vehicle vehicle;
    ParkingSpotType spotType;
    int floor;
    boolean isSpotAvailable;

    public ParkingSpot(int spotId, ParkingSpotType spotType, int floor, boolean isSpotAvailable) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.floor = floor;
        this.isSpotAvailable = isSpotAvailable;
    }

    public boolean assignVehicle(Vehicle vehicle){
        if(!isSpotAvailable) return false;

        this.vehicle = vehicle;
        vehicle.spotId=spotId;
        isSpotAvailable=false;
        return true;
    }

    public boolean removeVehicle(){
        this.vehicle = null;
        this.isSpotAvailable=true;
        return true;

    }

}

class ParkingTicket{
    String ticketNo;
    Long entryTimeStamp;
    Long exitTimeStamp;
    Map<String, Double> rateCard;
    String vehRegNo;
    int parkSpotId;
    Double fare;
    ParkingTicketStatus status;


    ParkingTicket(String ticketNo, Long entryTimeStamp){
        this.ticketNo=ticketNo;
        this.entryTimeStamp = entryTimeStamp;
    }
    public String getTicketNo() {
        return ticketNo;
    }

    public void setTicketNo(String ticketNo) {
        this.ticketNo = ticketNo;
    }

    public Long getEntryTimeStamp() {
        return entryTimeStamp;
    }

    public void setEntryTimeStamp(Long entryTimeStamp) {
        this.entryTimeStamp = entryTimeStamp;
    }

    public Long getExitTimeStamp() {
        return exitTimeStamp;
    }

    public void setExitTimeStamp(Long exitTimeStamp) {
        this.exitTimeStamp = exitTimeStamp;
    }

    public Map<String, Double> getRateCard() {
        return rateCard;
    }

    public void setRateCard(Map<String, Double> rateCard) {
        this.rateCard = rateCard;
    }

    public String getVehRegNo() {
        return vehRegNo;
    }

    public void setVehRegNo(String vehRegNo) {
        this.vehRegNo = vehRegNo;
    }

    public int getParkSpotId() {
        return parkSpotId;
    }

    public void setParkSpotId(int parkSpotId) {
        this.parkSpotId = parkSpotId;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public ParkingTicketStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingTicketStatus status) {
        this.status = status;
    }
}

class Vehicle{
    int vehicleId;
    String regNo;
    VehicleType vehicleType;
    int spotId;

    public Vehicle(int vehicleId, String regNo, VehicleType vehicleType) {
        this.vehicleId = vehicleId;
        this.regNo = regNo;
        this.vehicleType = vehicleType;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getSpotId() {
        return spotId;
    }

    public void setSpotId(int spotId) {
        this.spotId = spotId;
    }

    public ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType){
        switch (vehicleType) {
            case TRUCK:
            case VAN:
                return ParkingSpotType.LARGE;
            case MOTORBIKE:
                return ParkingSpotType.MOTORBIKE;
            case CAR:
                return ParkingSpotType.COMPACT;
            case ELECTRIC:
                return ParkingSpotType.ELECTRIC;
            default:
                return ParkingSpotType.COMPACT;
        }
    }
}


class Car extends Vehicle{

    public Car(int vehicleId, String regNo, VehicleType category) {
        super(vehicleId, regNo, category);
    }
}

class MotorBike extends Vehicle{

    public MotorBike(int vehicleId, String regNo, VehicleType category) {
        super(vehicleId, regNo, category);
    }
}


class ParkingSpotFactoryManager{

    List<ParkingSpot> spots;

    ParkingSpotFactoryManager(){
        spots=new ArrayList<>();
    }



   void removeParkingSpot(ParkingSpot parkingSpot){
       spots.remove(parkingSpot);
   }


   int addParkingSpot(ParkingSpot parkingSpot){
       spots.add(parkingSpot);
       return parkingSpot.spotId;
   }

   void addParkingFloor(){

   }



}

class ParkingLot{

    private static ParkingLot instance;
    private String name;
    //private Address address;
    private Map<VehicleType, Map<TicketRule, Integer>> parkingRateCard;
    private Map<String, ParkingFloor> parkingFloors;
   // private Map<String, EntrancePanel> entrancePanels;
   // private Map<String, ExitPanel> exitPanels;
    private Map<String, ParkingTicket> activeTickets;
    private Map<VehicleType, Integer> reservedSpace;
    int limit=10;

    public ParkingLot(String name) {
        this.name = name;
        this.parkingRateCard = new HashMap<>();
        this.parkingFloors = new HashMap<>();
        this.activeTickets = new HashMap<>();
        this.reservedSpace = new HashMap<>();
    }

    static ParkingLot createParkingLotInstance(){
        return new ParkingLot("ParkingLotInstance1");
    }

    public boolean incrementSpotCount(VehicleType vehicleType){
        if(reservedSpace.getOrDefault(vehicleType,0)< limit) {
            reservedSpace.put(vehicleType, reservedSpace.getOrDefault(vehicleType, 0) + 1);
            return true;
        }
        return false;

    }

    public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws Exception {
        if (this.isFull(vehicle.getVehicleType())) {
            throw new Exception("Parking full for vehicle type: " + vehicle.getVehicleType());
        }

        ParkingTicket ticket = new ParkingTicket("101", System.currentTimeMillis());
        ticket.setVehRegNo(vehicle.getRegNo());
       // ticket.saveInDB();
        incrementSpotCount(vehicle.getVehicleType());
        activeTickets.put(ticket.getTicketNo(), ticket);
        return ticket;
    }

//vehtype duration
    void createRateCard(){
        parkingRateCard= new HashMap<>();
        Map<TicketRule, Integer> XLVehicle = new HashMap<>();
        XLVehicle.put(TicketRule.DEFAULT, 100);//first 3 hr
        XLVehicle.put(TicketRule.HOURLY, 70); //after 3 hr ph rate
        Map<TicketRule, Integer> bigVehicle = new HashMap<>();
        bigVehicle.put(TicketRule.DEFAULT, 80);//first 3 hr
        bigVehicle.put(TicketRule.HOURLY, 50); //after 3 hr ph rate
        Map<TicketRule, Integer> smallVehicle = new HashMap<>();
        smallVehicle.put(TicketRule.DEFAULT, 50);
        smallVehicle.put(TicketRule.HOURLY, 30);
        parkingRateCard.put(VehicleType.CAR, bigVehicle);
        parkingRateCard.put(VehicleType.MOTORBIKE, smallVehicle);
        parkingRateCard.put(VehicleType.TRUCK, XLVehicle);

    }

    boolean isFull(VehicleType vehicleType){
        if(reservedSpace.getOrDefault(vehicleType, 0)>=limit) return true;
        return false;
    }

    public double calculateFare(ParkingTicket ticket, VehicleType type){
        ticket.exitTimeStamp=System.currentTimeMillis();
        long duration = (ticket.exitTimeStamp-ticket.entryTimeStamp)/1000;
        Map<TicketRule, Integer> hm =parkingRateCard.get(type);
        double fare = hm.get(TicketRule.DEFAULT);
        if(duration>180){
            long extras = duration-180;
            fare += extras*hm.get(TicketRule.HOURLY);
        }

        return fare;

    }
}

class ParkingFloor{

    int floorId;
    Map<ParkingSpotType, List<ParkingSpot>> spots;

    List<ParkingSpot> getAvailableSpots(Vehicle vehicle){
        List<ParkingSpot> list = new ArrayList<>();
       // List<ParkingSpot> spotList = spots.entrySet().stream()
           //     .filter(entry-> entry.getKey()==vehicle.getSpotTypeForVehicle(vehicle.getVehicleType()))
         //       .map(Map.Entry::getValue);

        return list;

    }

}

interface VehicleFactory{
     Vehicle createVehicle();
}

class CarImplementation implements VehicleFactory {
    public Car createVehicle(){

        return new Car(101, "HR26KL1234", VehicleType.CAR);

    }
}

enum TicketRule{
    HOURLY("Hourly"),
    DEFAULT("Default");

    private final String rate;

    TicketRule getInstance(String rate){
        return TicketRule.valueOf(rate);
    }

    TicketRule(String rate){
        this.rate =  rate;
    }
}

enum VehicleType{

    CAR("Car"),
    TRUCK("Truck"),
    ELECTRIC("Electric Car"),
    VAN("Van"),
    MOTORBIKE("Motorbike");

    private String type;

    VehicleType(String type){
        this.type = type;
    }

    public  VehicleType getInstance(String type){
        return VehicleType.valueOf(type);

    }


    // Check if a vehicle can fit in a given parking spot type
    public boolean canFitInSpot(ParkingSpotType spotType) {
        switch (this) {
            case TRUCK:
            case VAN:
                return spotType == ParkingSpotType.LARGE;
            case MOTORBIKE:
                return spotType == ParkingSpotType.MOTORBIKE;
            case CAR:
                return spotType == ParkingSpotType.COMPACT || spotType == ParkingSpotType.LARGE;
            case ELECTRIC:
                return spotType == ParkingSpotType.ELECTRIC || spotType == ParkingSpotType.COMPACT || spotType == ParkingSpotType.LARGE;
            default:
                return false;
        }
    }
}

// Enum for different parking spot types with additional helper methods
enum ParkingSpotType {
    HANDICAPPED("Handicapped"),
    COMPACT("Compact"),
    LARGE("Large"),
    MOTORBIKE("Motorbike"),
    ELECTRIC("Electric Charging");

    private String displayName;

    ParkingSpotType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    // Check if the spot type is suitable for a specific vehicle type
    public boolean isSuitableFor(VehicleType vehicleType) {
        return vehicleType.canFitInSpot(this);
    }
}

// Enum for parking ticket status with helper methods
enum ParkingTicketStatus {
    ACTIVE("Ticket Active"),
    PAID("Ticket Paid"),
    LOST("Ticket Lost");

    private String description;

    ParkingTicketStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Check if the parking ticket is paid
    public boolean isPaid() {
        return this == PAID;
    }
}




