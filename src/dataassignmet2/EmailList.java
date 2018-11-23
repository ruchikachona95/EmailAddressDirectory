package dataassignmet2;

import java.util.*;
/***********************************************************************************
Assignment 2 Email Lists; 
Date: 2017/12/18
Information for this class:
Class:  EmailAddress
Purpose:  This class will model the data and actions needed for an email address data type
Data members:   sc: Scanner - get the input from user;
                listname: String - the name of the email list
                choice: String - get the input from user to decide whether a new email address should be created;
                emailaddress: LinkedList<EmailAddress> - a linked list to hold the email addresses from EmailAddress objects;
                newemailaddress - an object from EmailAddress class.
                continueLoop: boolean - to continue the loop until the user inputs "n" to finishing typing new email addresses.
Methods: createANewList(): void - create a new email list;
		 addAnNewEntry(): void -  create a new email address for one specific existing email list
		 deleteAnEntry(): void - delete an existing email address for one specific existing email list
         isEqual(String):  - returns the data of the emailAddress field
         displayList() - display the email list   	   
         readFromFile(Scanner) - read an email list from a file       
*************************************************************************************/

public class EmailList {
	Scanner sc = new Scanner(System.in);
    private String listname,choice;
    private LinkedList<EmailAddress> emailaddress = new LinkedList<EmailAddress>();
    EmailAddress newemailaddress = new EmailAddress();
    boolean continueLoop = true;
    
    public void createANewList(){
    	System.out.print("Enter the name of the list:");
    	listname = sc.next();
    	
    	newemailaddress.readAdress(sc,"k");
    	emailaddress.add(newemailaddress);
    	
    	while(continueLoop){
    	System.out.print("Another? y/n:");
    	choice = sc.next();
    	EmailAddress newemailaddress = new EmailAddress();
    	if(choice.equals("y")){
    		newemailaddress.readAdress(sc,"k");
        	emailaddress.add(newemailaddress);
    	}else
    		break;
    	}
    }
    
    public void addAnNewEntry(){
    	EmailAddress newemailaddress = new EmailAddress();
    	newemailaddress.readAdress(sc,"k");
    	emailaddress.add(newemailaddress);
    }
    
    
    public void deleteAnEntry(){
    	int num;
    	System.out.println(listname);
    	for(int i = 0; i < emailaddress.size(); i++){
    		System.out.printf("%d %s\n",i,emailaddress.get(i));
    	}
    	System.out.print("Enter the number to delete:");
    	num = sc.nextInt();
    	emailaddress.remove(num);
    }
    
    public void readFromFile(Scanner rf){
    	listname = rf.next();
    	int num = rf.nextInt();
    	
    	for(int i = 0; i < num ; i++){
    		EmailAddress fileemailaddress = new EmailAddress(rf.next());
    		emailaddress.add(fileemailaddress);
    	}
    	
    }
    public boolean isEqual(String name){
    	if(name.equals(listname))
    		return true;
    	else 
    		return false;
    }
    
    public void displayList(){
    	System.out.print(listname + " : ");
    	Iterator<EmailAddress> itr = emailaddress.iterator();
    	System.out.print("[");
    	while(itr.hasNext()){
    		System.out.print(itr.next() + " ");
    	}
    	System.out.println("]");
    }
    
}
