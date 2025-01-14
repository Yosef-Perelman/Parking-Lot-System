package vehicles;

import interfaces.PaymentMethod;

import java.time.LocalTime;

public abstract class Vehicle {
    private String type;
    private String number;
    private LocalTime enterTime;
    private PaymentMethod paymentMethod;
    private int parkingSpaceId;

    public Vehicle(String number){
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void setParkingSpaceId(int parkingSpaceId) {
        this.parkingSpaceId = parkingSpaceId;
    }
}
