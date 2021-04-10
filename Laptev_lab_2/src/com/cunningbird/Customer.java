package com.cunningbird;

import java.util.HashSet;

public class Customer {

    private String firstName;

    private String secondName;

    private String birthDate;

    private final HashSet<Account> accounts;

    public Customer(String firstName, String secondName, String birthDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthDate = birthDate;
        this.accounts = new HashSet<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public HashSet<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account newAccount) throws Exception {
        for (Account account : this.accounts) {
            if (account.getClass() == newAccount.getClass()) {
                throw new Exception("Customer already has this type account");
            }
        }

        this.accounts.add(newAccount);
    }
}
