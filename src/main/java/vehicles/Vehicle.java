package vehicles;

import interfaces.PaymentMethod;

import java.time.LocalTime;

public abstract class Vehicle {
    private String number;
    private LocalTime enterTime;
    private PaymentMethod paymentMethod;

    public Vehicle(String number){
        this.number = number;
    }

    public String getNumber(){
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalTime getEnterTime() {
        return enterTime;
    }

    public void setEnterTime(LocalTime enterTime) {
        this.enterTime = enterTime;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
