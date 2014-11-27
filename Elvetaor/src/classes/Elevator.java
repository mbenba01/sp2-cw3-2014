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
	
	public void move1() {
		int i = currentFloor;

		 switch (direction) {
		 	case 1 :
		 		if(i == numOfFloors) {
		 			System.out.println("Reached the last floor!");
		 		} else {
		 			if(i == 12) {
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i + 2));
		 				i += 2;
		 			} else {
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i + 1));
		 				i += 1;
		 			}
		 		}
		 	break;
		 	case -1 :
		 		if(i == 0) {
		 			System.out.println("Reached the ground floor!");
		 		} else {
		 			if(i == 14) {
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i - 2));
		 				i -= 2;
		 			} else {
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i - 1));
		 				i -= 1;
		 			}
		 		}
		 	break;
		 	default :

		 			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");
		 	break;
		 }
	 }
	/**
	 * The method to move the elevator by 1 floor
	 * @param i represents the floors in the building
	 */
	public void move(){
		if(direction==1){ // if direction is set to 1 lift will move one floor up
			if(currentFloor==numOfFloors){ // in case lift is already on the last floor
				System.out.println("Error. Cannot go up anymore as lift is on the last floor.");
			}else {
				if(currentFloor==12){
					System.out.println("Currently on "+currentFloor+" floor "+" going to "+(currentFloor+2)+" floor. Going up!");
					currentFloor+=2;
				}else{
					System.out.println("Currently on "+currentFloor+" floor "+" going to "+(currentFloor+1)+" floor. Going up!");
					currentFloor +=1;
				}
			}
		}else if(direction==-1){ // if direction is set to -1 lift will move one floor down
			if(currentFloor==0){
				System.out.println("Error. Cannot go down anymore as lift is on the ground floor.");
			}else{
				if(currentFloor==14){
					System.out.println("Currently on "+currentFloor+" floor "+" going to "+(currentFloor-2)+" floor. Going down!");
					currentFloor-=2;
				}else{
					System.out.println("Currently on "+currentFloor+" floor "+" going to "+(currentFloor-1)+" floor. Going down!");
					currentFloor -=1;
				}
			}
		}else { // if direction is set to 0 or anything else lift will not move
			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");
		}
	}
	
	/**
	 * moves the elevator to the top of the building
	 */
	public void defautlStrategy() {
		for(int i = 0; i < getNumOfFloors(); i++) {
			if(i == 13) {
				continue;
			}			 
			//this.currentFloor = i; // we need current floor to be set by function move not somewhere else ;-)
				this.move();
		}
		System.out.println("---------------------------------------------");
		direction = -1;
		for(int i = getNumOfFloors(); i > 0; i--) {
			if(i == 13) {
				continue;
			}
			 
			//this.currentFloor = i; // we need current floor to be set by function move not somewhere else ;-)
			this.move();	
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