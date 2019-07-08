package dao;

import java.io.RandomAccessFile;
import java.util.Scanner;

import bean.LogInBean;

public class Game{
	
//	LogInBean logInBean = new LogInBean();
	
	Enum enumObj = new Enum();
	Scanner sc = new Scanner(System.in);
	
	public void countryGame(LogInBean l) throws Exception {
		
		int score = 0;
		int attempts = 3;
		String ch="Y";
		String a = null;
		
		while(attempts > 0) {
			String country = enumObj.getRCountry().toString();
			System.out.println("Identify the country: " +enumObj.getCountry().toString());
			System.out.println("Enter your answer: ");
			String cName = sc.next();
			if(cName.equals(country)) {
				System.out.println("Correct Answer");
				score = score+10;
				System.out.println("Do you wish to play more...? (y/n): ");
				ch = sc.next();
				if(ch.equals("y") || ch.equals("Y")) {
					continue;
				}
				else {
					System.out.println("Your score is: " +score);
					try {
						RandomAccessFile rafObj = new RandomAccessFile("C:\\Users\\nsingh68\\Desktop\\File Demo\\score.txt", "rw");
						a = l.getUserName()+" : " +score; 
						rafObj.writeChars(a);
						rafObj.close();
					} catch (Exception e) {
						System.out.println(e);
					}
					System.out.println("Thanks for playing");
					System.exit(0);
				}
			}
			else {
				System.out.println("Wrong answer");
				System.out.println("You have " +(attempts-1)+ " attempts left");
				attempts--;
			}
		}		
	}
	
	public void cityGame() {
		System.out.println("City Game");
	}
}