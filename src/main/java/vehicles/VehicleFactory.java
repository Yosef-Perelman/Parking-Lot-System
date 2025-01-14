package vehicles;

import java.util.Objects;

public class VehicleFactory {
    public Vehicle createVehicle(String type){
        if(Objects.equals(type, "Car")) return new Car();
        if(Objects.equals(type, "Motorcycle")) return new Motorcycle();
        if(Objects.equals(type, "Truck")) return new Truck();
        return null;
    }
}
