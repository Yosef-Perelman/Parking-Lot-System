package vehicles;

import interfaces.PaymentMethod;

public class Car extends Vehicle{
    public Car(String number, PaymentMethod paymentMethod){
        super(number);
        this.setType("Car");
        this.setPaymentMethod(paymentMethod);
    }
}
