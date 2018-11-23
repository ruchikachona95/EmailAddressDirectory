package dataassignmet2;
import java.util.Scanner;
/***********************************************************************************
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Author:   Anu Thomas
Course:   CST8130 - Data Structures
Data members:   emailAddress: String - hold the value of a valid email address
Methods: EmailAddress() - default constructor - set empty string field
		 EmailAddress(String) -  sets object to String parameter emailAddress if valid 
         toString(): String - returns the data of the emailAddress field
         readAddress(Scanner)- reads in valid address from Scanner if prompt is 'k' otherwise reads from file      	          
*************************************************************************************/

import java.util.Scanner;

/***********************************************************************************
Assignment 2 Email Lists; 
Date: 2017/12/18
Information for this class:
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Data members:   emailAddress: String - hold the value of a valid email address
Methods: EmailAddress() - default constructor - set empty string field
		 EmailAddress(String) -  sets object to String parameter emailAddress if valid 
         toString(): String - returns the data of the emailAddress field
         readAddress(Scanner)- reads in valid address from Scanner if prompt is 'k' otherwise reads from file      	          
*************************************************************************************/

public class EmailAddress {
	
	private String emailAddress;
	
	public EmailAddress(){
		emailAddress = new String();
	}
	
	public EmailAddress (String email){
		if(email.contains("@") && email.contains(".") && email.length()>7)
			emailAddress = email;
	}
	
	public String toString(){
		return emailAddress;
	}
	
	public void readAdress (Scanner in, String prompt){
		if(prompt.charAt(0) == 'k')
			System.out.println("Enter valid email address: ");
		emailAddress = in.next();
		
		while(!emailAddress.contains("@") || !emailAddress.contains(".") || emailAddress.length() < 7){
			System.out.println("Enter valid email address.... it should contain @ and . and should be atleast 7 characters long");
			emailAddress = in.next();
		}
	}
}
