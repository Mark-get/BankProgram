    public class Account {
        private int account_number;
        private double balance;

        public Account(int account_number, double balance){
            this.account_number = account_number;
            this.balance = balance;
        }

        public boolean withdrawal(double amount){
           if(amount <= 0){
               System.out.println("Amount should be more than 0");
               return false;
           } else if(amount > this.balance){
               System.out.println("Amount can't be more than balance");
               return false;
           } else {
               this.balance = this.balance - amount;
               System.out.println("New balance: " + this.balance);
               return true;
        }
    }
        public boolean deposit(double deposit){
            if(deposit <= 0){
                System.out.println("Amount should be more than 0");
                return false;
            } else {
                this.balance = this.balance + deposit;
                System.out.println("New balance: " + this.balance);
                return true;
            }
        }
        public double getBalance(){
            return balance;
        }
        public int getAccountNumber(){
            return account_number;
        }
}