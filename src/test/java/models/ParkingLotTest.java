package models;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import static org.junit.jupiter.api.Assertions.*;

import vehicles.Vehicle;
import vehicles.VehicleFactory;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ParkingLotTest {

    @Test
    @Order(1)
    void getInstance(){
        ParkingLot parkingLot1 = ParkingLot.getInstance();
        ParkingLot parkingLot2 = ParkingLot.getInstance();
        assertSame(parkingLot1, parkingLot2);
    }

    @Test
    @Order(2)
    void initParkingLot(){
        ParkingLot parkingLot = ParkingLot.getInstance();
        assertEquals(3, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(3, parkingLot.getAvailableParkingSpaces().get("Motorcycle").size());
        assertEquals(3, parkingLot.getAvailableParkingSpaces().get("Truck").size());

        assertEquals(0, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assertEquals(0, parkingLot.getOccupiedParkingSpaces().get("Motorcycle").size());
        assertEquals(0, parkingLot.getOccupiedParkingSpaces().get("Truck").size());
    }


    @Test
    @Order(3)
    void enterAndLeave() {
        ParkingLot parkingLot = ParkingLot.getInstance();
        VehicleFactory vehicleFactory = new VehicleFactory();

        Vehicle car1 = vehicleFactory.createVehicle("Car", "12345678");
        assertTrue(parkingLot.enter(car1));
        assertEquals(2, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(1, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assert(car1.getParkingSpaceId() > 0);
        Vehicle car2 = vehicleFactory.createVehicle("Car", "5555555");
        assertTrue(parkingLot.enter(car2));
        assertEquals(1, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(2, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assert(car2.getParkingSpaceId() > 0);
        Vehicle car3 = vehicleFactory.createVehicle("Car", "666666");
        assertTrue(parkingLot.enter(car3));
        assertEquals(0, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(3, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assert(car3.getParkingSpaceId() > 0);

        Vehicle car4 = vehicleFactory.createVehicle("Car", "9999999");
        assertFalse(parkingLot.enter(car4));
        assertEquals(0, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(3, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assertEquals(0, car4.getParkingSpaceId());

        parkingLot.leave(car2);
        assertEquals(1, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(2, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assertEquals(0, car2.getParkingSpaceId());

        assertTrue(parkingLot.enter(car4));
        assertEquals(0, parkingLot.getAvailableParkingSpaces().get("Car").size());
        assertEquals(3, parkingLot.getOccupiedParkingSpaces().get("Car").size());
        assert(car4.getParkingSpaceId() > 0);

        assertEquals(5, parkingLot.getMoney());
        parkingLot.leave(car3);
        assertEquals(10, parkingLot.getMoney());
    }
}