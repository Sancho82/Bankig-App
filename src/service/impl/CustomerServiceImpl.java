package service.impl;

import service.interfaces.CustomerService;
import utils.BankSupplier;
import utils.ScannerUtil;
import utils.ValidatorUtil;

public class CustomerServiceImpl implements CustomerService {

    @Override
    public void addCustomer() {
        System.out.print("Type in the name of the new customer: ");
        String customerName = ScannerUtil.scanner.nextLine();

        System.out.print("Type in the initial transaction number for the new customer: ");
        double initialTransactionNumber = ValidatorUtil.isDoubleValueValid(ScannerUtil.scanner.nextLine());

        System.out.print("Type in the name of the branch you would like to add new customer to : ");
        String branchName = ScannerUtil.scanner.nextLine();

        System.out.println(BankSupplier.getBank().addCustomer(customerName, branchName, initialTransactionNumber));
    }

    @Override
    public void deleteCustomer() {
        System.out.print("Type in the name of the customer you would like to delete: ");
        String customerName = ScannerUtil.scanner.nextLine();

        System.out.printf("Which branch does %s belong to? ", customerName);
        String branchName = ScannerUtil.scanner.nextLine();

        String message = BankSupplier.getBank().deleteCustomer(customerName, branchName);

        System.out.println(
                message.equals(
                        String.format("\n%s doesn't exist.", branchName)) ?
                        String.format("\nBranch invalid. Initiating database search.. %s", BankSupplier.getBank().deleteCustomer(customerName)) : message
        );
    }
}
