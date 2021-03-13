package Account;

import java.util.ArrayList;

public class BankService {

    public double availableCash;
    public ArrayList<BankAccount> accounts = new ArrayList<>();
    private BankAccount BankAccount;
    private Customer Customer;

    public BankAccount getAccount(Customer customer){

        for(int i=0;i<accounts.size();i++){
            if(accounts.get(i).getOwner()==customer)
            {
                return accounts.get(i);
            }
        }return null;
    }

    public BankAccount getAccount(String ssn) {

        for(int i=0;i<accounts.size();i++){
            accounts.get(i);
            accounts.get(i).getOwner();
            accounts.get(i).getOwner().getSsn();
            accounts.get(i).getOwner().getSsn().equals(ssn);
            if(accounts.get(i).getOwner().getSsn().equals(ssn))
            {
                return accounts.get(i);
            }
        }
        return null;
    }


    public void checkAccountBalance(String ssn){
      if(getAccount(ssn)!=null){
          Gender gender = getAccount(ssn).getOwner().getGender();
          if(gender == Gender.MALE) {System.out.printf("Mr. %s, your account balance: %.2f ¥",getAccount(ssn).getOwner().getLastName());}
          if(gender == Gender.FAMALE) {System.out.printf("Ms. %s, your account balance: %.2f ¥",getAccount(ssn).getOwner().getLastName());}
      }
       else System.out.println("No account found");
    }

    public void createAccount(String firstName, String lastName, char gender, String ssn) {
        String name = firstName+lastName;
            if (Customer.checkName(name)==false){
                System.out.println("Invalid name");
                return;
            } else if (gender != 'm'&&gender!='f') {
                System.out.println("Invalid input for gender");
                return;
            } else if (Customer.checkSSN(ssn) == false) {
                System.out.println("Invalid social security number");
                return;
            }
            else {Customer.formatName(name);

                if (getAccount(ssn)==null)
            {
                Gender gender1 = Gender.MALE;
                if (gender == 'm'){gender1 = Gender.MALE;}
                if (gender == 'f'){gender1 = Gender.FAMALE;}
                Customer customer = new Customer(firstName,lastName,gender1,ssn);
                BankAccount bankAccount = new BankAccount(customer,0.00);
                //BankAccount.setOwner(customer);
                //BankAccount.setBalance(0.00);
                accounts.add(BankAccount);
                if(gender == 'm') {System.out.printf("Congrats, Mr. %s! Your account is created successfully.", lastName);}
                if(gender == 'f') {System.out.printf("Congrats, Ms. %s! Your account is created successfully.", lastName);}
            } else {
                if(gender == 'm'){System.out.printf("Mr. %s, you already have an account with a balance %.2f ¥.", lastName,getAccount(ssn).getBalance());}
                if(gender == 'f'){System.out.printf("Ms. %s, you already have an account with a balance %.2f ¥.", lastName,getAccount(ssn).getBalance());}
            }
            }
    }

    public void makeDeposit(String ssn, double amount){

        if(!accounts.contains(BankAccount.getOwner())){System.out.println("No account found");}
        if(Customer.checkSSN(ssn)==false){System.out.println("Invalid social security number");}
        if(amount<0){System.out.println("Invalid amount");}
        else{System.out.println("Original balance: %.2f ¥");System.out.println("Balance after deposit: %.2f ¥");}
    }

    public void withdraw(String ssn, double amount){
        BankService a = new BankService();
        //BankAccount b = new BankAccount();
        if(!accounts.contains(BankAccount.getOwner())){System.out.println("No account found");}
        if(Customer.checkSSN(ssn)==false){System.out.println("Invalid social security number");}
        if(amount<0){System.out.println("Invalid amount");}
        if(amount>availableCash){System.out.println("No enough balance or cash");}//||amount>balance
        else {System.out.println("Original balance: %.2f ¥");System.out.println("Balance after withdraw: %.2f ¥");}
    }

    public static void calculateMonthlyPayment(double loanAmount, int years)  {

        double P = loanAmount;
        String yr = "" ;
        double R = 0 ;
        if(years<=2){yr="4.35%";}
        else if(years<=5){yr="4.75%";}
        else if(years>5){yr="4.90%";}
        double y = Double.parseDouble(yr);
        R=y/12;
        double N = 12*years;
        double Payment = P*R*Math.pow((1+R),N)/(Math.pow((1+R),N)-1);
        double Total = N*Payment-P;
        System.out.printf("Calculation result:\n" +
                "Loan amount: %.2f ¥\n" +
                "Yearly interest rate: %s\n" +
                "Number of installments (months): %d\n" +
                "Monthly payment: %.2f ¥\n" +
                "Total interest: %d ¥",P,yr,N,Payment,Total);
    }

    public BankService(){
        availableCash = 100000;
        ArrayList<BankAccount> accounts = new ArrayList<>();
        System.out.println("Initializing bank service: no accounts yet, 100000.00 ¥ cash available");
    }


}

