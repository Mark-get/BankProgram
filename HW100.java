import java.util.Scanner;
public class HW100 {

	public static void main(String[] args) {
		Bank bank = new Bank();
	Scanner scanner = new Scanner(System.in);
	char userInput = ' ';
	while(userInput != 'Q'){
		menu();
		userInput = scanner.next().toUpperCase().charAt(0);
		if(userInput == 'W') {
				System.out.print("Enter account number: ");
				int AccountUserInput = scanner.nextInt();
				Account account = bank.findAccount(AccountUserInput);

				if(account != null){
					System.out.print("Enter withdrawal amount: ");
					double amount = scanner.nextDouble();
					account.withdrawal(amount);
				} else {
					System.out.println(bank.findAccount(AccountUserInput));
				}

			} else if(userInput == 'D') {
				System.out.print("Enter account number: ");
				int AccountUserInput = scanner.nextInt();
				Account account = bank.findAccount(AccountUserInput);

				if(account != null){
					System.out.print("Enter deposit amount: ");
					double amount = scanner.nextDouble();
					account.deposit(amount);
				} else {
					System.out.println(bank.findAccount(AccountUserInput));
				}
			} else if(userInput == 'N') {
				System.out.print("Enter new account number: ");
				int new_Account_Number = scanner.nextInt();
				Account newAccount = new Account(new_Account_Number, 0);
				bank.createNewAccount(newAccount);

			} else if(userInput == 'B') {
				System.out.print("Enter account number: ");
				int UserAccount = scanner.nextInt();
				Account account = bank.findAccount(UserAccount);
					if(account == null){
						System.out.println("Account with number: " + "does not exist");
					} else {
						System.out.println("Balance on account: " + UserAccount + " is "+ account.getBalance());
					}
			} else if(userInput == 'Q') {
				System.out.println("BYE!");
			} else if(userInput == 'X') {
			System.out.print("Enter account number: ");
			int userAccount = scanner.nextInt();
			bank.deleteAccount(userAccount);

			} else {
				System.out.println("Try again!");
			}
		}
		System.out.println("Program has ended!!!");
		bank.printAllAccounts();
	}

	public static void menu() {
		System.out.println("Choose of the following: ");
		System.out.println("Choose of the following: ");
		System.out.println(""
				+ "   W - Withdrawal\r\n"
				+ "   D - Deposit\r\n"
				+ "   N - New account\r\n"
				+ "   B - Balance \r\n"
				+ "   Q – Quit\r\n"
				+ "   X – Delete Account – Extra Credit");
	}
}
