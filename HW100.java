import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
public class HW100 {

	public static void main(String[] args) throws IOException {
		PrintWriter outputfile = new PrintWriter("output.txt");
		Scanner sc = new Scanner(new File("initAccts.txt"));
		// this data needed for method findAcct
		int[] acctNum = new int[20];
		double[] balance= new double[20];
		int numAccts = acctNum.length;
		int account;//accout that we need to find in method findacct
		

		
		char user_input = ' ';
		
		while(user_input != 'Q' ) {
			menu(outputfile);
			user_input = sc.next().toUpperCase().charAt(0);	
			if(user_input == 'W') {
				withdrawal(acctNum, balance, numAccts, outputfile);
			} else if(user_input == 'D') {
				deposit(acctNum, balance, numAccts);
			} else if(user_input == 'N') {
				newAcct(acctNum, balance, numAccts);
			} else if(user_input == 'B') {
				balance (acctNum, balance,  numAccts);
			} else if(user_input == 'Q') {
				System.out.println("BYE!");
			} else if(user_input == 'X') {
				
			} else {
				System.out.println("Try again!");
			}
		}
//		System.out.println("Program has ended!!!");
		outputfile.println("Program has ended!!!");
		printAccts( acctNum, balance, numAccts);
		sc.close();
	}

	public static void menu(PrintWriter outputfile) {
//		System.out.println("Choose of the following: ");
		outputfile.println("Choose of the following: ");
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
	
	
	public static void withdrawal(int[] acctNum, double[] balance, int numAccts, PrintWriter outputfile) {
			System.out.println("Enter your account Number: ");
			Scanner sc = new Scanner(System.in);
			int user_input_accNum = sc.nextInt();
			int index = findAcct(acctNum ,numAccts ,user_input_accNum);

			if(index == -1) {
				outputfile.println("The account with number: "+ user_input_accNum + " does not exist!");
				return;
			}

		outputfile.println("Enter withdrawal amount: ");
			double user_amount_withdrawal = sc.nextDouble();
			 if(user_amount_withdrawal <= 0 || user_amount_withdrawal > balance[index]) {
				 outputfile.println("You can't withdrawal this amount of money: " + user_amount_withdrawal);
			} else {
				double withdrawal_result_successful  = balance[index] - user_amount_withdrawal;
				 outputfile.println("The account with number: " + user_input_accNum +" has now balance of: " + withdrawal_result_successful);
			}
			sc.close();
	}	
	
	
	public static void deposit(int[] acctNum, double[] balance, int numAccts) {
		System.out.println("Enter your account Number: ");
		Scanner sc = new Scanner(System.in);
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
			System.out.println("The account with number: " + user_input_accNum +" has now balance of: " + withdrawal_result_successful);
		}
		sc.close();
	}
	
	//some issue here with adding the newAccount
	public static int newAcct(int[] acctNum, double[] balance, int numAccts) {
		Scanner sc  = new Scanner(System.in);
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
		sc.close();
		return numAccts;
		
	}
	
	//prints statement balance
	public static void balance(int[] acctNum, double[] balance, int numAccts) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your account number: ");
		int input_user_accNum = sc.nextInt();
		int index = findAcct(acctNum ,numAccts ,input_user_accNum);
		
		if(index == -1) {
			System.out.println("The account number " + input_user_accNum + " does not exist!");
		} else {
			double balanceStatement = balance[index];
			System.out.println(balanceStatement);
		}
		sc.close();
	}
	
	public static void printAccts(int[] acctNum, double[] balance, int numAccts) {
		
			System.out.println("CURRENT ACCOUNTS:");
			System.out.println("Account Number\tBalance");
		
			for(int i = 0; i < acctNum.length; i++) {
				System.out.printf("%-10d $%10.2f%n", acctNum[i], balance[i]);
			}
	}
}
