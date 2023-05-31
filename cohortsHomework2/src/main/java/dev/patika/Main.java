package dev.patika;

import dev.patika.entity.Customer;
import dev.patika.entity.Invoice;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        // Creating customers
        Customer customer1 = new Customer("CustomerA", "Retail");
        Customer customer2 = new Customer("CustomerB", "IT");
        Customer customer3 = new Customer("CustomerC", "Finance");

        // Creating invoices
        Invoice invoice1 = new Invoice(LocalDate.of(2023, Month.JUNE, 15), 1000);
        Invoice invoice2 = new Invoice(LocalDate.of(2023, Month.JUNE, 16), 1500);
        Invoice invoice3 = new Invoice(LocalDate.of(2023, Month.JUNE, 17), 2500);
        Invoice invoice4 = new Invoice(LocalDate.of(2023, Month.JUNE, 18), 300);
        Invoice invoice5 = new Invoice(LocalDate.of(2023, Month.MAY, 20), 100);
        Invoice invoice6 = new Invoice(LocalDate.of(2023, Month.MAY, 21), 800);

        // Adding invoices to customers
        customer1.addInvoice(invoice1);
        customer1.addInvoice(invoice2);
        customer2.addInvoice(invoice3);
        customer2.addInvoice(invoice4);
        customer3.addInvoice(invoice5);
        customer3.addInvoice(invoice6);

        // Adding customers to the system
        Service.addCustomer(customer1);
        Service.addCustomer(customer2);
        Service.addCustomer(customer3);

        // Testing the functions
        System.out.println("All Customers: " + Service.getAllCustomers());
        System.out.println("Customers containing 'C': " + Service.customersContainingC());
        System.out.println("Total invoice amount in June: " + Service.totalInvoiceAmountInJune(2023));
        System.out.println("All invoices in the system: " + Service.allInvoicesInTheSystem());
        System.out.println("Invoices above 1500: " + Service.invoicesAbove1500());
        System.out.println("Average of invoices above 1500: " + Service.averageOfInvoicesAbove1500());
        System.out.println("Customers with invoices below 500: " + Service.customersWithInvoicesBelow500());
        System.out.println("Sectors of companies with average invoice below 750 in June: " + Service.sectorsOfCompaniesWithAverageInvoiceBelow750InJune(2023));
    }
}
