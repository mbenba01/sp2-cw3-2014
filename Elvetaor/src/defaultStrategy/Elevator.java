package defaultStrategy;

import java.util.ArrayList;
import java.util.Random;

public class Elevator {
	
	 // instance variables 
	 private int numberOfFloors; // inherit from Building
	 private int currentFloor; // current position of the elevator
	 
	 private ArrayList<Customer> registerList; // Customers in the elevator
	 private byte direction; // -1 going down, 0 stops, 1 == going up
	 
	 private static Random rGen = new Random(); // random numbers generator object
	 
	/**
	 * Constructs instance of Elevator
	 * @param f represents the number of floors 
	 * */
	 public Elevator(int f) {
		 
		 numberOfFloors = f;
		 registerList = new ArrayList<Customer>();
		 
		 direction = getDirection();
		 
	 }
	 
	 public int getNumberOfFloors() {
		 return numberOfFloors;
	 }
	 
	 public int getCurrentFloor() {
		 return currentFloor;
	 }
	 
	 public byte getDirection() {
		 return direction;
	 }
	 
	 public int setDirection(int i) {
		 
		 if(currentFloor < i) {
			 direction = 1;
		 } else if(currentFloor > i) {
			 direction = -1;
		 } else {
			 direction = 0;
		 }
		 return direction;
		 
	 }
	 
	 /**
	  * moves the elevator by 1 floor
	  * @param i represents 
	  */
	 public void move(int i) {

		 switch (direction) {
		 	case 1 :
		 		if(i == numberOfFloors) {
		 			System.out.print("Reached the last floor!");
		 		} else {
		 			if(i == 12) {
		 				i+=2;
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i + 2));
		 			} else {
		 				
		 				i += 1;
		 			}
		 		}
		 	break;
		 	case -1 :
		 		if(i == 0) {
		 			System.out.print("Ground floor!");
		 		} else {
		 			if(i == 13) {
		 				i--;
		 			}
		 			System.out.println("Currently on floor " + i + "  going to floor " + (i - 1));
		 			i += 1;
		 		}
		 	break;
		 	case 0 :

		 			System.out.println("Error! I cannot move as lift has no direction set. \nPlease set direction first!");

		 	break;
		 	
		 }
	 }
	 /**
	 * moves the elevator to the top of the building
	 */
	 
	 public void defautlStrategy(int floors) {
		 for(int i = 0; i < floors; i++) {
		 
		 if(i == 13) {
			 continue;
		 }
		 
		 this.currentFloor = i;
		 move(currentFloor);
	 }
	 }

}
