package classes;

import java.util.ArrayList;

public class Elevator {
	
	private int numOfFloors;
	private ArrayList<Customer> registerList;
	private int currentFloor;
	private byte direction;  // -1==going down; 0==stops; 1==going up
	
	public Elevator(int f) {
		
		numOfFloors = f;
		registerList = new ArrayList<Customer>();
		//currentFloor = 0;
		
		direction = 1;
	}
	
	public int getNumOfFloors() {
		return numOfFloors;
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	/**
	 * The method to move the elevator by 1 floor
	 */
	public void move(int i){
		if(direction==1){ // if direction is set to 1 lift will move one floor up
			if(i==numOfFloors){ // in case lift is already on the last floor
				System.out.println("Error. Cannot go up anymore as lift is on the last floor.");
			}else {
				
				if(i == 13) {
					i++;
				}
				System.out.println("Currently on "+ i +" floor "+" going to floor " +(i + 1)+". Going up!");
				i += 1;
			}
			
		}else if(direction==-1){ // if direction is set to -1 lift will move one floor down
			if(i==0){
				System.out.println("Error. Cannot go down anymore as lift is on the ground floor.");
			}else{
				
				System.out.println("Currently on "+ i +" floor "+" going to "+(i - 1)+" floor. Going down!");
				if(i == 13) {
					i--;
				}
				
				i -= 1;
			}
		}else { // if direction is set to 0 or anything else lift will not move
			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");
		}
	}
	
	public void defautlStrategy() {
		
		for(int i = 0; i < getNumOfFloors() - 1; i++) {
			this.currentFloor = i;
			move(currentFloor);
			
		}
	}
	
	/**
	 * The method to add a Customer to the Elevator's registeList
	 * @param c a Customer to be added to the registerList
	 */
	public void customerJoins(Customer c){
		if(registerList.contains(c)){
			System.out.println("Error. It apears that the customer already is in the Elevator...");
			return;
		}else{
			registerList.add(c);
		}
	}
	/**
	 * The method to remove a Customer from the Elevator's registerList
	 * @param c a Customer to be removed from the registerList
	 */
	public void customerLeaves(Customer c){
		if(registerList.contains(c)) {
			registerList.remove(c);
		}else{
			System.out.println("Error. The customer is not anymore in the Elevator...");
		}
	}
}