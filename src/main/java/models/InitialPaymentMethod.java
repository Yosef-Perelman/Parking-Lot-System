package models;

import interfaces.PaymentMethod;

public class InitialPaymentMethod implements PaymentMethod {
    @Override
    public int calculatePayment(double time) {
        int amount = 5;
        time -= 1;
        if(time < 0) return amount;

        int timeWithoutFraction = (int)time;
        double fraction = time - timeWithoutFraction;
        if(fraction > 0) return 7 + timeWithoutFraction * 2;
        return 5 + timeWithoutFraction * 2;
    }
}
