public class User {

        private String Name;
        private String Password;
        private double Money;
        private double expense;
        private double income;

        public void setName(String Name) {
            this.Name = Name;
        }
        public void setPassword(String Password) {
        this.Password = Password;
        }
        public void setMoney(double Money) {
        this.Money = Money;
        }

        public void introduce() {
        System.out.printf("My name is %s and I have %.2f dollar\n",Name,Money);
        }

        public void expense(double expense) {
            this.expense = expense;

            if((Money-expense)<0){
                System.out.printf("no sufficient funds\n");}
            else if(Money-expense>=0){
                Money=Money-expense;
                System.out.printf("You have expense %.2f dollar and the remained amount is %.2f\n",expense,Money);}

    }
        public void income(double income) {
        this.income = income;
        Money=Money+income;
        System.out.printf("The remained amount is %.2f\n",Money);
    }

}

