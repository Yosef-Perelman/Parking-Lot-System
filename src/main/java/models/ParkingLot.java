package models;

import parkingSpaces.ParkingSpace;
import java.util.HashMap;


class ParkingLot {

    private static ParkingLot parkingLot = null;
    private static HashMap<String, HashMap<Integer, ParkingSpace>> availableParkingSpaces = new HashMap<>();
    private static HashMap<String, HashMap<Integer, ParkingSpace>> occupiedParkingSpaces = new HashMap<>();
    private final static int NUMBER_OF_PARKING_SPACES_OF_CARS = 50;
    private final static int NUMBER_OF_PARKING_SPACES_OF_MOTORCYCLES = 50;
    private final static int NUMBER_OF_PARKING_SPACES_OF_TRUCKS = 50;

    private static double money = 0;

    private ParkingLot(){}

    public static ParkingLot getInstance(){
        if (parkingLot == null){
            parkingLot = new ParkingLot();
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
        for(int i = 0; i < numOfSpaces; i++){
            // todo create factory of parking spaces
            availableParkingSpaces.get(type).put(i + 1, new ParkingSpace());
        }
    }

    public static void enter(){
        /*
        *todo
        * check if there available place and set the changes
        */
    }

    public static void leave(){
        /*
         *todo
         * set the changes and update the money
         */
    }
}
