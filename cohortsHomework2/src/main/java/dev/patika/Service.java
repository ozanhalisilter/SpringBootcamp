package dev.patika;

import dev.patika.entity.Customer;
import dev.patika.entity.Invoice;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Service {
    private static final Set<Customer> customers = new HashSet<>();

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public static List<Customer> customersContainingC() {
        return customers.stream()
                .filter(c -> c.getName().contains("C"))
                .collect(Collectors.toList());
    }

    public static double totalInvoiceAmountInJune(int year) {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getDate().getYear() == year && i.getDate().getMonth() == Month.JUNE)
                .mapToDouble(Invoice::getAmount)
                .sum();
    }

    public static List<Invoice> allInvoicesInTheSystem() {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .collect(Collectors.toList());
    }

    public static List<Invoice> invoicesAbove1500() {
        return customers.stream()
                .flatMap(c -> c.getInvoices().stream())
                .filter(i -> i.getAmount() > 1500)
                .collect(Collectors.toList());
    }

    public static double averageOfInvoicesAbove1500() {
        return invoicesAbove1500().stream()
                .mapToDouble(Invoice::getAmount)
                .average()
                .orElse(0);
    }

    public static List<String> customersWithInvoicesBelow500() {
        return customers.stream()
                .filter(c -> c.getInvoices().stream().anyMatch(i -> i.getAmount() < 500))
                .map(Customer::getName)
                .collect(Collectors.toList());
    }

    public static List<String> sectorsOfCompaniesWithAverageInvoiceBelow750InJune(int year) {
        return customers.stream()
                .filter(c -> {
                    double average = c.getInvoices().stream()
                            .filter(i -> i.getDate().getYear() == year && i.getDate().getMonth() == Month.JUNE)
                            .mapToDouble(Invoice::getAmount)
                            .average()
                            .orElse(0);
                    return average < 750;
                })
                .map(Customer::getSector)
                .collect(Collectors.toList());
    }
}
