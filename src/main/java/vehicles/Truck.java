package vehicles;

import interfaces.PaymentMethod;

public class Truck extends Vehicle{
    public Truck(String number, PaymentMethod paymentMethod){
        super(number);
        this.setPaymentMethod(paymentMethod);
    }
}
