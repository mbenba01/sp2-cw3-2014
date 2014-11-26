package defaultStrategy;

import java.util.ArrayList;
import java.util.Scanner;


public class ControlClass {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	private static Building theHyde;
	private static Elevator lift;
	private static Customer user;
	private static DefaultStrategy defaultStrategy;

	
	public static void main(String[] args) {
		
		//Initialise new object 'in'
		in = new Scanner(System.in);
		int numberOfFloors;
		//prompt user for a number of floors to use as a parameter for the Building object
		System.out.print("Please enter the number of floors: ");
		numberOfFloors = in.nextInt();
		 
		//prompt user for and store number of customers to use as a parameter for the Building object
		System.out.print("Please enter the number of customers: ");
		int numberOfCustomers = in.nextInt();
		
		//Close Scanner object 'in' after use.
		in.close();
		
		//Create new instance of Building
		theHyde = new Building(numberOfFloors, numberOfCustomers);
		lift = new Elevator(numberOfFloors);
		defaultStrategy = new DefaultStrategy(lift.getNumberOfFloors(), lift.getCurrentFloor());
		
		//Code belowoutputs the number of floors in the building, the number of customers and the list of customers. 
		
		System.out.println("===============================================================");
		System.out.println("Floors: " + theHyde.getNumberOfFloors());
		System.out.println("Customers: " + theHyde.getNumberOfCustomers());
		System.out.println("===============================================================");
		System.out.println("Customer list: " + theHyde.getCustomerList());
		System.out.println("===============================================================");

		
		defaultStrategy.setDirection(1);
		//user.callElevator(lift.getCurrentFloor());
		
		int lCfU  = 0; // lift.getCurrentFloor();
		while(lCfU <= lift.getNumberOfFloors()) {
			if(lCfU != lift.getNumberOfFloors()) {
				System.out.println("Currently on floor " + lCfU + " going up..");
			}
			for(Customer user : theHyde.getCustomerList()) {
				if(lCfU == user.getCurrentFloor()) {
					System.out.println("User: " + user);
				}
			}
			
			if(lCfU == 12) {
				lCfU += 2; 
			} else {
				lCfU++;
			}
			
		}
		defaultStrategy.moveUp(lift.getNumberOfFloors());	
		System.out.println("===============================================================");
		defaultStrategy.setDirection(-1);
		int lCfD  = lift.getNumberOfFloors();
		while(lCfD >= 0) {
			
			
			for(Customer user : theHyde.getCustomerList()) {
				if(lCfD == user.getDestinationFloor()) {
					System.out.println("User/s on this floor: " + user);
				}
			}
			if(lCfD != 0) {
				System.out.println("\nCurrently on floor " + lCfD + " going down..");	
			}
			if(lCfD == 14) {
				lCfD -= 2; 
			} else {
				lCfD--;
			}
			
		}
		defaultStrategy.moveDown(lift.getNumberOfFloors());
		
	}

}
