package models;

import interfaces.PaymentMethod;

public class initialPaymentMethod implements PaymentMethod {
    @Override
    public int calculatePayment(double time) {
        if(time <= 0) return 0;
        if(time <= 1) return 5;
        time -= 1;
        int timeWithoutFraction = (int)time;
        double fraction = time - timeWithoutFraction;
        if(fraction > 0) return 7 + timeWithoutFraction * 2;
        return 5 + timeWithoutFraction * 2;
    }
}
