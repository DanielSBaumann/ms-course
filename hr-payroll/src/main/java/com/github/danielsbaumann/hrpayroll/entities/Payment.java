package com.github.danielsbaumann.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 1l;
    private String name;
    private Double daylyIncome;
    private Integer days;

    public double getTotal() {
        return days * daylyIncome;
    }
}
