package ui;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;
import bean.LogInBean;
import dao.Game;
import service.LogInService;

public class LogInModules {
	
	Scanner sc = new Scanner(System.in);
	String userName, password;
	LogInService customerServiceObj = new LogInService();
	LogInBean cb;
	Game gameObj = new Game();
	
	public void logInDetails() throws Exception {
		cb = new LogInBean("Nitin", "nitin@123");
		customerServiceObj.addLogIn(cb);
		System.out.println("Enter username: ");
		userName = sc.next();
		System.out.println("Enter password: ");
		password = sc.next();
		cb = new LogInBean(userName, password);
		customerServiceObj.logIn(cb);
		gameMenu();
	}

	public void addLogInDetails() throws Exception {
		System.out.println("Enter username: ");
		userName = sc.next();
		System.out.println("Enter password: ");
		password = validate(sc.next());
		cb = new LogInBean(userName, password);
		System.out.println("Welcome " +userName);
		gameMenu();
	}
	
	public void gameMenu() throws Exception {
		int ch;
		System.out.println("***GAME MENU***");
		System.out.println("\n 1. Start the Game \n 2. Game Description \n 3. Exit");
		ch = sc.nextInt();
		switch(ch) {
		case 1:
			gameCategory();
			break;
		case 2:
			System.out.println("Description");
			break;
		case 3:
			System.out.println("***** Thank You *****");
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
		}
	}
	
	public void gameCategory() throws Exception {
		int ch;
		System.out.println("\n 1. Country Game \n 2. City Game");
		ch = sc.nextInt();
		switch(ch) {
		case 1:
			try {
				gameObj.countryGame(cb);
			} catch (IOException e) {
				System.out.println("LogIn Module Exception");
			}
			break;
		case 2:
			gameObj.cityGame();
			break;
		default:
			System.out.println("Invalid choice");
		}
	}

	public String validate(String password) {
		if(Pattern.matches("([A-Z])*([a-z])*(@)([0-9])*", password) && ((password.length()>=5) && (password.length()<=10))) {
			return password;
		}
		else {
			System.out.println("Password do not meet the requirements");
			return password;
		}
	}	
	
}
