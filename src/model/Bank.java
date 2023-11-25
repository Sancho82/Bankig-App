package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private final String name;
    private final List<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<>();
    }

    public String addBranch(String branchName) {
        String message = String.format("\n%s branch already exists.", branchName);
        if (!isBranchValid(branchName)) {
            branches.add(new Branch(branchName));
            message = String.format("\n%s branch successfully added to %s.", branchName, name);
        }
        return message;
    }

    public String addCustomer(String customerName, String branchName, double initialTransactionNumber) {
        String message = String.format("\nThe %s branch doesn't exist.", branchName);
        Branch branch = findBranch(branchName);
        if (branch != null) {
            message = branch.addCustomer(customerName, initialTransactionNumber);
        }
        return message;
    }

    public String addTransactionForCustomer(String customerName, String branchName, double transactionNumber) {
        String message = String.format("\n%s doesn't exist.", branchName);
        Branch branch = findBranch(branchName);
        if (branch != null) {
            message = branch.addTransactionForCustomer(customerName, transactionNumber);

        }
        return message;
    }

    public String addTransactionForCustomer(String customerName, double transactionNumber) {
        String message = String.format("\n%s doesn't exist.", customerName);
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            message = customer.addTransaction(transactionNumber);
        }
        return message;
    }

    public String deleteCustomer(String customerName, String branchName) {
        String message = String.format("\n%s doesn't exist.", branchName);
        Branch branch = findBranch(branchName);
        if (branch != null) {
            message = branch.deleteCustomer(customerName);

        }
        return message;
    }

    public String deleteCustomer(String customerName) {
        String message = String.format("\n%s doesn't exist", customerName);
        for (Branch branch : branches) {
            Customer customer = branch.findCustomer(customerName);
            if (customer != null) {
                message = branch.deleteCustomer(customerName);
            }
        }
        return message;
    }

    public String getCustomerInformation(String customerName, String branchName) {
        Branch branch = findBranch(branchName);
        return branch != null ? branch.getCustomerInformation(customerName) :
                String.format("\n%s doesn't exist.", branchName);
    }

    public String getCustomerInformation(String customerName) {
        Customer customer = findCustomer(customerName);
        return customer != null ? customer.toString() : String.format("\n%s doesn't exist.", customerName);
    }

    public String getBranchInformation(String branchName) {
        String message = String.format("\n%s branch doesn't exist.", branchName);
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.toString();
        }
        return message;
    }

    public String toString() {
        StringBuilder messageBuilder = new StringBuilder(String.format("\n%s: ", name));
        for (Branch branch : branches) {
            messageBuilder.append(String.format("\n\t%s", branch.toString()));
        }
        return messageBuilder.toString();
    }

    public Boolean isBranchValid(String branchName) {
        return findBranch(branchName) != null;
    }

    public Customer findCustomer(String customerName) {
        for (Branch branch : branches) {
            Customer customer = branch.findCustomer(customerName);
            if (customer != null) {
                return customer;
            }
        }
        return null;
    }

    public Branch findBranch(String branchName) {
        for (Branch branch : branches) {
            if (branch.getName().equals(branchName)) {
                return branch;
            }
        }
        return null;
    }
}
