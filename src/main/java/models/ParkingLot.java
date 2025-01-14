package models;

import parkingSpaces.ParkingSpace;
import parkingSpaces.ParkingSpaceFactory;
import vehicles.Vehicle;

import java.util.HashMap;


class ParkingLot {

    private static ParkingLot parkingLot = null;
    private static HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces = new HashMap<>();
    private static HashMap<String, HashMap<Integer, ParkingSpace>> occupiedParkingSpaces = new HashMap<>();
    private final static int NUMBER_OF_PARKING_SPACES_OF_CARS = 20;
    private final static int NUMBER_OF_PARKING_SPACES_OF_MOTORCYCLES = 20;
    private final static int NUMBER_OF_PARKING_SPACES_OF_TRUCKS = 10;

    private static double money = 0;

    private ParkingLot(){}

    public static ParkingLot getInstance(){
        if (parkingLot == null){
            parkingLot = new ParkingLot();
            initParkingLot();
        }
        return parkingLot;
    }

    private static void initParkingLot(){
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

    private static void createParkingSpaces(HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces, String type, int numOfSpaces){
        ParkingSpaceFactory parkingSpaceFactory = new ParkingSpaceFactory();
        for(int i = 0; i < numOfSpaces; i++){
            availableParkingSpaces.get(type).put(i + 1, parkingSpaceFactory.createParkingSpace(type));
        }
    }

    public static void enter(Vehicle vehicle){
        /*
        *todo
        * check if there available place and set the changes
        */
    }

    public static void leave(Vehicle vehicle){
        /*
         *todo
         * set the changes and update the money
         */
    }
}
