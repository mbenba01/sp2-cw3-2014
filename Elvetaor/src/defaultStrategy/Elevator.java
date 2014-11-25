package defaultStrategy;

import java.util.ArrayList;
import java.util.Random;

import classes.Customer;

public class Elevator extends Building {
	
	 // instance variables 
	 private int numberOfFloors; // inherit from Building
	 private int currentFloor; // current position of the elevator
	 
	 private ArrayList<Customer> registerList; // Customers in the elevator
	 private byte direction; // -1 going down, 0 stops, 1 == going up
	 
	 private static Random rGen = new Random(); // random numbers generator object
	 
	 // calls the constructor of the Building class
	 public Elevator() {
		 super();
	 }
	 
	 /**
	 * Constructs instance of Elevator
	 * @param f represents the number of floors 
	 * */
	 public Elevator(int f) {
		 
		 numberOfFloors = f;
		 setRegisterList(new ArrayList<Customer>());
		 
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
	 public ArrayList<Customer> getRegisterList() {
		return registerList;
	 }
	 public void setRegisterList(ArrayList<Customer> registerList) {
		this.registerList = registerList;
	 }	
	 
	 /** 
	  * 
	  * @param i
	  * @return
	  */
	 public byte setDirection(int i) {
		 
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
