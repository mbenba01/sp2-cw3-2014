package defaultStrategy;

import java.util.Random; // Random class, used to generate random numbers

public class Customer {
	
	//instance variables
	private int id;
	private int currentFloor; // Randomly assigned
	private int destinationFloor; // Randomly assigned
	
	private boolean inElevator; // Flag to denote if customer is in elevator
	private boolean finished; // Flag to denote if customer is in elevator
	
	private static Random rGen = new Random(); // new random number generator

	
	/**
	 * Constructs instances of Customer
	 * @param id represents the identifier of Customer objects
	 * @param f represents the number of floors
	 */
	public Customer(int id, int f) {
		this.id = id;
		int i = rGen.nextInt(f); // range 0 - number of floors
		int j = rGen.nextInt(f); // range 0 - number of floors
		
		this.currentFloor = removeThirteen(i + 1); // remove thirteen from possible random numbers 
		this.destinationFloor = removeThirteen(j + 1); // remove thirteen from possible random numbers
	}
	
	public int getId() {
		return id;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	public int getDestinationFloor() {
		return destinationFloor;
	}
	
	public boolean getInElevator() {
		return true;
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
	 * allows the customer in the building to call the lift
	 * @param currentFloor represents the position of the elevator
	 */
	/*public void callElevator(int currentFloor) {
		
		if(this.currentFloor != currentFloor) 
		{
			if(this.currentFloor > currentFloor) 
			{
				for(int i = currentFloor; i <= this.currentFloor; i++) {
					if(i == 13) {
						continue;
					}
				currentFloor = i;
				}
			}
		}
	}*/
	
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
