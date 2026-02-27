import java.util.Scanner;
public class HW100 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// this data needed for method findAcct
		int[] acctNum = {1234,12,433};
		double[] balance= {40,12,234};
		int numAccts = acctNum.length;
		int account;//accout that we need to find in method findacct
		
		char user_input = ' ';
		
		while(user_input != 'Q' ) {
			menu();
			user_input = sc.next().toUpperCase().charAt(0);	
			if(user_input == 'W') {
				withdrawal(acctNum, balance, numAccts, sc);
			} else if(user_input == 'D') {
				deposit(acctNum, balance, numAccts,sc);
			} else if(user_input == 'N') {
				newAcct(acctNum, balance, numAccts, sc);
			} else if(user_input == 'B') {
				balance (acctNum, balance,  numAccts, sc);
			} else if(user_input == 'Q') {
				System.out.println("BYE!");
			} else if(user_input == 'X') {
				deleteAcct(acctNum, balance, numAccts, sc);
			} else {
				System.out.println("Try again!");
			}
		}
//		System.out.println("Program has ended!!!");
		System.out.println("Program has ended!!!");
		printAccts( acctNum, balance, numAccts);
		sc.close();
	}


	public static void menu() {
//		System.out.println("Choose of the following: ");
		System.out.println("Choose of the following: ");
		System.out.println(""
				+ "   W - Withdrawal\r\n"
				+ "   D - Deposit\r\n"
				+ "   N - New account\r\n"
				+ "   B - Balance \r\n"
				+ "   Q – Quit\r\n"
				+ "   X – Delete Account – Extra Credit");
	}
	
	
	public static int findAcct(int[] acctNum, int numAccts, int account) {
		for(int i = 0; i < numAccts; i++) {
			if(acctNum[i] == account) {
				return i;
			}
		}
		return -1;
	}	
	
	
	public static void withdrawal(int[] acctNum, double[] balance, int numAccts, Scanner sc) {
			System.out.println("Enter your account Number: ");
			int user_input_accNum = sc.nextInt();
			int index = findAcct(acctNum ,numAccts ,user_input_accNum);

			if(index == -1) {
				System.out.println("The account with number: "+ user_input_accNum + " does not exist!");
				return;
			}

		System.out.println("Enter withdrawal amount: ");
			double user_amount_withdrawal = sc.nextDouble();
			 if(user_amount_withdrawal <= 0 || user_amount_withdrawal > balance[index]) {
				 System.out.println("You can't withdrawal this amount of money: " + user_amount_withdrawal);
			} else {
				double withdrawal_result_successful  = balance[index] - user_amount_withdrawal;
				balance[index] = withdrawal_result_successful;
				 System.out.println("The account with number: " + user_input_accNum +" has now balance of: " + withdrawal_result_successful);
			}
	}	
	
	
	public static void deposit(int[] acctNum, double[] balance, int numAccts, Scanner sc) {
		System.out.println("Enter your account Number: ");
		int user_input_accNum = sc.nextInt();
		int index = findAcct(acctNum ,numAccts ,user_input_accNum);
		
		
		if(index == -1) {
			System.out.println("The account with number: "+ user_input_accNum + " does not exist!");
			return;
		} 
		
		System.out.println("Enter deposit amount: ");
		double user_amount_deposit = sc.nextDouble();
		 if(user_amount_deposit <= 0) {
			System.out.println("You can't deposit this amount of money: " + user_amount_deposit);
		} else {
			double withdrawal_result_successful  = balance[index] + user_amount_deposit;
			balance[index] = withdrawal_result_successful;
			System.out.println("The account with number: " + user_input_accNum +" has now balance of: " + withdrawal_result_successful);
		}
	}
	
	//some issue here with adding the newAccount
	public static int newAcct(int[] acctNum, double[] balance, int numAccts, Scanner sc) {
		System.out.println("Enter new account number: ");
		int input_user_newAcct = sc.nextInt();
		int index = findAcct(acctNum ,numAccts ,input_user_newAcct);
		
		if(index != -1) {
			System.out.println("The account with number: "+ input_user_newAcct + " already exists!");
			return numAccts;
		} else{
			acctNum[numAccts] = input_user_newAcct;	
			balance[numAccts] = 0.0;
			numAccts++;
		}
		return numAccts;
		
	}
	
	//prints statement balance
	public static void balance(int[] acctNum, double[] balance, int numAccts, Scanner sc) {
		System.out.println("Enter your account number: ");
		int input_user_accNum = sc.nextInt();
		int index = findAcct(acctNum ,numAccts ,input_user_accNum);
		
		if(index == -1) {
			System.out.println("The account number " + input_user_accNum + " does not exist!");
		} else {
			double balanceStatement = balance[index];
			System.out.println(balanceStatement);
		}
	}
	
	public static void printAccts(int[] acctNum, double[] balance, int numAccts) {
		
			System.out.println("CURRENT ACCOUNTS:");
			System.out.println("Account Number\tBalance");
		
			for(int i = 0; i < acctNum.length; i++) {
				System.out.printf("%-10d $%10.2f%n", acctNum[i], balance[i]);
			}
	}

	public static int deleteAcct(int[] acctNum, double[] balance, int numAccts, Scanner sc) {
			System.out.println("Enter your account number: ");
			int user_acc_number = sc.nextInt();
			int index = findAcct(acctNum,  numAccts, user_acc_number);

			if(index == -1){
				System.out.println("Account with number: "+ user_acc_number + " does not exist!");
			} else{
				for(int i = index; i < numAccts -1; i++){
					acctNum[i] = acctNum[i+1];
					balance[i] = balance[i+1];
				}
				numAccts--;
				acctNum[numAccts] = 0;
				balance[numAccts] = 0.0;
			}
			return numAccts;
	}
}
