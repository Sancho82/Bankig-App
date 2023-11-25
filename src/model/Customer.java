package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name;
    private final List<Double> transactions;

    public Customer(String name, double initialTransactionNumber) {
        this.name = name;
        transactions = new ArrayList<>();
        addTransaction(initialTransactionNumber);
    }

    public String getName() {
        return name;
    }

    public String addTransaction(double transactionNumber) {
        transactions.add(transactionNumber);
        return String.format("\nTransaction %.2f for %s has been successfully booked.", transactionNumber, name);
    }

    public String toString() {
        return name + " ---> " + transactions.toString();
    }
}
