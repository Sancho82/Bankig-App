package controller;

import service.impl.BranchServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.TransactionServiceImpl;
import service.interfaces.BranchService;
import service.interfaces.CustomerService;
import service.interfaces.TransactionService;
import utils.PrintUtil;
import utils.ScannerUtil;
import utils.ValidatorUtil;

public class Controller  {

    private static int button = 0;

    private final BranchService branchService;

    private final CustomerService customerService;

    private final TransactionService transactionService;

    public Controller() {
        this.branchService = new BranchServiceImpl();
        this.customerService = new CustomerServiceImpl();
        this.transactionService = new TransactionServiceImpl();
    }

    public void start() {
        PrintUtil.printOptions();
        while (button != 8) {
            System.out.print("\nChoose an option: ");
            button = ValidatorUtil.isIntegerValueValid(ScannerUtil.scanner.nextLine());
            executeOption(button);
        }
    }

    public void executeOption(int button) {
        switch (button) {
            case 0:
                PrintUtil.printOptions();
                break;
            case 1:
                branchService.addBranch();
                break;
            case 2:
                customerService.addCustomer();
                break;
            case 3:
                transactionService.addTransactionForCustomer();
                break;
            case 4:
                customerService.deleteCustomer();
                break;
            case 5:
                PrintUtil.printCustomerInformation();
                break;
            case 6:
                PrintUtil.printBranchInformation();
                break;
            case 7:
                PrintUtil.printBankInformation();
                break;
            case 8:
                quit();
                break;
            default:
                System.out.println("Not a valid option");
                break;
        }
    }

    public void quit() {
        System.out.println("Bye!");
        System.exit(0);
    }
}
