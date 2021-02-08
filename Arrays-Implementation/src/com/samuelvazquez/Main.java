package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int [] myArray = new int [7];
		myArray[0] = 7;
		myArray[1] = 25;
		myArray[2] = 91;
		myArray[3] = 93;
		myArray[4] = -5;
		myArray[5] = -1;
		myArray[6] = 10;

		//Get me number seven from the array, but I don't know what the index is

		//worst case scenario, seven was in the last position in the array
		int index = 0;
		for(int i = 0; i < myArray.length; i++) {
			if(myArray[i]==91) {
				index = i;
				break;
			}
		}

		//Essentially, if we have to loop over the array in any way in order to perform an operation,
		//that's gonna have a linear time complexity
		//If we don't have to loop over the array, because we have an index and we can calculate the memory address
		//of the element we want to work on, that's constant time complexity
		System.out.println("index: " + index);


	}
}
