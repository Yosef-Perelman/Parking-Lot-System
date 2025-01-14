package parkingSpaces;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingSpaceFactoryTest {

    @Test
    void createParkingSpace() {
        ParkingSpaceFactory factory = new ParkingSpaceFactory();
        ParkingSpace carSpace = factory.createParkingSpace("Car", 1);
        ParkingSpace motorSpace = factory.createParkingSpace("Motorcycle", 2);
        ParkingSpace truckSpace = factory.createParkingSpace("Truck", 23);

        assertEquals(1, carSpace.getId());
        assertFalse(carSpace.isTaken());
        assertNull(carSpace.getCarInSpace());

        assertEquals(2, motorSpace.getId());
        assertFalse(motorSpace.isTaken());
        assertNull(motorSpace.getCarInSpace());

        assertEquals(23, truckSpace.getId());
        assertFalse(truckSpace.isTaken());
        assertNull(truckSpace.getCarInSpace());
    }
}