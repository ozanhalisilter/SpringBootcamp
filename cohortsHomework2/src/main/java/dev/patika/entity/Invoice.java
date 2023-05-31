package dev.patika.entity;

import java.time.LocalDate;

public class Invoice {
    private final LocalDate date;
    private final double amount;

    public Invoice(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Invoice{date=" + date +
                ", amount=" + amount +
                '}';
    }
}
