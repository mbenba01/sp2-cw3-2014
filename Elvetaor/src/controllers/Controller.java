package controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import classes.Building;
import classes.Customer;

public class Controller {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	
	public static void main(String[] args) {
		
		
		int numberOfFloors = 15;
		int numberOfCustomers = 10;
		boolean userInput=true;
		
		do{
			try{
				//Initialise new object 'in'
				in = new Scanner(System.in);
				//prompt user for a number of floors to use as a parameter for the Building object
				System.out.print("Please enter the number of floors: ");
				int floors = in.nextInt();
					if(floors < 1) throw new InputMismatchException("must be bigger than 1");
					else numberOfFloors = floors;
				//prompt user for and store number of customers to use as a parameter for the Building object
				System.out.print("Please enter the number of customers: ");
				int customers = in.nextInt();
					if(customers < 1) throw new InputMismatchException("must be bigger than 1");
					else numberOfCustomers = customers;
				userInput = false;
			}catch (InputMismatchException e){
				System.out.println("wrong input, please try again!!!");
				userInput=true;
				continue;
			}
			
			userInput=false; // in order to finish while loop
		}while(userInput); 
		
		//Close Scanner object 'in' after use.
		in.close();
		
		//Create new instance of Building
		Building theHyde = new Building(numberOfFloors, numberOfCustomers);
		
		ArrayList<Customer> customersInBuilding = theHyde.getCustomerList();
		
		// copying the list in order to compare strategies on the same input for better readability
		ArrayList<Customer> customersInBuilding2 = new ArrayList<Customer>(customersInBuilding);
		
		//System.out.println(customersInBuilding); // printing content of the buildings Customers list
		System.out.println(theHyde.getCustomerList() + "\n===========================================");
		theHyde.defaultStrategy();
		
		theHyde.setCustomerList(customersInBuilding2);
		
		theHyde.testStrategy(); // <------- test strategy. change to efficientStrategy() !!!!!!!    <---------------
		
		// comment or uncomment in order to switch off/on output from class Building
		//System.out.println(theHyde.getLog());
		//System.out.println(theHyde.getOutput());
	}

}
