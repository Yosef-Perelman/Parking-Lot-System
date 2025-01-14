package vehicles;

import interfaces.PaymentMethod;

public class Motorcycle extends Vehicle{
    public Motorcycle(String number, PaymentMethod paymentMethod){
        super(number);
        this.setType("Motorcycle");
        this.setPaymentMethod(paymentMethod);
    }
}
