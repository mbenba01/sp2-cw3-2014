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
		currentFloor = 0;
		
		direction = 1;
	}
	
	/**
	 * The method to move the elevator by 1 floor
	 */
	public void move(){
		if(direction==1){ // if direction is set to 1 lift will move one floor up
			if(currentFloor==numOfFloors){ // in case lift is already on the last floor
				System.out.println("Error. Cannot go up anymore as lift is on the last floor.");
			}else {
				currentFloor +=1;
				if(currentFloor == 13) {
					currentFloor++;
				}
				System.out.println("Currently on "+currentFloor+" floor "+" going to floor " +(currentFloor+1)+". Going up!");
			}
			
		}else if(direction==-1){ // if direction is set to -1 lift will move one floor down
			if(currentFloor==0){
				System.out.println("Error. Cannot go down anymore as lift is on the ground floor.");
			}else{
				currentFloor -=1;
				if(currentFloor == 13) {
					currentFloor--;
				}
				System.out.println("Currently on "+currentFloor+" floor "+" going to "+(currentFloor-1)+" floor. Going down!");
			}
		}else { // if direction is set to 0 or anything else lift will not move
			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");
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