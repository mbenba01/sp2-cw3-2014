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
		 
		 setDirection(-1);
		 
	 }
	 /**
	  * makes number of floors accessible to other classes
	  * @return number of floors registered in the elevator
	  */
	 public int getNumberOfFloors() {
		 return numberOfFloors;
	 }
	 /**
	  * makes position of the elevator accessible to use by other classes
	  * @return current floor that represents the position of the floor
	  */
	 public int getCurrentFloor() {
		 return currentFloor;
	 }
	 
	 public byte getDirection() {
		 return direction;
	 }
	 
	 /** 
	  * 
	  * @param i
	  * @return
	  */
	 public int setDirection(int i) {
		 
		 if(this.currentFloor < i) {
			 direction = 1;
		 } else if(this.currentFloor > i) {
			 direction = -1;
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
		 			System.out.print("Ground floor!");
		 		} else {
		 			if(i == 14) {
		 				System.out.println("Currently on floor " + i + "  going to floor " + (i - 2));
		 				i -= 2;
		 			}
		 			System.out.println("Currently on floor " + i + "  going to floor " + (i - 1));
	 				i -= 1;
		 			
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
	 public void moveUp(int floors) {
		for(int i = 0; i <= floors; i++) {
			 
			if(i == 13) {
				continue;
			}
			 
			this.currentFloor = i;
				move(currentFloor);
			}
	}
	public void moveDown(int floors) {
		for(int i = floors; i >= 0; i--) {
				 
			if(i == 13) {
				continue;
			}
			 
			this.currentFloor = i;
				move(currentFloor);
			}
	}
		 
}
