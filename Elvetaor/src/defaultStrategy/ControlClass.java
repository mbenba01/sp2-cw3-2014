package defaultStrategy;

import java.util.Scanner;


public class ControlClass {
	
	// Declare new object 'in' of type Scanner
	public static Scanner in;
	
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
		Building theHyde = new Building(15, 7);
		Elevator lift = new Elevator(15);
		Customer user = new Customer(3, 15);
		DefaultStrategy lift1 = new DefaultStrategy(lift.getNumberOfFloors(), lift.getCurrentFloor());
		
		System.out.println("===============================================================");
		System.out.println("Floors: " + theHyde.getNumberOfFloors());
		System.out.println("Customers: " + theHyde.getNumberOfCustomers());
		System.out.println("===============================================================");
		System.out.println("Customer list: " + theHyde.getCustomerList());
		System.out.println("===============================================================");

		
		lift1.setDirection(1);
		user.callElevator(lift.getCurrentFloor());
		lift1.moveUp(lift.getNumberOfFloors());
		System.out.println("===============================================================");
		lift1.setDirection(-1);
		lift1.moveDown(lift.getNumberOfFloors());

	}

}
