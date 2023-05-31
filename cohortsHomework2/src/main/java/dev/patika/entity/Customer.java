package dev.patika.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Customer {
    private final String name;
    private final String sector;
    private final List<Invoice> invoices;

    // Constructor Overloading
    public Customer(String name, String sector) {
        this.name = name;
        this.sector = sector;
        this.invoices = new ArrayList<>();
    }

    public String getSector() {
        return sector;
    }

    public void addInvoice(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public String getName() {
        return name;
    }
}
