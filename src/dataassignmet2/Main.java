package dataassignmet2;

import java.util.Scanner;

/***********************************************************************************
Assignment 2 Email Lists; 
Date: 2017/12/18
Information for this class:
Class:  EmailAddress
Purpose:  This class will display the menu and excute the command from the user input
Data members:  sc: Scanner - get the user input;
               continueLoop: boolean - to continue the loop until the option of "exit" is input;
               choice: String - get the input from user to decide which option is chosen.
               directory - an object from the Directory class
Methods: main(String[]) - void - display the menu and excute the command from the user input
		         
*************************************************************************************/

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		   boolean continueLoop = true;
		   String choice;
		Directory directory = new Directory();
		
		 
  do{
			   
			   System.out.println("c ... to create a new list");
			   System.out.println("p ... to display all the email lists");
			   System.out.println("a ... to add an entry to a list");
			   System.out.println("d ... to delete an entry from a list");
			   System.out.println("l ... to display a list");
			   System.out.println("f ... to load lists from file");
			   System.out.println("q ... to quit");
			   System.out.println("Enter your choice:");
			   choice = sc.next();
			 
			   
			   if(choice.equals("c")){
				  directory.addEmailList();
				   
				   
			   
				}else if(choice.equals("p")){
					directory.displayEmailList();
						
			   }else if(choice.equals("a")){
				   directory.addEntryToList();
				   
			   }else if(choice.equals("d")){
				  directory.deleteEntryToList();
			   }else if(choice.equals("l")){
				 directory.displayAnEmailList();
							
				 
			   }else if(choice.equals("f")){
				  directory.readListFromFile();
			   }else if(choice.equals("q")){
				   System.out.print("Bye... See you again");
		           break;
			   } else
			    	  System.out.println("Invalid choice... try again");
		   
		      
	       }while(continueLoop);
		}

	}

