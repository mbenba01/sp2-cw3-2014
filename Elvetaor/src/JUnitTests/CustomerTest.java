package JUnitTests;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import classes.Customer;

public class CustomerTest {

	
	@Test
	public void testDifferenciate() {
		Random ran = new Random();
		int f = 15;
		int i = ran.nextInt(f);
		int j = ran.nextInt(f);
		int expectedOutput = i+j+3%15;
		
		Customer user = new Customer(3, 15);
		user.diffderenciate(i, j, f);
		int currentOutput = user.getDestinationFloor();
		
		assertEquals("Wrong answer!", expectedOutput, currentOutput);
		
		
	}

}
