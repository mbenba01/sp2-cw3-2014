package classes;

import java.util.Random; //generate

public class Customer {
	
	private int id;
	private int currentFloor;
	private int destinationFloor;
	private boolean inElevator;
	
	public Customer(int id, int f) {

		this.id = id;
		Random ran = new Random();
		
		int i = ran.nextInt(f+1);
		int j = ran.nextInt(f+1);
		
		this.currentFloor = removeThirteen(i); // remove thirteen from possible random numbers 
		this.destinationFloor = removeThirteen(j); // remove thirteen from possible random numbers
		differenciate(i, j, f); // ensure that destinationFloor is different from currentFloor
	
	}
	
	public int getId() {
		return id;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	public void setCurrentFloor(int i){
		this.currentFloor = i;
	}
	
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	public void setDestinationFloor(int i){
		this.destinationFloor = i;
	}
	
	/** ensures the elevator does not stop on thirteenth floor
	 * 
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
			System.out.println(this.id + " current and destination were the same !!");
			destinationFloor = (i+j+3)%f;
		}
	}
	
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
