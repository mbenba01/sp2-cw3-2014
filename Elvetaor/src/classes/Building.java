package classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

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
	private String output;
	private String log;
	
	/**
	 * Constructs instances of Building
	 * @param f represents the number of floors, to be decided by the user
	 * @param c represents the number of customers, to
	 */
	public Building(int f, int c) {
		
		this.numberOfFloors = f-1; // Number of floors in the building
		numberOfCustomers = c;   // Number of customers in the building
		
		ArrayList<Customer> myList = new ArrayList<>(); // Create ArrayList of type Customer
		
		for(int j = 1; j <= c; j++) 
		{
			Customer d = new Customer(j, numberOfFloors);
			myList.add(d);	
		}

		this.customerList = myList; // Store instances of Customer in myList
		
		this.setElevator();
		this.output = "";
	}
	/**
	 * setters and getters...
	 */
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
	public void setCustomerList(ArrayList<Customer> al){
		this.customerList = al;
	}
	public void setOutput(String s){
		this.output+=s;
	}
	public String getOutput(){
		return this.output;
	}
	public void log(String s){
		this.log+=s+'\n';
	}
	public String getLog(){
		return this.log;
	}
	/**
	 * moves the elevator from the bottom to the top of the building.
	 * Stops at each floor and checks for customers willing to enter the lift and also checks if
	 * any of the customers wants to leave the elevator
	 */
	public void defaultStrategy() 
	{
		log("defaultStrategy: =========================================================");
		int totalStops = 0;
		elevator.setCurrentFloor(0); // setting elevator current floor hard in order to have correct comparison between methods	
		elevator.setDirection(1);
		
		for(int i = 0; i <= elevator.getNumOfFloors(); i++) 
		{
			if(i == 13) 
			{
				continue;
			}
			if(elevator.getCurrentFloor() != 0) {
				log("Going up to floor: " + (elevator.getCurrentFloor()));
			}
			this.checkFloor(i);
			elevator.move();
			
			totalStops++;
		}
		log("---------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--) 
		{
			if(i == 13) 
			{
				continue;
			}
			if(elevator.getCurrentFloor() !=  elevator.getNumOfFloors()){
			log("Going down to floor: " + (elevator.getCurrentFloor()));
			}
			this.checkFloor(i);
			elevator.move();
			
			totalStops++;
		}
		log("======================================================");
		log("elevator register list size: " + elevator.registerList.size());
		log("building customer list size: " + this.customerList.size()+'\n');
		this.output += "defaultStrategy(): Number of stops: " + totalStops + '\n';
	}
	/**
	 * moves through the floors of the building but only stops where customers are present.
	 * This ensures the elevator only stops when there are customers present on floors.
	 */
	public void efficientStrategy() 
	{
		log("efficientStrategy: =========================================================");
		int totalStops = 0;
		elevator.setDirection(1);  // elevator goes up only in case if lift is on the ground floor 
		elevator.setCurrentFloor(0); // setting elevator current floor hard in order to have correct comparison between methods
		
		for(int i = 0; i <= elevator.getNumOfFloors(); i++) 
		{
			this.checkFloor(i);
			elevator.move();
			
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				if(e.getCurrentFloor() == elevator.getCurrentFloor() || e.getDestinationFloor() == elevator.getCurrentFloor()) {
					totalStops++;
				}
				
			}
		}
		log("---------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--) 
		{
			this.checkFloor(i);
			elevator.move();
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				if(e.getDestinationFloor() == elevator.getCurrentFloor()) {
					totalStops++;
				}
			}
		}
		log("======================================================");
		log("elevator register list size: " + elevator.registerList.size());
		log("building customer list size: " + this.customerList.size());
		this.output += "efficientStrategy(): Number of stops: " + totalStops + '\n';
	}
	/**
	 * checks if there is someone waiting for the elevator on the floor "f".
	 * also checks if there is someone in the elevator with destination equal "f".
	 * @param f a current floor where check is performed
	 */
	public void checkFloor(int f)
	{
		for(int i = 0; i < this.customerList.size(); i++)
		{
			Customer c = this.customerList.get(i);
			
			if(c.getCurrentFloor() == f)
			{
				log("Customer " + c.getId() + " enters on floor: "+ f);
				this.customerJoinsElevator(c);
				this.customerList.remove(c);
				i--;
			}
		}
		
		for(int i = 0; i < elevator.registerList.size(); i++)
		{
			Customer c = elevator.registerList.get(i);
			
			if(c.getDestinationFloor() == f)
			{
				log("Customer " + c.getId() + " exits on floor: " + f);
				customerLeavesElevator(c);
				i--;			
			}
		}
	}
	
	/**
	 * adds a Customer to the Elevator's registeList
	 * @param c a Customer to be added to the registerList
	 */
	public void customerJoinsElevator(Customer c)
	{
		if(elevator.registerList.contains(c))
		{
			System.out.println("Error. It apears that the customer already is in the Elevator...");
			return;
		}
		else
		{
			elevator.registerList.add(c);
		}
	}
	
	/**
	 * The method to remove a Customer from the Elevator's registerList
	 * @param c a Customer to be removed from the registerList
	 */
	public void customerLeavesElevator(Customer c){
		if(elevator.registerList.contains(c)) 
		{
			elevator.registerList.remove(c);
		}
		else
		{
			System.out.println("Error. The customer is not anymore in the Elevator...");
		}
	}	
}
