package com.github.danielsbaumann.hrpayroll.services;

import com.github.danielsbaumann.hrpayroll.entities.Payment;
import com.github.danielsbaumann.hrpayroll.entities.Worker;
import com.github.danielsbaumann.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient
                .findById(workerId)
                .getBody();

        return new Payment(
                worker.getName(),
                worker.getDailyIncome(),
                days);
    }
}
