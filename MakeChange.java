package prg3;

import java.util.ArrayList;

public class MakeChange {
	
	private static int[] coins;
	private static int amount;
	
	MakeChange(int[] arr, int input){
		this.coins = arr;
		this.amount = input;
	}
	
	public ArrayList<Integer> makeChange(){
		//Return an array list of coins that add up to amount
		ArrayList<Integer> totalCoins = new ArrayList<Integer>();
		int index = coins.length - 2;
		
		if(coins.length == 0) {
			throw new IllegalArgumentException("Can't send in empty array");
		}
		
		while (amount > 0) {
			if(amount >= coins[coins.length - 1]) {
				amount -= coins[coins.length - 1];
				totalCoins.add(coins[coins.length - 1]);
			}
			else {
				while(amount >= coins[index]) {
					amount -= coins[index];
					totalCoins.add(coins[index]);
				}
				index-=1;
			}
		}

		System.out.println(totalCoins);
		
		return totalCoins;	
	}
	
	/*public ArrayList<Integer> makeChange(int[] arr, int input){
		//Return an array list of coins that add up to amount
		ArrayList<Integer> totalCoins = new ArrayList<Integer>();
		
		int index = arr.length - 2;
		
		if(arr.length == 0) {
			throw new IllegalArgumentException("Can't send in empty array");
		}
		
		while (amount > 0) {
			if(amount >= arr[arr.length - 1]) {
				amount -= arr[arr.length - 1];
				totalCoins.add(arr[arr.length - 1]);
			}
			else {
				while(amount >= arr[index]) {
					amount -= arr[index];
					totalCoins.add(arr[index]);
				}
				index-=1;
			}
		}

		System.out.println(totalCoins);
		
		return totalCoins;
		
	}*/

}