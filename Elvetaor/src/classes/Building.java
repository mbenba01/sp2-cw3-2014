package classes;

import java.util.ArrayList;


/**
 * The Building class stores the number of floors and and the number of customers
 * that will be used in the Elevator program.
 * The class constructor Building() takes two parameters, 
 * numberOfFloors and numberOfCustomers
 * @author Mustapha Benbaziz / Mariusz Lewandowski
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
	 * @param f represents the number of floors, to be added by the user
	 * @param c represents the number of customers, to be added by the user
	 */
	public Building(int f, int c) {
		
		if(f>12)f++;
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
		//this.output = ""; NOT NEEDED
	}
	
	/**
	 * Allows access to the numberOfFloors field outside class Building
	 * @return numberOfFloors of type int
	 */
	public int getNumberOfFloors() {
		return numberOfFloors;
	}
	
	/**
	 * Allows access to the numberOfFloors field outside class Building
	 * @return numberOfCustomers of type int
	 */
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	
	/**
	 * Adds value to the elevator field. Used to create a new elevator in class Building
	 */
	public void setElevator() {
		elevator = new Elevator(this.getNumberOfFloors());
	}
	
	/**
	 * Allows access to elevator field outside class Building
	 * @return elevator (object of type Elevator)
	 */
	public Elevator getElevator() {
		return elevator;	
	}

	/**
	 * Allows access to the customerList field outside class Building 
	 * @return customerList (ArrayList of objects of type Customer
	 */
	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	
	public void setCustomerList(ArrayList<Customer> al){
		this.customerList = al;
	}
	
	
	/**
	 * moves the elevator from the bottom to the top of the building.
	 * Stops at each floor and checks for customers willing to enter the lift and also checks if
	 * any of the customers wants to leave the elevator
	 */
	public void defaultStrategy() 
	{
		
		System.out.println("Default Strategy" + "\n===========================================");
		
		int totalStops = 0;	
		elevator.setDirection(1);
		
		for(int i = 0; i < elevator.getNumOfFloors(); i++) 
		{
			if(i == 13) 
			{
				continue;
			}
			this.checkFloor(i,false);
			totalStops++;
			elevator.move();
			displayMove("up");
		}
		System.out.println("-------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i > 0; i--) 
		{
			if(i == 13) 
			{
				continue;
			}
			elevator.move();
			displayMove("down");
			this.checkFloor(i,false);
			totalStops++;
		}
		System.out.println("===========================================");
		System.out.println("elevator register list size: " + elevator.registerList.size());
		System.out.println("building customer list size: " + this.customerList.size()+'\n');
		System.out.println("Total stops using default strategy: " + totalStops + "\n===========================================");
	}
	/**
	 * moves through the floors of the building but only stops where customers are present.
	 * This ensures the elevator only stops when there are customers present on floors.
	 */
	public void efficientStrategy(){
		System.out.println("testStrategy" + "\n===========================================");
		int totalStops = 0;	
		elevator.setDirection(1);  // elevator goes up only in case if lift is on the ground floor 
		elevator.setCurrentFloor(0); // setting elevator current floor hard in order to have correct comparison between methods
		
		for(int i = 0; i <= elevator.getNumOfFloors(); i++) {
			
			if(i == 13) {
				continue;
			}
			displayMove("up");
			if(this.checkFloor(i,true)){
				this.checkFloor(i, false);
				totalStops++;
			}
			elevator.move();
		}
		System.out.println("-------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--){
			
			if(i == 13) {
				continue;
			}
			displayMove("down");
			elevator.move();
			if(this.checkFloor(i, true)){
				this.checkFloor(i,false);
				totalStops++;
			}
		}
		System.out.println("===========================================");
		System.out.println("elevator register list size: " + elevator.registerList.size());
		System.out.println("building customer list size: " + this.customerList.size());
		System.out.println("Total stops using test strategy: " + totalStops + "\n===========================================");
	}
	/**
	 * moves through the floors of the building but only stops where customers are present.
	 * This ensures the elevator only stops when there are customers present on floors.
	 */
	public void oldEfficientStrategy() 
	{
		
		System.out.println("efficient Strategy" + "\n===========================================");
		int totalStops = 0;
		elevator.setDirection(1);  // elevator goes up only in case if lift is on the ground floor 
		elevator.setCurrentFloor(0); // setting elevator current floor hard in order to have correct comparison between methods

		for(int i = 0; i <= elevator.getNumOfFloors(); i++) 
		{
			
			displayMove("up");
			boolean stop = false;
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				if(e.getCurrentFloor() == i) {
					if(e.getCurrentFloor() != 0 && elevator.getCurrentFloor() != 0) {
						stop = true;
					}
					System.out.println("Number of customers on floor " + 
										elevator.getCurrentFloor() + ": " + 
										customerList.size());
				}
				if(stop)totalStops++;
				stop = false;
			}
			elevator.move();
			this.checkFloor(i,false);
		}
		System.out.println("-------------------------------------------");
		elevator.setDirection(-1);
		for(int i = elevator.getNumOfFloors(); i >= 0; i--) 
		{
			displayMove("down");
			boolean stop = false;
			for(int j = 0; j < customerList.size(); j++) {
				Customer e = customerList.get(j);
				if(e.getDestinationFloor() == elevator.getCurrentFloor()) {
					System.out.println("Customer " + e.getId() + " exits on floor: " + i);
					stop = true;
				}
				if(stop)totalStops++;
				stop = false;
			}
			elevator.move();
			this.checkFloor(i, false);
		}
		System.out.println("===========================================");
		System.out.println("elevator register list size: " + elevator.registerList.size());
		System.out.println("building customer list size: " + this.customerList.size());
		System.out.println("Total stops using efficient strategy: " + totalStops + "\n===========================================");
	}
	
	/**
	 * checks if there is someone waiting for the elevator on the floor "f".
	 * also checks if there is someone in the elevator with destination equal "f".
	 * @param f a current floor where check is performed
	 * @param test if set to true the function will only test if there is someone on the floor f going in/out of lift.
	 * @return true if there will be exchange of Customers Between elevator and Building
	 */
	public boolean checkFloor(int f, boolean test)
	{
		boolean anyone = false;
		for(int i = 0; i < this.customerList.size(); i++)
		{
			Customer c = this.customerList.get(i);
			
			if(c.getCurrentFloor() == f)
			{
				anyone=true;
				if(test){
					continue;
				}
				System.out.println("Customer " + c.getId() + " enters on floor: " + f);
				elevator.customerJoinsElevator(c);
				this.customerList.remove(c);
				i--;
				
			}
		}
		
		for(int i = 0; i < elevator.registerList.size(); i++)
		{
			Customer c = elevator.registerList.get(i);
			
			if(c.getDestinationFloor() == f)
			{
				anyone=true;
				if(test){
					continue;
				}
				System.out.println("Customer " + c.getId() + " exits on floor: " + f);
				elevator.customerLeavesElevator(c);
				i--;
			}
		}
		return anyone;
	}
	
	/**
	 * Displays the movement of the elevator
	 * @param s represents whether the elevator is moving up or down
	 */
	public void displayMove(String s) {
		
		switch (s) {
		
		case "down":
			if(elevator.getCurrentFloor() <=  elevator.getNumOfFloors()) {
				System.out.println("Going down to floor: " + (elevator.getCurrentFloor()));
			}
			break;
			
		case "up" :
			if(elevator.getCurrentFloor() != 0 && elevator.getCurrentFloor() <= elevator.getNumOfFloors()) {
				System.out.println("Going up to floor: " + (elevator.getCurrentFloor()));
			}
			break;
			
		default:
			System.out.println("Staionary");
		}
		
	}

}
