package com.sda.p27_streams.operations;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class TerminalOperations {
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
                                "John",
                                new BigDecimal("50.00"),
                                Payment.PaymentStatus.APPROVED,
                                LocalDate.now()),
                        new Payment(
                                "4",
                                "Bob",
                                new BigDecimal("150.25"),
                                Payment.PaymentStatus.REJECTED,
                                LocalDate.now()),
                        new Payment(
                                "5",
                                "Mary",
                                new BigDecimal("75.00"),
                                Payment.PaymentStatus.PENDING,
                                LocalDate.now().minusDays(15)));

        // count(): returns the number of elements in the stream
        long count = payments.stream().count();
        System.out.println(count);

        // forEach(): performs an action for each element in the stream
        payments.stream()
                .forEach(payment -> System.out.println(payment.getCustomer() + ":" + payment.getAmount()));

        // max(): returns the maximum element of the stream, according to a comparator
        Optional<Payment> maxPayment = payments.stream().max(Comparator.comparing(payment -> payment.getAmount()));
        maxPayment.ifPresent(p -> System.out.println("Maximum Payment: " + p)); // payment with ID 2

        // min(): returns the minimum element of the stream, according to a comparator

        // reduce(): reduces the elements of the stream to a single value, according to a binary operator
        Optional<BigDecimal> totalAmount = payments.stream()
                .map(payment -> payment.getAmount()) // Stream<BigDecimal>
                .reduce(   (amount1, amount2) -> amount1.add(amount2)    );
        totalAmount.ifPresent(amount -> System.out.println("Total amount: " + amount));
    }
}
