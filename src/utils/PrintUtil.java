package utils;

import java.util.Scanner;

public class PrintUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printOptions() {
        System.out.println("\nType 0 to print options.");
        System.out.println("Type 1 to add a branch.");
        System.out.println("Type 2 to add a customer.");
        System.out.println("Type 3 to add transaction to a customer.");
        System.out.println("Type 4 to delete a customer.");
        System.out.println("Type 5 to print customer information.");
        System.out.println("Type 6 to print branch information.");
        System.out.println("Type 7 to print bank information.");
        System.out.println("Type 8 to quit.");
    }

    public static void printCustomerInformation() {
        System.out.print("Type in the name of the customer whose information you would like to print: ");
        String customerName = scanner.nextLine();
        System.out.printf("Which branch %s does belong to? ", customerName);
        String branchName = scanner.nextLine();

        String message = BankSupplier.getBank().getCustomerInformation(customerName, branchName);

        if (message.equals(String.format("\n%s doesn't exist.", branchName))) {
            System.out.printf("\nBranch invalid, but %s has been searched through bank database: \n%s%n",
                    customerName, BankSupplier.getBank().getCustomerInformation(customerName));

        } else {
            System.out.println(message);
        }
    }

    public static void printBranchInformation() {
        System.out.print("Type in the name of the branch which's information you would like to print: ");
        String branchName = scanner.nextLine();

        System.out.println(BankSupplier.getBank().getBranchInformation(branchName));
    }

    public static void printBankInformation() {
        System.out.println(BankSupplier.getBank().toString());
    }
}
