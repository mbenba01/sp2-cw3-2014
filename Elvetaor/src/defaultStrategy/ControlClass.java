package defaultStrategy;

import java.util.ArrayList;
import java.util.Scanner;


public class ControlClass {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	private static Building theHyde;
	private static Elevator lift;
	private static Customer user;


	
	public static void main(String[] args) {
		
		/*//Initialise new object 'in'
		in = new Scanner(System.in);
		int numberOfFloors;
		//prompt user for a number of floors to use as a parameter for the Building object
		System.out.print("Please enter the number of floors: ");
		numberOfFloors = in.nextInt();
		 
		//prompt user for and store number of customers to use as a parameter for the Building object
		System.out.print("Please enter the number of customers: ");
		int numberOfCustomers = in.nextInt();
		
		//Close Scanner object 'in' after use.
		in.close();*/
		
		//Create new instance of Building
		theHyde = new Building(15, 7);
		lift = new Elevator(15);
		//defaultStrategy = new DefaultStrategy(lift.getNumberOfFloors(), lift.getCurrentFloor());
		
		//Code below outputs the number of floors in the building, the number of customers and the list of customers. 
		
		System.out.println("===============================================================");
		System.out.println("Floors: " + theHyde.getNumberOfFloors());
		System.out.println("Customers: " + theHyde.getNumberOfCustomers());
		System.out.println("===============================================================");
		System.out.println("Customer list: " + theHyde.getCustomerList());
		System.out.println("===============================================================");
		int lcf = lift.getCurrentFloor(); //lift current floor
		for(int i = 0; i <= theHyde.getNumberOfFloors(); i++) {
			
			user = theHyde.getCustomerList().get(i);
			theHyde.efficientStrategy(user, lift.getCurrentFloor());
			break;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*int lCfU  = 0;
		while(lCfU <= lift.getNumberOfFloors()) {
			for(Customer user : theHyde.getCustomerList()) {
				if(lCfU == user.getCurrentFloor()) {
					System.out.println("User/s on this floor: " + user);
					lift.customerJoins(user);
				}
			}
			if(lCfU == 12) {
				lCfU += 2; 
			} else { 
				lCfU++;
			}			
		}
		
		System.out.println("===============================================================");
		int lCfD  = lift.getNumberOfFloors();
		while(lCfD >= 0) {
			for(Customer user : theHyde.getCustomerList()) {
				if(lCfD == user.getDestinationFloor()) {
					System.out.println("User/s on this floor: " + user);
					lift.customerLeaves(user);
				}
			}
			if(lCfD == 14) {
				lCfD -= 2; 
			} else {
				lCfD--;
			}			
		}*/
		System.out.println("======================================================");
		
		System.out.println("building customer list size: " + theHyde.getCustomerList().size());
		
	}

}
