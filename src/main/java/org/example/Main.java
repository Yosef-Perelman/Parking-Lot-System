package org.example;

import models.ParkingLot;
import vehicles.Vehicle;
import vehicles.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car1 = vehicleFactory.createVehicle("Car", "111");
        Vehicle car2 = vehicleFactory.createVehicle("Car", "222");
        Vehicle car3 = vehicleFactory.createVehicle("Car", "333");
        Vehicle car4 = vehicleFactory.createVehicle("Car", "444");

        Vehicle motorcycle = vehicleFactory.createVehicle("Motorcycle", "1234");
        Vehicle truck = vehicleFactory.createVehicle("Truck", "178");

        parkingLot.enter(car1);
        parkingLot.enter(motorcycle);
        parkingLot.enter(car2);
        parkingLot.enter(truck);
        parkingLot.enter(car3);
        parkingLot.enter(car4);
        parkingLot.leave(car1);
        parkingLot.enter(car4);
        parkingLot.leave(truck);
        parkingLot.leave(car2);
        parkingLot.leave(car3);
        parkingLot.leave(car4);
        parkingLot.leave(motorcycle);
    }
}