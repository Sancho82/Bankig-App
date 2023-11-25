package service.impl;

import service.interfaces.TransactionService;
import utils.BankSupplier;
import utils.ScannerUtil;
import utils.ValidatorUtil;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public void addTransactionForCustomer() {
        System.out.print("Type in the name of the customer you would like to add a transaction to: ");
        String customerName = ScannerUtil.scanner.nextLine();

        System.out.printf("Which branch %s does belong to? ", customerName);
        String branchName = ScannerUtil.scanner.nextLine();

        System.out.print("Type in the number of the transaction you would like to add to the customer: ");
        double transactionNumber = ValidatorUtil.isDoubleValueValid(ScannerUtil.scanner.nextLine());

        String message = BankSupplier.getBank().addTransactionForCustomer(customerName, branchName, transactionNumber);

        if (message.equals(String.format("\n%s doesn't exist in %s branch.", customerName, branchName))) {
            String newMessage = BankSupplier.getBank().addTransactionForCustomer(customerName, transactionNumber);
            System.out.printf("%s Initiating database search.. \n%s%n", message, newMessage);

        } else if (message.equals(String.format("\n%s doesn't exist.", branchName))) {
            String newMessage = BankSupplier.getBank().addTransactionForCustomer(customerName, transactionNumber);
            System.out.printf("\nBranch invalid. Initiating database search.. \n%s%n", newMessage);

        } else {
            System.out.println(message);
        }
    }
}
