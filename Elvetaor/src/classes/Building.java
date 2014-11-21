package classes;

import java.util.ArrayList;

/**
 * The Building class stores the number of floors and and the number of customers
 * that will be used in the Elevator program.
 * The class constructor Building() takes two parameters, 
 * numberOfFloors and numberOfCustomers
 * @author Mustapha Benbaziz
 * @version 1.0
 * 
 * 
 */
public class Building {
	
	private int numberOfFloors;
	private ArrayList<Customer> customerList; // list of customers willig to use an Elevator 
	private int numberOfCustomers; 
	private Elevator elevator;
	
	/**
	 * 
	 * @param f
	 * @param c
	 */
	public Building(int f, int c) {
		
		this.numberOfFloors = f; // Number of floors in the building
		numberOfCustomers = c;   // Number of customers in the building
		
		ArrayList<Customer> myList = new ArrayList<>(); // Create ArrayList of type Customer
		
		int n = 0; // Declare variable n to store the number of floors without 13
		
		//iterate through all floors of the building
		for (int i = 0; i <= numberOfFloors; i++) {
			
			n = i;
			
			// if the number of floors is greater than thirteen jump over 13 and go to the next floor 
			if(i == 13) { 
				continue; 
			}
			
			
		
			// System.out.print(" " + n);
		}
		
		for(int j = 1; j <= c; j++) {
			myList.add(new Customer(j, n)); // Add instances of Customer to ArrayList	
		}

		this.customerList = myList; // Store instances of Customer in myList

	}
	
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public void setElevator() {
		elevator = new Elevator(getNumberOfFloors());
	}
	
	public Elevator getElevator() {
		return elevator;	
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
}
