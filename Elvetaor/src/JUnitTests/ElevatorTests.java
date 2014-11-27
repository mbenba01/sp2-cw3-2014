package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import classes.Elevator;

public class ElevatorTests {
	
	static Elevator e;
	static int floors;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		floors = 15;
		e = new Elevator(floors);
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("getFloors: " + e.getNumOfFloors());
		System.out.println("getCurrentFloor: " + e.getCurrentFloor());
	}

}
