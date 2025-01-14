package models;

import parkingSpaces.ParkingSpace;
import parkingSpaces.ParkingSpaceFactory;
import vehicles.Vehicle;

import java.time.LocalTime;
import static java.time.temporal.ChronoUnit.MINUTES;
import java.util.HashMap;
import java.util.Map;


public class ParkingLot {

    private static ParkingLot parkingLot = null;
    private static HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces = new HashMap<>();
    private static HashMap<String, HashMap<String, ParkingSpace>> occupiedParkingSpaces = new HashMap<>();
    private final static int NUMBER_OF_PARKING_SPACES_OF_CARS = 3;
    private final static int NUMBER_OF_PARKING_SPACES_OF_MOTORCYCLES = 3;
    private final static int NUMBER_OF_PARKING_SPACES_OF_TRUCKS = 3;

    private static double money = 0;

    private ParkingLot(){
        initParkingLot();
    }

    public static ParkingLot getInstance(){
        if (parkingLot == null){
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }

    private void initParkingLot(){
        availableParkingSpaces.put("Car", new HashMap<>());
        availableParkingSpaces.put("Motorcycle", new HashMap<>());
        availableParkingSpaces.put("Truck", new HashMap<>());

        createParkingSpaces(availableParkingSpaces, "Car", NUMBER_OF_PARKING_SPACES_OF_CARS);
        createParkingSpaces(availableParkingSpaces, "Motorcycle", NUMBER_OF_PARKING_SPACES_OF_MOTORCYCLES);
        createParkingSpaces(availableParkingSpaces, "Truck", NUMBER_OF_PARKING_SPACES_OF_TRUCKS);

        occupiedParkingSpaces.put("Car", new HashMap<>());
        occupiedParkingSpaces.put("Motorcycle", new HashMap<>());
        occupiedParkingSpaces.put("Truck", new HashMap<>());
    }

    private void createParkingSpaces(HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces, String type, int numOfSpaces){
        ParkingSpaceFactory parkingSpaceFactory = new ParkingSpaceFactory();
        for(int i = 0; i < numOfSpaces; i++){
            availableParkingSpaces.get(type).put(i + 1, parkingSpaceFactory.createParkingSpace(type, i + 1));
        }
    }

    public synchronized boolean enter(Vehicle vehicle) {
        if (!availableParkingSpaces.get(vehicle.getType()).isEmpty()) {
            Map.Entry<Integer, ParkingSpace> someAvailablePlace = availableParkingSpaces.get(vehicle.getType()).entrySet().iterator().next();
            availableParkingSpaces.get(vehicle.getType()).remove(someAvailablePlace.getKey());
            vehicle.setParkingSpaceId(someAvailablePlace.getKey());
            occupiedParkingSpaces.get(vehicle.getType()).put(vehicle.getNumber(), someAvailablePlace.getValue());
            vehicle.setEnterTime(LocalTime.now());
            System.out.println("The vehicle " + vehicle.getNumber() + " park good in park number " + occupiedParkingSpaces.get(vehicle.getType()).get(vehicle.getNumber()).getId());
            return true;
        } else {
            System.out.println("the park is full, cant find empty place");
            return false;
        }
    }

    public synchronized void leave(Vehicle vehicle){
        ParkingSpace spaceOfTheCar = occupiedParkingSpaces.get(vehicle.getType()).get(vehicle.getNumber());
        occupiedParkingSpaces.get(vehicle.getType()).remove(vehicle.getNumber());
        availableParkingSpaces.get(vehicle.getType()).put(spaceOfTheCar.getId(), spaceOfTheCar);
        money += vehicle.getPaymentMethod().calculatePayment(calculateTime(vehicle.getEnterTime()));
    }

    public static double calculateTime(LocalTime enterTime){
        return MINUTES.between(enterTime, LocalTime.now()) / 60.0;
    }
}
