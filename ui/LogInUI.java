package ui;

import java.util.Scanner;

public class LogInUI {
	
	public static void main(String args[])throws Exception {
		int ch;
		char choice;
		Scanner sc = new Scanner(System.in);
		LogInModules logInModulesObj = new LogInModules();
		
		do {
			System.out.println("\n *****MAIN MENU******\n 1. LogIn \n 2. Create new LogIn \n 3. Exit \n*********************");
			System.out.print("Enter your choice : ");
			ch = sc.nextInt();
			switch(ch) {
			case 1:
				logInModulesObj.logInDetails();
				break;
			case 2:
				logInModulesObj.addLogInDetails();
				break;
			case 3:
				System.out.println("***** Thank You *****");
				System.exit(0);
				break;
			}
			System.out.print("Do you want to continue (y/n)...? : ");
			choice = sc.next().charAt(0);
			if(choice == 'y' || choice=='Y')
				continue;
			else {
				System.out.println("Thank You !");
				System.exit(0);
			}
		} while(ch != 3);
		sc.close();
	}
}