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
    private final static ActionsOfTheParkingLot actions = new ActionsOfTheParkingLot();

    // Two maps - one for the available spaces and one for the occupied. Every type of parking space has its own list.
    // The available map looks like this - <type of parking space, map<id of a parking space, object of parking space>>.
    // The occupied map looks like this - <type of parking space, map<number of car, an object of the parking space where the car is located.>>.
    private static HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces = new HashMap<>();
    private static HashMap<String, HashMap<String, ParkingSpace>> occupiedParkingSpaces = new HashMap<>();

    // Fixed number of parking spaces of each type.
    private final static int NUMBER_OF_PARKING_SPACES_OF_CARS = 3;
    private final static int NUMBER_OF_PARKING_SPACES_OF_MOTORCYCLES = 3;
    private final static int NUMBER_OF_PARKING_SPACES_OF_TRUCKS = 3;

    // Amount of money currently in the account
    private static double money = 0;


    // Using of the singleton pattern. The constructor is private, and there method that return instance if existed,
    // otherwise create new one.
    private ParkingLot(){
        initParkingLot();
    }

    public static ParkingLot getInstance(){
        if (parkingLot == null){
            try {
                parkingLot = new ParkingLot();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return parkingLot;
    }

    // Initializes parking lot. Creates lists of available and occupied parking spaces.
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


    // *** Methods for entering and leaving the parking lot *** //

    public synchronized boolean enter(Vehicle vehicle) {
        try {
            if (!availableParkingSpaces.get(vehicle.getType()).isEmpty()) {
                // Get some random parking space from the available list
                Map.Entry<Integer, ParkingSpace> someAvailablePlace = availableParkingSpaces.get(vehicle.getType()).entrySet().iterator().next();
                actions.enter(vehicle, someAvailablePlace.getKey(), someAvailablePlace.getValue());
                System.out.println("The " + vehicle.getType() + " with number " + vehicle.getNumber() + " was parked well in parking space number " + occupiedParkingSpaces.get(vehicle.getType()).get(vehicle.getNumber()).getId());
                return true;
            } else {
                System.out.println("Theres no more spaces for " + vehicle.getType() + "s. Try again later.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public synchronized void leave(Vehicle vehicle) {
        try {
            ParkingSpace spaceOfTheCar = occupiedParkingSpaces.get(vehicle.getType()).get(vehicle.getNumber());
            actions.leave(vehicle, spaceOfTheCar);
            money += vehicle.getPaymentMethod().calculatePayment(calculateTime(vehicle.getEnterTime()));
            System.out.println("The " + vehicle.getType() + " with number " + vehicle.getNumber() + " leaving the park. The amount of money right now is " + getMoney());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static double calculateTime(LocalTime enterTime){
        return MINUTES.between(enterTime, LocalTime.now()) / 60.0;
    }


    // *** Getters ***

    public HashMap<String, HashMap<Integer, ParkingSpace>> getAvailableParkingSpaces() {
        return availableParkingSpaces;
    }

    public HashMap<String, HashMap<String, ParkingSpace>> getOccupiedParkingSpaces() {
        return occupiedParkingSpaces;
    }

    public double getMoney() { return money; }

}
