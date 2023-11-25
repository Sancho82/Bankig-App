package utils;

import model.Bank;

import java.util.Random;

public class BankSupplier {

    private static final Bank bank = new Bank("Barclays");

    static  {
        createBranches();
        createCustomers();
    }

    public static Bank getBank() {
        return bank;
    }

    private static void createBranches() {
        bank.addBranch("Hatfield");
        bank.addBranch("Basingstoke");
        bank.addBranch("Redding");
        bank.addBranch("Woking");
        bank.addBranch("St. Albans");
    }

    private static void createCustomers() {
        bank.addCustomer("Steve Royce", "Hatfield", new Random().nextInt(100000));
        bank.addCustomer("Mike Lehoczki", "Hatfield", new Random().nextInt(100000));
        bank.addCustomer("Gábor Szaniszló", "Hatfield", new Random().nextInt(100000));

        bank.addCustomer("Lewis Johnson", "Basingstoke", new Random().nextInt(100000));
        bank.addCustomer("Red Rider", "Basingstoke", new Random().nextInt(100000));
        bank.addCustomer("Lucy Rider", "Basingstoke", new Random().nextInt(100000));

        bank.addCustomer("Fred Durst", "Redding", new Random().nextInt(100000));
        bank.addCustomer("Patricia King", "Redding", new Random().nextInt(100000));
        bank.addCustomer("Zoltán Takács", "Redding", new Random().nextInt(100000));

        bank.addCustomer("Rick Kaufmann", "Woking", new Random().nextInt(100000));
        bank.addCustomer("Kieran Wheeler", "Woking", new Random().nextInt(100000));
        bank.addCustomer("Jennifer Lopez", "Woking", new Random().nextInt(100000));

        bank.addCustomer("Alan Moore", "St. Albans", new Random().nextInt(100000));
        bank.addCustomer("Carnella Bing", "St. Albans", new Random().nextInt(100000));
        bank.addCustomer("Mandy Moore", "St. Albans", new Random().nextInt(100000));
    }
}
