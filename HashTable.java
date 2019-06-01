/*
 * Name: Christine Johnson
 * Date: 5/28/19
 * Program Overview: Create a hash table and give the user options to: delete a value,
 * insert a value or find a value. If load factor > 0.8, table is rehashed.
 * Notes: Used code from the Goodrich Data Structures and Algorithms book
 */

package prg3;

import java.util.Arrays;
import java.util.Scanner;

public class HashTable {
	
	public static Integer[] kvarray;
	private static int value;
	private static int key;
	private static int numValue; //keeps track of number of values in hash table
	
	HashTable(Integer[] kvarray, int key, int value, int numValue){
		
		this.kvarray = kvarray;
		this.key = key;
		this.value = value;
		this.numValue = numValue;
	}
	
	public int getKey() {
			return key;
	}
	
	
	public int getValue() {
		return value;
	}
	
	public static void main(String[] args) {
		
		int userInput = 25;
		int numValue = 0;   //keep track of how many items are in hash table
		float loadfactor;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Type your desired Hash Table size here: ");
		kvarray = new Integer[sc.nextInt()];   //Allow user to create Hash Table of any given size
		System.out.println();
		//Set all values in Hash Table to null 
		for (int i =0; i < kvarray.length-1; i++) {
			kvarray[i] = null;
		}
			
		while (userInput != 0) {
			System.out.println("Option Menu");
			System.out.println("---------------------");
			System.out.println("1) Insert a value");
			System.out.println("2) Delete a value");
			System.out.println("3) Find a value");
			System.out.println("0) Exit the program");
			System.out.println();
			System.out.println("Please choose an option: ");
			userInput = sc.nextInt();
			if (userInput == 1) {
				numValue += 1;
				loadfactor =(float)numValue/kvarray.length;
				if(loadfactor >= 0.8) {
					kvarray = doubleArr(kvarray, kvarray.length);
					System.out.println();
					System.out.println("Table was resized because load factor was greater than 0.\n");
				}
				System.out.println("Enter value to insert: ");
				value = sc.nextInt();
				insert(kvarray, -1, key, value);
			}
			else if(userInput == 2) {
				System.out.println("Enter value to delete: ");
				value = sc.nextInt();
				delete(kvarray, value);
				System.out.println("The value " + value + " was deleted");
				numValue -= 1;
			}
			else if(userInput == 3) {
				System.out.println("Enter value to find: ");
				value = sc.nextInt();
				int key = find(kvarray, value);
				System.out.println("The value " + value + " is located at the key " + key);
			}
			else if(userInput == 0) {
				System.out.println("Program will now end.");
			}
			else {
				System.out.println("That was not a valid option");
			}
			System.out.println();
			printTable(kvarray);
			System.out.println();
		}
		
		sc.close();
	}

	public static Integer[] doubleArr(Integer[] arr, int size) {
		//method to double the size of array when load factor is 0.8
		//When array resized, contents are rehashed into the new array
		Integer[] array = new Integer[size*2];
		
		for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] != null) {
				insert(array,-1, key, arr[i]);
			}
		}
		return array;
	}
	
	public static void insert(Integer[] arr, int probe, int key, int value) {
		//use quadratic probing to insert
		if(probe == -1) {                 //-1 means it is the first time being sent through
			key = value % arr.length;
			probe = 0;
		}
		if(arr[(key+probe*probe)%arr.length] == null) {
			arr[(key+probe*probe)%arr.length] = value;
		}
		else {
			probe+=1;
			insert(arr, probe, key%arr.length, value);
		}	
	}
	
	public static void delete(Integer[] arr, int value) {
		int key = find(arr, value);
		if(key >=0) {         //if key is positive, the value was found
			arr[key] = null;
		}
		else {               //if key is negative, value not found
			System.out.println("The value " + value + " could not be deleted because it was not in the Hashtable");
		}
	}
	
	public static int find(Integer[] arr, int value) {
		int check = -1;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == value) {
				check = i;   //value was found in the array, return key=found
				System.out.println("The value " + value + " was found");
				System.out.println(check);
			}	
		}
		if(check < 0) {
				System.out.println("The value " + value + " was not found");
				//the value was not found in the array, c returns negative
			}
		System.out.println(check);
		return check;
	}
	
	public static void printTable(Integer[] arr) {
		System.out.println(" Key | Value");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(i + "   |   " + arr[i]);
		}
		
	}
	
}


