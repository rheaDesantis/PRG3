/*
 * Name: Christine Johnson
 * Date: 5/31/19
 * Program Overview: Test cases for the functions in MakeChange such that it
 * returns the correct array list and throws an exception if there is an
 * empty coin list given as parameter
 * Notes: Used code from the Goodrich Data Structures and Algorithms book
 */
package prg3;

//import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

class Test1 {

	public int[] list = {1,5,10,25};  //array of US coins
	
	@Test
	void test1() {
		
		//array to check answer
		ArrayList<Integer> check = new ArrayList<>(Arrays.asList(25, 10, 5, 1, 1));
		
		MakeChange test = new MakeChange(list,42);
		ArrayList<Integer> output = test.makeChange();
		assertArrayEquals(check.toArray(), output.toArray(), "lists do not match");
	}
	
	@Test
	void test2() {
		
		//array to check answer
		ArrayList<Integer> check = new ArrayList<>(Arrays.asList(25,25,5,1,1,1,1));
		
		MakeChange test = new MakeChange(list,59);
		ArrayList<Integer> output = test.makeChange();
		assertArrayEquals(check.toArray(), output.toArray(), "lists do not match");
	}
	
	@Test
	void test3() {
		
		//array to check answer
		ArrayList<Integer> check = new ArrayList<>(Arrays.asList(25,5));
		
		MakeChange test = new MakeChange(list,30);
		ArrayList<Integer> output = test.makeChange();
		assertArrayEquals(check.toArray(), output.toArray(), "list do not match");
	}
	
	@Test
    // Test if exception is given for empty array input
	void test4() {
		int[] list = {};
		boolean expected = false;
		
		try{
			MakeChange test = new MakeChange(list,42);
			test.makeChange();
		}catch (IllegalArgumentException e) {
			expected = true;
		}
		assertTrue(expected);
	}

}
