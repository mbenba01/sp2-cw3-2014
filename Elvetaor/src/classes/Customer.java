package classes;

import java.util.Random; //generate

public class Customer {
	
	private int id;
	private int currentFloor;
	private int destinationFloor;
	private boolean inElevator;
	
	/**
	 * Constructs instances of Customer
	 * @param id of type int. Represents the unique identifier for each customer
	 * @param f of type int. Represents the number of floors in the building. Used to ensure the random number is not bigger
	 * than the number of floors
	 */
	public Customer(int id, int f) {

		this.id = id;
		Random ran = new Random();
		
		int i = ran.nextInt(f); // Set the range for the random number between 0 and number of floors + 1 (used to replace 13). 
		int j = ran.nextInt(f); // Set the range for the random number between 0 and number of floors + 1 (used to replace 13).
		
		this.currentFloor = removeThirteen(i); // remove thirteen from possible random numbers 
		this.destinationFloor = removeThirteen(j); // remove thirteen from possible random numbers
		differenciate(this.currentFloor, this.destinationFloor, f); // ensure that destinationFloor is different from currentFloor
	
	}
	
	/**
	 * Allows access to the id field outside the scope of class Customer
	 * @return id of type int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Allows access to the currenFloor field outside the scope of class Customer
	 * @return currentFloor of type int
	 */
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * sets value to currentFloor
	 * @param i used to store the current floor of the customer.
	 */
	public void setCurrentFloor(int i){
		this.currentFloor = i;
	}
	
	/**
	 * Allows access to destinationFloor field outside the scope of class Customer
	 * @return destinationFloor of type int
	 */
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	/**
	 * sets value to DestinationFloor
	 * @param i used to store the current floor of the customer.
	 */
	public void setDestinationFloor(int i){
		this.destinationFloor = i;
	}
	
	/** 
	 * ensures the elevator does not stop on thirteenth floor
	 * @param i represents the current floor of customer
	 * @return the current floor of the customer
	 */
	public int removeThirteen(int i) {
		int temp;
		if(i == 13) {
			temp = i + 1 ;
		} else {
			temp = i;
		}
		return temp;
	}
	
	/**
	 * Ensures destinationFloor is different from currentFloor
	 * @param i represents currentFloor
	 * @param j represents destinationFloor
	 * @param f represents numberOfFloors
	 * @return destinationFloor
	 */
	public void differenciate(int i, int j, int f) {
		if(i==j){
			destinationFloor = (i+j+2)%f;
		}
	}
	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentFloor;
		result = prime * result + destinationFloor;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (this == other && other != null) { return true; }
		if (getClass() != other.getClass()) { return false; }
		Customer obj = (Customer) other;
		if (currentFloor != obj.currentFloor || 
			destinationFloor != obj.destinationFloor|| id != obj.id) { return false; }
		return true;
	}

	@Override
	public String toString() {
		return "\nCustomer id: " + id + "\tCurrent floor: " + currentFloor + 
				"\tDestination floor: " + destinationFloor;
	}
	
}
