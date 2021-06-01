package com.github.danielsbaumann.hrpayroll.services;

import com.github.danielsbaumann.hrpayroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Bob", 200d, days);
    }
}
