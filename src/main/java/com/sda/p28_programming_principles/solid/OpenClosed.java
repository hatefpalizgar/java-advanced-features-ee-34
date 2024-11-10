package com.sda.p28_programming_principles.solid;

// SOLID
// S: Single Responsibility
// O: Open/Closed Principle
// Definition: Software entities should be open for extension but closed for modification.
public class OpenClosed {

    static class BadPaymentProcessor {
        public void process(String paymentType) {
            if (paymentType.equals("Credit Card")) {
                // process credit card
            } else if (paymentType.equals("PayPal")) {
                // process PayPal
            }
            // adding new payment types requires modifying this method
        }
    }

    // now, let's refactor the code using OpenClosed principle

    static interface PaymentMethod {
        void process();
    }

    static class CreditCardPayment implements PaymentMethod {
        @Override
        public void process() {
            //....
        }
    }

    static class PayPalPayment implements PaymentMethod {
        @Override
        public void process() {
            // ...
        }
    }

    static class GoodPaymentProcessor {
        public void process(PaymentMethod paymentMethod) {
            paymentMethod.process();
        }
    }

}
