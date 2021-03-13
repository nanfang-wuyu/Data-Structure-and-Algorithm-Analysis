package a5.a5;

import Account.BankAccount;
import Account.Customer;

import java.util.ArrayList;

public class BankService {
    private double availableCash;
    private ArrayList<BankAccount> accounts;

    public BankService() {
        System.out.println("Initializing bank service: no accounts yet, 100000.00 \u00A5 cash available");
        availableCash = 100000.0;
        accounts = new ArrayList<BankAccount>();
    }

    public BankAccount getAccount(Customer customer) {
        for(BankAccount account : accounts) {
            if(account.getOwner().getSocialSecurityNumber().equals(customer.getSocialSecurityNumber())) {
                return account;
            }
        }
        return null;
    }

    public BankAccount getAccount(String ssn) {
        if(!Customer.checkSSN(ssn)) {
            System.out.println("Invalid social security number");
            return null;
        }
        for(BankAccount account : accounts) {
            if(account.getOwner().getSocialSecurityNumber().equals(ssn)) {
                return account;
            }
        }
        System.out.println("No account found");
        return null;
    }

    public void checkAccountBalance(String ssn) {
        BankAccount account = getAccount(ssn);
        if(account != null) {
            String title = account.getOwner().getGender() == Gender.MALE ? "Mr." : "Ms.";
            System.out.printf("%s %s, your account balance: %.2f \u00A5\n", title, account.getOwner().getLastName(), account.getBalance());
        }
    }

    public void createAccount(String firstName, String lastName, char gender, String ssn) {
        if(!Customer.checkName(firstName) || ! Customer.checkName(lastName)) {
            System.out.println("Invalid name");
            return;
        }
        gender = Character.toLowerCase(gender);
        if(gender != 'm' && gender != 'f') {
            System.out.println("Invalid input for gender");
            return;
        }
        if(!Customer.checkSSN(ssn)) {
            System.out.println("Invalid social security number");
            return;
        }
        Customer customer = new Customer(Customer.formatName(firstName), Customer.formatName(lastName), Character.toLowerCase(gender) == 'm' ? Gender.MALE : Gender.FEMALE, ssn);

        String title = (customer.getGender() == Gender.MALE) ? "Mr." : "Ms.";

        BankAccount account = getAccount(customer);
        if(account != null) {
            System.out.printf("%s %s, you already have an account with a balance %.2f \u00A5.\n", title, customer.getLastName(), account.getBalance());
        } else {
            account = new BankAccount(customer, 0.0);
            accounts.add(account);
            System.out.printf("Congrats, %s %s! Your account is created successfully.\n", title, customer.getLastName());
        }
    }

    public void makeDeposit(String ssn, double amount) {
        BankAccount account = getAccount(ssn);
        if(account != null) {
            if(amount >= 0) {
                System.out.printf("Original balance: %.2f \u00A5\n", account.getBalance());
                account.setBalance(account.getBalance() + amount);
                System.out.printf("Balance after deposit: %.2f \u00A5\n", account.getBalance());
            } else {
                System.out.println("Invalid amount");
            }
        }
    }

    public void withdraw(String ssn, double amount) {
        BankAccount account = getAccount(ssn);
        if(account != null) {
            if(amount < 0) {
                System.out.println("Invalid amount");
                return;
            }
            if(account.getBalance() < amount || availableCash < amount) {
                System.out.println("No enough balance or cash");
                return;
            }
            System.out.printf("Original balance: %.2f \u00A5\n", account.getBalance());
            account.setBalance(account.getBalance() - amount);
            availableCash -= amount;
            System.out.printf("Balance after deposit: %.2f \u00A5\n", account.getBalance());
        }
    }

    public static void calculateMonthlyPayment(double loanAmount, int years) {
        if(loanAmount <= 0 || years < 1) {
            System.out.println("invalid loan");
            return;
        }
        double yearlyRate = (years >= 1 && years <= 2) ? 4.35 : (years >= 3 && years <= 5) ? 4.75 : 4.9;
        double monthlyRate = yearlyRate / 12 / 100;
        double monthlyPayment = loanAmount * monthlyRate * (Math.pow(1 + monthlyRate, years * 12)/(Math.pow(1 + monthlyRate, years * 12) - 1));

        System.out.println("\nCalculation result:");
        System.out.printf("Loan amount: %,.2f \u00A5\n", loanAmount);
        System.out.printf("Yearly interest rate: %.2f%%\n", yearlyRate);
        System.out.printf("Number of installments (months): %d\n", years * 12);
        System.out.printf("Monthly payment: %,.2f \u00A5\n", monthlyPayment);
        System.out.printf("Total interest: %,.2f \u00A5\n", monthlyPayment * years * 12 - loanAmount);
    }

}
