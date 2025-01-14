package vehicles;

import interfaces.PaymentMethod;
import models.initialPaymentMethod;

import java.util.Objects;

public class VehicleFactory {
    public Vehicle createVehicle(String type, String number){
        PaymentMethod paymentMethod = new initialPaymentMethod();
        if(Objects.equals(type, "Car")) return new Car(number, paymentMethod);
        if(Objects.equals(type, "Motorcycle")) return new Motorcycle(number, paymentMethod);
        if(Objects.equals(type, "Truck")) return new Truck(number, paymentMethod);
        return null;
    }
}
