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
	
	/**
	 * Constructs instances of Building
	 * @param f represents the number of floors, to be decided by the user
	 * @param c represents the number of customers, to
	 */
	public Building(int f, int c) {
		
		this.numberOfFloors = f; // Number of floors in the building
		numberOfCustomers = c;   // Number of customers in the building
		
		ArrayList<Customer> myList = new ArrayList<>(); // Create ArrayList of type Customer
		
		for(int j = 1; j <= c; j++) 
		{
			Customer d = new Customer(j, numberOfFloors);
			myList.add(d);	
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
	 * moves the elevator from the bottom to the top of the building.
	 * Stops at each floor and checks for customers willing to enter the lift and also checks if
	 * any of the customers wants to leave the elevator
	 */
	public void defaultStrategy() 
	{
		int totalStops = 0;
		elevator.setDirection(1);
		for(int i = 0; i <= elevator.getNumOfFloors(); i++) 
		{
			if(i == 13) 
			{
				continue;
			}
			if(elevator.getCurrentFloor() != 0) {
			System.out.println("Going up to floor: " + (elevator.getCurrentFloor()));
			}
			this.checkFloor(i);
			elevator.move();
			
			totalStops++;
		}
		System.out.println("---------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--) 
		{
			if(i == 13) 
			{
				continue;
			}
			if(elevator.getCurrentFloor() !=  elevator.getNumOfFloors()){
			System.out.println("Going down to floor: " + (elevator.getCurrentFloor()));
			}
			this.checkFloor(i);
			elevator.move();
			
			totalStops++;
		}
		System.out.println("======================================================");
		System.out.println("elevator register list size: " + elevator.registerList.size());
		System.out.println("building customer list size: " + this.customerList.size());
		System.out.println("Number of stops: " + (totalStops));
	}
	/*
	 * moves through the floors of the building but only stops where customers are present.
	 * This ensures the elevator only stops when there are customers present on floors.
	 */
	public void efficientStrategy() 
	{
		int totalStops = 0;
		elevator.setDirection(1);
		for(int i = 0; i <= elevator.getNumOfFloors(); i++) 
		{

			this.checkFloor(i);
			elevator.move();
			
			if(elevator.getCurrentFloor() != 0) {
				//System.out.println("Going up to floor: " + (elevator.getCurrentFloor()));
			}
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				//System.out.print(e);
				if(e.getCurrentFloor() == elevator.getCurrentFloor() || e.getDestinationFloor() == elevator.getCurrentFloor()) {
					totalStops++;
				}
				
			}
			//break;
		}
		System.out.println("---------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--) 
		{

			
			this.checkFloor(i);
			elevator.move();
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				//System.out.print(e);
				if(e.getDestinationFloor() == elevator.getCurrentFloor()) {
					totalStops++;
				}
				
			}
			if(elevator.getCurrentFloor() !=  elevator.getNumOfFloors()){
				//System.out.println("Going down to floor: " + (elevator.getCurrentFloor()));
				}
		}
		System.out.println("======================================================");
		System.out.println("elevator register list size: " + elevator.registerList.size());
		System.out.println("building customer list size: " + this.customerList.size());
		System.out.println("Number of stops: " + (totalStops));
	}
	
	public void checkFloor(int f)
	{
		for(int i = 0; i < this.customerList.size(); i++)
		{
			Customer c = this.customerList.get(i);
			
			if(c.getCurrentFloor() == f)
			{
				System.out.println("Customer " + c.getId() + " enters on floor: "+ f);
				customerJoinsElevator(c);
				this.customerList.remove(c);
				i--;
			}
		}
		
		for(int i = 0; i < elevator.registerList.size(); i++)
		{
			Customer c = elevator.registerList.get(i);
			
			if(c.getDestinationFloor() == f)
			{
				System.out.println("Customer " + c.getId() + " exits on floor: " + f);
				customerLeavesElevator(c);
				i--;			
			}
		}
	}
	
	/**
	 * The method to add a Customer to the Elevator's registeList
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
