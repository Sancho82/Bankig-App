package service.impl;

import service.interfaces.BranchService;
import utils.BankSupplier;
import utils.ScannerUtil;

public class BranchServiceImpl implements BranchService {

    @Override
    public void addBranch() {
        System.out.print("Type in the name of the new branch: ");
        String branchName = ScannerUtil.scanner.nextLine();
        System.out.println(BankSupplier.getBank().addBranch(branchName));
    }
}
