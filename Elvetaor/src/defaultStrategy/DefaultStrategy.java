package defaultStrategy;

public class DefaultStrategy extends Elevator {
	
	private int currentFloor;
	private Customer user = new Customer();
	
	/**
	 * Constructs an instance of the DefaultStrategy
	 * @param floor represents the number of floors
	 * @param currentFloor represents the current floor of the elevator
	 */
	public DefaultStrategy(int floor, int currentFloor) {
		super(floor);
		this.currentFloor = currentFloor; // stores the position of the elevator
		//direction = setDirection(0); // stores the direction of the elevator
	}
	
	public int getCurrentFloor() {
		return currentFloor;
	}
	
	 /**
	  * moves the elevator to the top of the building
	  * @param floors represents the number of floors
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
