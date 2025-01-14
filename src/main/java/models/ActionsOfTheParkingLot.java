package models;

import parkingSpaces.ParkingSpace;
import vehicles.Vehicle;
import java.time.LocalTime;


public class ActionsOfTheParkingLot {

    public void enter(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        updatingVehicleAndParkingSpaceAboutEntering(vehicle, id, someAvailableSpace);
        updateListsAboutEntering(vehicle, id, someAvailableSpace);
    }

    private static void updatingVehicleAndParkingSpaceAboutEntering(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        someAvailableSpace.setTaken(true);
        someAvailableSpace.setCarInSpace(vehicle.getNumber());
        vehicle.setEnterTime(LocalTime.now());
        vehicle.setParkingSpaceId(id);
    }

    private static void updateListsAboutEntering(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        ParkingLot.getInstance().getAvailableParkingSpaces().get(vehicle.getType()).remove(id);
        ParkingLot.getInstance().getOccupiedParkingSpaces().get(vehicle.getType()).put(vehicle.getNumber(), someAvailableSpace);
    }

    public void leave(Vehicle vehicle, ParkingSpace someAvailableSpace){
        updatingVehicleAndParkingSpaceAboutLeaving(vehicle, someAvailableSpace);
        updateListsAboutLeaving(vehicle, someAvailableSpace);
    }

    private static void updatingVehicleAndParkingSpaceAboutLeaving(Vehicle vehicle, ParkingSpace spaceOfTheCar){
        spaceOfTheCar.setCarInSpace(null);
        spaceOfTheCar.setTaken(false);
        vehicle.setParkingSpaceId(0);
    }

    private static void updateListsAboutLeaving(Vehicle vehicle, ParkingSpace spaceOfTheCar){
        ParkingLot.getInstance().getOccupiedParkingSpaces().get(vehicle.getType()).remove(vehicle.getNumber());
        ParkingLot.getInstance().getAvailableParkingSpaces().get(vehicle.getType()).put(spaceOfTheCar.getId(), spaceOfTheCar);
    }
}
