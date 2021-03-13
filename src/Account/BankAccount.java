package Account;



public class BankAccount{


    private Customer owner;
    private double balance = 0.0;
    public BankAccount(Customer Customer, double balance){
        //this.owner = customer;
        //this.balance = balance;
        setBalance(balance);
        setOwner(Customer);

    }

    public void setOwner(Customer Customer ){
        this.owner = Customer;
    }

    public Customer getOwner(){
        return owner;
    }

    public void setBalance(double balance){

        this.balance = balance;
    }

    public double getBalance(){
        return  balance;
    }


}
