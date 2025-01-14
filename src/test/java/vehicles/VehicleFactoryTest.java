package vehicles;

import interfaces.PaymentMethod;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class VehicleFactoryTest {

    @Test
    void createVehicle() {
        VehicleFactory factory = new VehicleFactory();
        Vehicle car = factory.createVehicle("Car", "111");
        Vehicle motor = factory.createVehicle("Motorcycle", "111");
        Vehicle truck = factory.createVehicle("Truck", "111");

        assertEquals("Car", car.getType());
        assertEquals("111", car.getNumber());
        assertNull(car.getEnterTime());
        assertEquals(0, car.getParkingSpaceId());

        assertEquals("Motorcycle", motor.getType());
        assertEquals("111", motor.getNumber());
        assertNull(motor.getEnterTime());
        assertEquals(0, motor.getParkingSpaceId());

        assertEquals("Truck", truck.getType());
        assertEquals("111", truck.getNumber());
        assertNull(truck.getEnterTime());
        assertEquals(0, truck.getParkingSpaceId());
    }
}