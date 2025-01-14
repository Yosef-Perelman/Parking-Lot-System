package parkingSpaces;

import java.util.Objects;

public class ParkingSpaceFactory {
    public ParkingSpace createParkingSpace(String type){
        if(Objects.equals(type, "Car")) return new CarSpace();
        if(Objects.equals(type, "Motorcycle")) return new MotorcycleSpace();
        if(Objects.equals(type, "Truck")) return new TruckSpace();
        return null;
    }
}
