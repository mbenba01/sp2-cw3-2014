package backups;

import java.util.ArrayList;

import classes.Customer;

public class Elevator {
	
	private int numOfFloors;
	public ArrayList<Customer> registerList;
	private int currentFloor;
	private int direction;  // -1==going down; 0==stops; 1==going up
	
	public Elevator(int f) {
		
		numOfFloors = f;
		registerList = new ArrayList<Customer>();
		currentFloor = 0;
		direction = 0;
	}
	
	public int getNumOfFloors() {
		return numOfFloors;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * The method to move the elevator by 1 floor
	 * @param i represents the floors in the building
	 */
	public void move(){
		if(direction==1)
		{ // if direction is set to 1 lift will move one floor up
			if(currentFloor==numOfFloors)
			{ // in case lift is already on the last floor
				System.out.println("You have reached the last floor!");
			}
			else 
			{
				if(currentFloor==12)
				{
					System.out.println("going up to floor: " + (currentFloor+2));
					currentFloor+=2;
				}
				else
				{
					System.out.println("going up to floor: " + (currentFloor+1));
					currentFloor +=1;
				}
			}
		}
		else if(direction==-1)
		{ // if direction is set to -1 lift will move one floor down
			if(currentFloor==0)
			{
				System.out.println("You have reached the ground floor!");
			}
			else
			{
				if(currentFloor==14)
				{
					System.out.println("going down to floor: " + (currentFloor-2));
					currentFloor-=2;
				}
				else
				{
					System.out.println("going down to floor: " + (currentFloor-1));
					currentFloor -=1;
				}
			}
		}
		else 
		{ // if direction is set to 0 or anything else lift will not move
			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");
		}
	}
	
	/**
	 * moves the elevator to the top of the building
	 */
	public void defautlStrategy() {
		this.direction = 1;
		for(int i = 0; i < getNumOfFloors(); i++) 
		{
			if(i == 13) 
			{
				continue;
			}			 

				this.move();
		}
		System.out.println("---------------------------------------------");
		direction = -1;
		for(int i = getNumOfFloors(); i > 0; i--) 
		{
			if(i == 13) 
			{
				continue;
			}
			 
			this.move();	
		}
	}
	
	/**
	 * The method to add a Customer to the Elevator's registeList
	 * @param c a Customer to be added to the registerList
	 */
	public void customerJoinsElevator(Customer c){
		if(registerList.contains(c))
		{
			System.out.println("Error. It apears that the customer already is in the Elevator...");
			return;
		}
		else
		{
			registerList.add(c);
		}
	}
	/**
	 * The method to remove a Customer from the Elevator's registerList
	 * @param c a Customer to be removed from the registerList
	 */
	public void customerLeavesElevator(Customer c){
		if(registerList.contains(c)) 
		{
			registerList.remove(c);
		}else
		{
			System.out.println("Error. The customer is not anymore in the Elevator...");
		}
	}
	public int getDirection(){
		return direction;
	}
	public void setDirection(int i){
		direction = i;
	}
}