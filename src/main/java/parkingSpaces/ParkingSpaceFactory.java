package parkingSpaces;

import java.util.Objects;

public class ParkingSpaceFactory {
    public ParkingSpace createParkingSpace(String type, int id){
        if(Objects.equals(type, "Car")) return new CarSpace(id);
        if(Objects.equals(type, "Motorcycle")) return new MotorcycleSpace(id);
        if(Objects.equals(type, "Truck")) return new TruckSpace(id);
        return null;
    }
}
