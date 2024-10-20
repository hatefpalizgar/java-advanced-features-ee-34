package com.sda.p27_streams.operations;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

//@Getter
//@Setter
//@ToString
@Data // this annotation gives you @Getter and @Setter and @ToString by default
@AllArgsConstructor
public class Payment {
    private String id;
    private String customer;
    private BigDecimal amount; // use BigDecimal instead of double for monetary values
    private PaymentStatus status;
    private LocalDate date;

    enum PaymentStatus {
        PENDING,
        APPROVED,
        REJECTED
    }
}
