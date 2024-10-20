package com.sda.p27_streams.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntermediateOperations {
    public static void main(String[] args) {

        List<Payment> payments =
                Arrays.asList(
                        new Payment(
                                "1",
                                "John",
                                new BigDecimal("100.50"),
                                Payment.PaymentStatus.APPROVED,
                                LocalDate.now()),
                        new Payment(
                                "2",
                                "Mary",
                                new BigDecimal("200.75"),
                                Payment.PaymentStatus.PENDING,
                                LocalDate.now().minusDays(60)),
                        new Payment(
                                "3",
                                "Michael",
                                new BigDecimal("50.00"),
                                Payment.PaymentStatus.APPROVED,
                                LocalDate.now()),
                        new Payment(
                                "4",
                                "Mary",
                                new BigDecimal("150.25"),
                                Payment.PaymentStatus.REJECTED,
                                LocalDate.now()),
                        new Payment(
                                "5",
                                "Mary",
                                new BigDecimal("75.00"),
                                Payment.PaymentStatus.PENDING,
                                LocalDate.now().minusDays(15)));

        // filter() to get only the approved payments
        List<Payment> approvedPayments = payments.stream()
                .filter(payment -> payment.getStatus() == Payment.PaymentStatus.APPROVED) // filter is an 'intermediate' operation
                //.peek(System.out::println) // peek is an 'intermediate' operation
                .toList(); // toList is a 'terminal' operation

        // filter() to get only the approved payments by John
        List<Payment> approvedPaymentsByJohn = payments.stream()
                .filter(payment -> payment.getStatus() == Payment.PaymentStatus.APPROVED)
                .filter(payment -> payment.getCustomer().equals("John"))
                //.peek(System.out::println)
                .toList();

        // map() to transform the Payment objects into their amount
        List<BigDecimal> paymentAmounts = payments.stream()
                .map(payment -> payment.getAmount())
                //.peek(System.out::println)
                .toList();

        // sorted() to sort payments by their amount
        List<Payment> sortedPayments = payments.stream()
                .sorted(Comparator.comparing(  payment -> payment.getAmount()   ))  // The key extractor function instructs the Comparator on what basis to carry out the comparison
                //.peek(System.out::println)
                .toList();

        // distinct() to get the unique customer names
        List<String> uniqueCustomerNames = payments.stream()
                .map(payment -> payment.getCustomer())
                .distinct()
                //.peek(System.out::println)
                .toList();

        // limit() to get the first two payments made by Mary
        List<Payment> firstTwoPaymentsByMary = payments.stream()
                .filter(payment -> payment.getCustomer().equalsIgnoreCase("mary"))
                .limit(2)
                //.peek(System.out::println)
                .toList();
    }
}
