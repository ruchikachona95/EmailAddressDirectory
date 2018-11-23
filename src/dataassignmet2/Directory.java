package dataassignmet2;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

//import dataassignment1.Events;
//import dataassignment1.OurDate;
//import dataassignment1.OurTime;

/***********************************************************************************
Assignment 2 Email Lists; 
Date: 2017/12/18
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Data members: sc: Scanner - get the user input;
              emaillist: ArrayList<EmailList> - an array list to hold the email lists from EmailList objects;
              name: String - get the user input to decide which specific email list will be used to add or delete an entry or display that list;
Methods:  addEmailList() - add email lists to the array list
		  displayEmailList() -  display all email lists in the array list
          addEntryToList() - add an email address to the specific email list based on the list name the user has input
          deleteEntryToList() - delete an email address to the specific email list based on the list name the user has input
          displayAnEmailList() -  display an specific email list based on the list name the user has input   
          readListFromFile() - read all email lists from the file       
*************************************************************************************/


public class Directory {
	
		  private Scanner sc = new Scanner(System.in);
		  private Scanner fsc = new Scanner(System.in);
		  private ArrayList<EmailList> emaillist = new ArrayList<EmailList>();
		  private String name;
		   
		   
		   
			   
			   public void addEmailList(){
				  EmailList newemaillist = new EmailList();
				  newemaillist.createANewList();
				  emaillist.add(newemaillist);
			   }
				   
			   
				public void displayEmailList(){
					if(emaillist.size() == 0){
						System.out.println("This email list is empty. Please choose 'c' first.");
					
					}else{
				   for(EmailList disemaillist : emaillist){
					   disemaillist.displayList();
				   }
						}
						
				}
				
				public void addEntryToList(){
					boolean x = false;
					if(emaillist.size() == 0){
						System.out.println("This email list is empty. Please choose 'c' first.");
					
					}else{
				   System.out.print("Enter the name of list to add to:");
				   name = sc.next();
				   for(EmailList addemailentry : emaillist){
					   if(addemailentry.isEqual(name))
						   addemailentry.addAnNewEntry();
					   x = true;
					   
					   if (x==false)
						   System.out.println("Not a name from the email list");
				   }
				   }
				}
				
			   public void deleteEntryToList(){
				   boolean x = false;
				   if(emaillist.size() == 0){
						System.out.println("This email list is empty. Please choose 'c' first.");
					
					}else{
				   System.out.print("Enter the name of list to delete from:");
				   name = sc.next();
				   for(EmailList delemailentry : emaillist){
					   if(delemailentry.isEqual(name))
						   delemailentry.deleteAnEntry();
					   x=true;
						
					   if (x==false)
						   System.out.println("Not a name from the email list");
				   }
				   }
			   }
			   
			   public void displayAnEmailList(){
				   boolean x = false;
				   if(emaillist.size() == 0){
						System.out.println("This email list is empty. Please choose 'c' first.");
					
					}else{
				   System.out.print("Enter the name of list to display:");
				   name = sc.next();
				   for(EmailList disemaillist : emaillist){
					   if(disemaillist.isEqual(name))
						   disemaillist.displayList();
					       x=true;
					   
					   
					   if (x==false)
						   System.out.println("Not a name from the email list");
				   }
				   }		
				   }
				  
				 
			  
			public void readListFromFile(){
				System.out.print("Enter the name of file to process:");
				
				   try {
					   File file = new File(fsc.next());
					   
						 fsc = new Scanner(file);
					} catch (IOException i) {
						System.out.println("No such file. Terminating.");
						
					}
				   
				   
				   try {
						int total = fsc.nextInt();
						for(int i = 0; i < total && fsc.hasNext(); i++){
							EmailList fileemaillist = new EmailList();
							fileemaillist.readFromFile(fsc);
							emaillist.add(fileemaillist);
						}
						System.out.println("Email addresses added");
					} catch (NoSuchElementException nse) {
						System.out.print("No such element");
					}
				   fsc.close();
			}
		

		
	}

