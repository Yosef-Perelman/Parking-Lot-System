package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InitialPaymentMethodTest {

    @Test
    void calculatePayment() {
        InitialPaymentMethod initialPaymentMethod = new InitialPaymentMethod();
        assertEquals(17, initialPaymentMethod.calculatePayment(6.3));
        assertEquals(9, initialPaymentMethod.calculatePayment(2.3));
        assertEquals(9, initialPaymentMethod.calculatePayment(3));
    }
}