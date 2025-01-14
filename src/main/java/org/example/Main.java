package org.example;

import models.ParkingLot;
import vehicles.Vehicle;
import vehicles.VehicleFactory;

public class Main {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car1 = vehicleFactory.createVehicle("Car", "12345678");
        Vehicle car2 = vehicleFactory.createVehicle("Car", "12345677");
        Vehicle car3 = vehicleFactory.createVehicle("Car", "12345673");
        Vehicle car4 = vehicleFactory.createVehicle("Car", "12345438");
        Vehicle car5 = vehicleFactory.createVehicle("Car", "1233678");

        Vehicle motorcycle = vehicleFactory.createVehicle("Motorcycle", "1234");

        Vehicle truck = vehicleFactory.createVehicle("Truck", "178");

        parkingLot.enter(car1);
        parkingLot.enter(car2);
        parkingLot.enter(car3);
        parkingLot.enter(car4);
        parkingLot.leave(car1);
        parkingLot.enter(car4);
        parkingLot.enter(motorcycle);
        parkingLot.enter(truck);
    }
}