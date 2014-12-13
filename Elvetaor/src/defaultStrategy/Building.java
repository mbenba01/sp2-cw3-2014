package defaultStrategy;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
	
	private int numberOfFloors; // assigned randomly by the user
	private ArrayList<Customer> customerList; //list of customers in the building
	private Customer liftUser; // individual customer
	private int numberOfCustomers; // assigned randomly
	private Elevator elevator; // reference to the Elevator object
	
	/**
	 * Constructs instances of Building 
	 * @param f represents the number of floors, to be decided by the user
	 * @param c represents the number of customers, to be decided by the user
	 */
	public Building(int f, int c) {
		
		this.numberOfFloors = f; // Number of floors in the building
		numberOfCustomers = c;   // Number of customers in the building
		
		ArrayList<Customer> myList = new ArrayList<>(); // Create ArrayList of type Customer
		
		
		for(int j = 1; j <= c; j++) {
			myList.add(new Customer(j, numberOfFloors)); // Add instances of Customer to ArrayList	
		}

		this.customerList = myList; // Store instances of Customer in myList
		setElevator();
	}
	
	public Building() {
		
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
	
	public Customer getLiftUser() {
		return liftUser;
	}
	
	/**
	 * 
	 * @param c represents the elevator's current floor
	 */
	public void efficientStrategy(Customer e, int c) {
		c = 0;
		int numberOfStops = 0;	
		while(c <= this.getNumberOfFloors()) {
			for(int i = 0; i < this.getCustomerList().size(); i++) {
				e = this.customerList.get(i);
				if(c == e.getCurrentFloor()) {
					System.out.print("Customer " + e.getId() + " comes in on floor: " + e.getCurrentFloor());
					if(e.getCurrentFloor() < e.getDestinationFloor()) {
						System.out.println(" and going up!");
					} 
					else if(e.getCurrentFloor() > e.getDestinationFloor()) 
					{
						System.out.println(" and going down!");
					} 
					else 
					{
						System.out.println(" and staying put!");
					} 
					elevator.customerJoins(e);
					this.customerList.remove(e);
					i--;
					System.out.println("");
					System.out.println("elevator register list size: " + elevator.getRegisterList().size());
					numberOfStops++; // sums the number of stops the elevator makes 
				}
				
			}
			//for(int i = 0; i < )
			c++;		
		}
		System.out.println("The elevator has made " + numberOfStops + " stops");
	}
	
}
