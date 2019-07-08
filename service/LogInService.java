package service;

import java.util.Scanner;

import bean.LogInBean;
import dao.*;

public class LogInService {
	
	Scanner sc = new Scanner(System.in);
	LogInDao logInDaoObj;
	LogInBean logInBeanObj;	

	public void logIn(LogInBean logInBeanObj) {		
		
		if(logInDaoObj.hm().isEmpty()) {
			System.out.println("Please create an account first");
		}
		else {
			if(logInDaoObj.hm().containsKey(logInBeanObj.getUserName())) {
				if(logInDaoObj.hm().get(logInBeanObj.getUserName()).getPassword().equals(logInBeanObj.getPassword())) {
					System.out.println("Welcome " +logInBeanObj.getUserName());
				}
				else {
					System.out.println("Password is wrong");
				}
			}
			else {
				System.out.println("User Not Exist");
			}
		}	
	}
	
	public void addLogIn(LogInBean logInBeanObj) {
		logInDaoObj = new LogInDao(logInBeanObj);
	}	
}