package controllers;

import java.util.Scanner;

import classes.Building;
import classes.Elevator;

public class Controller {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	
	public static void main(String[] args) {
		
		//Initialise new object 'in'
		in = new Scanner(System.in);
		int numberOfFloors;
		//prompt user for a number of floors to use as a parameter for the Building object
		System.out.print("Please enter the number of floors: ");
		numberOfFloors = in.nextInt();
		
		//prompt user for and store number of customers to use as a parameter for the Building object
		System.out.print("Please enter the number of customers: ");
		int numberOfCustomers = in.nextInt();
		
		//Close Scanner object 'in' after use.
		in.close();
		
		//Create new instance of Building
		Building theHyde = new Building(numberOfFloors, numberOfCustomers);
		Elevator lift = new Elevator(numberOfFloors);
		
		System.out.println("===============================================================");
		System.out.println("Floors: " + theHyde.getNumberOfFloors());
		System.out.println("Customers: " + theHyde.getNumberOfCustomers());
		System.out.println("===============================================================");
		//System.out.println("Customer list: " + theHyde.getCustomerList());
		lift.defautlStrategy();
		

	}

}
