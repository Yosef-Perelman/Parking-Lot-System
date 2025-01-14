package vehicles;

import interfaces.PaymentMethod;

public class Car extends Vehicle{
    public Car(String number, PaymentMethod paymentMethod){
        super(number);
        this.setPaymentMethod(paymentMethod);
    }
}
