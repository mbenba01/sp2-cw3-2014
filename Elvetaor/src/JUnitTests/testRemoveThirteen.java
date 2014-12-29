package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import classes.Customer;


public class testRemoveThirteen {

	@Test
	public void test() {
		int i = 13;
		int expected = 12;
		Customer c = new Customer(1, 5);
		int actual = c.removeThirteen(i);
		
		assertEquals("Wrong answer!", expected, actual);
		
		
		
	}

}
