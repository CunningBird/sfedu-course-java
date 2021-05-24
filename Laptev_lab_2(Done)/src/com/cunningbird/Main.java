package com.cunningbird;

public class Main {

    public static void main(String[] args) throws Exception {
        Account account1 = new CheckingAccount(50.00, 37.00);
        Account account2 = new CreditAccount(25.37, 3.37);
        Account account3 = new DepositAccount(1052.64, 5.57);

        Customer customer = new Customer("Billy", "Herrington", "36");
        customer.addAccount(account1);
        customer.addAccount(account2);
        customer.addAccount(account3);

        for (Account account : customer.getAccounts()) {
            System.out.println(account.getInfo());
            System.out.println("\n");
        }
    }
}
