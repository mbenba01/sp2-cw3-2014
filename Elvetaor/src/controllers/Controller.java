package controllers;

import java.util.ArrayList;
import java.util.Scanner;

import classes.Building;
import classes.Customer;
import classes.Elevator;

public class Controller {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	
	public static void main(String[] args) {
		
		/*//Initialise new object 'in'
		in = new Scanner(System.in);
		int numberOfFloors;
		//prompt user for a number of floors to use as a parameter for the Building object
		System.out.print("Please enter the number of floors: ");
		numberOfFloors = in.nextInt();
		 
		//prompt user for and store number of customers to use as a parameter for the Building object
		System.out.print("Please enter the number of customers: ");
		int numberOfCustomers = in.nextInt();
		
		//Close Scanner object 'in' after use.
		in.close();*/
		
		//Create new instance of Building
		Building theHyde = new Building(15, 10);
		//Elevator lift = new Elevator(15);
		ArrayList customersInBuilding = theHyde.getCustomerList();
		ArrayList<Customer> customersInBuilding2 = new ArrayList<Customer>(customersInBuilding);
		System.out.println(customersInBuilding.size()+" size!");
		System.out.println(customersInBuilding);
		System.out.println("===============================================================");
		System.out.println("Floors: " + theHyde.getNumberOfFloors());
		System.out.println("Customers: " + theHyde.getNumberOfCustomers());
		System.out.println("===============================================================");
		
		theHyde.defaultStrategy();
		
		Building theHyde2 = new Building(15, 10);
		System.out.println(customersInBuilding2.size()+" size!");
		theHyde2.setCustomerList(customersInBuilding2);
		theHyde2.efficientStrategy();
		

	}

}
