package models;

import parkingSpaces.ParkingSpace;
import vehicles.Vehicle;
import java.time.LocalTime;


public class ActionsOfTheParkingLot {

    public void enter(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        updateEnteringInVehicleAndParkingSpace(vehicle, id, someAvailableSpace);
        updateListsOfEntering(vehicle, id, someAvailableSpace);
    }

    private static void updateEnteringInVehicleAndParkingSpace(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        someAvailableSpace.setTaken(true);
        someAvailableSpace.setCarInSpace(vehicle.getNumber());
        vehicle.setEnterTime(LocalTime.now());
        vehicle.setParkingSpaceId(id);
    }

    private static void updateListsOfEntering(Vehicle vehicle, int id, ParkingSpace someAvailableSpace){
        ParkingLot.getInstance().getAvailableParkingSpaces().get(vehicle.getType()).remove(id);
        ParkingLot.getInstance().getOccupiedParkingSpaces().get(vehicle.getType()).put(vehicle.getNumber(), someAvailableSpace);
    }

    public void leave(Vehicle vehicle, ParkingSpace someAvailableSpace){
        updateLeavingInVehicleAndParkingSpace(vehicle, someAvailableSpace);
        updateListsOfLeaving(vehicle, someAvailableSpace);
    }

    private void updateLeavingInVehicleAndParkingSpace(Vehicle vehicle, ParkingSpace spaceOfTheCar){
        spaceOfTheCar.setCarInSpace(null);
        spaceOfTheCar.setTaken(false);
        vehicle.setParkingSpaceId(0);
    }

    private void updateListsOfLeaving(Vehicle vehicle, ParkingSpace spaceOfTheCar){
        ParkingLot.getInstance().getOccupiedParkingSpaces().get(vehicle.getType()).remove(vehicle.getNumber());
        ParkingLot.getInstance().getAvailableParkingSpaces().get(vehicle.getType()).put(spaceOfTheCar.getId(), spaceOfTheCar);
    }
}
