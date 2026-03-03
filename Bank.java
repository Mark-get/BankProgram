import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts = new ArrayList<>();

    public Account findAccount(int accNum){
        for(Account account: accounts){
            if(account.getAccountNumber() == accNum){
                return account;
            }
        }
        return null;
    }

    public void createNewAccount(Account account){
        Account isReal = findAccount(account.getAccountNumber());
        if(isReal == null){
            accounts.add(account);
            System.out.println("New Acc: "+ account.getAccountNumber());
        } else {
            System.out.println("Account " + account.getAccountNumber() + " is not found");
        }
    }

    public void deleteAccount(int accNum){
        Account accountToDelete = findAccount(accNum);
        if(accountToDelete != null){
            accounts.remove(accountToDelete);
            System.out.println("Account with number " + accNum + " has been successfuly deleted");
        } else{
            System.out.println("Account " + accNum + " is not found");
        }
    }

    public void printAllAccounts(){
        for(Account account: accounts){
            System.out.println(account.getAccountNumber());
            System.out.println(account.getBalance());
        }
    }
}
