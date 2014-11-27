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
	private ArrayList<Customer> customerList; // list of customers in the Building 
	private int numberOfCustomers; 
	private Elevator elevator;
	
	/**
	 * Constructs instances of Building
	 * @param f represents the number of floors, to be decided by the user
	 * @param c represents the number of customers, to
	 */
	public Building(int f, int c) {
		
		this.numberOfFloors = f; // Number of floors in the building
		numberOfCustomers = c;   // Number of customers in the building
		
		ArrayList<Customer> myList = new ArrayList<>(); // Create ArrayList of type Customer
		
		for(int j = 1; j <= c; j++) {
			myList.add(new Customer(j, numberOfFloors)); // Add instances of Customer to ArrayList	
		}

		this.customerList = myList; // Store instances of Customer in myList
		
		this.setElevator();

	}
	
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	public void setElevator() {
		elevator = new Elevator(this.getNumberOfFloors());
	}
	
	public Elevator getElevator() {
		return elevator;	
	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}
	
	/**
	 * moves the elevator to the top of the building
	 */
	public void defautlStrategy() {
		elevator.setDirection(1);
		for(int i = 0; i < elevator.getNumOfFloors(); i++) {
			if(i == 13) {
				continue;
			}			 
			//this.currentFloor = i; // we need current floor to be set by function move not somewhere else ;-)
			// if you wan it to work with your move function just uncomment it !
				elevator.move();
		}
		System.out.println("---------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i > 0; i--) {
			if(i == 13) {
				continue;
			}
			 
			//this.currentFloor = i; // we need current floor to be set by function move not somewhere else ;-)
			// if you wan it to work with your move function just uncomment it !
			elevator.move();	
		}
	}
	
}
