package model;

import java.util.ArrayList;
import java.util.List;

public class Branch {

    private final String name;
    private final List<Customer> customers;

    public Branch(String name) {
        this.name = name;
        customers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String addCustomer(String customerName, Double initialTransactionNumber) {
        String message = String.format("\n%s already exists.", customerName);
        Customer costumer = findCustomer(customerName);
        if (costumer == null) {
            customers.add(new Customer(customerName, initialTransactionNumber));
            message = String.format("\n%s has been successfully added to %s branch.", customerName, name);
        }
        return message;
    }

    public String addTransactionForCustomer(String customerName, Double transactionNumber) {
        String message = String.format("\n%s doesn't exist in %s branch.", customerName, name);
        Customer costumer = findCustomer(customerName);
        if (costumer != null) {
            message = costumer.addTransaction(transactionNumber);
        }
        return message;
    }

    public String deleteCustomer(String customerName) {
        String message = String.format("\nNo customer with the name %s exists in %s branch.", customerName, name);
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customers.remove(customer);
            message = String.format("\n%s has been successfully deleted.", customerName);
        }
        return message;
    }

    public Customer findCustomer(String customerName) {
        for (Customer customer : customers) {
            if (customerName.equals(customer.getName())) {
                return customer;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder messageBuilder = new StringBuilder(String.format("\n %s:", name));
        for (Customer customer : customers) {
            messageBuilder.append(String.format("\n\t%s", customer.toString()));
        }
        return messageBuilder.toString();
    }

    public String getCustomerInformation(String customerName) {
        Customer customer = findCustomer(customerName);
        return customer != null ? customer.toString() : String.format("\n%s doesn't exist in %s branch.", customerName, name);
    }
}
