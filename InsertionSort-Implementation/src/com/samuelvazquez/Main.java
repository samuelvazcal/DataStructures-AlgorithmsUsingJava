package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		//int [] array = {20,35,-15,7,55,1,-22};
		int [] array = {3,5,2,7,4};
		//This implementation starts out by assuming that the element a position zero
		//is in the sorted partition, and so the first unsorted index will start at one.

		//the first unsorted index is going to be increasing by one after every iteration
		for(int firstUnsortedIndex = 1;firstUnsortedIndex < array.length; firstUnsortedIndex++) {
			//save the value of the element we're going to insert into newElement,
			//when we do the shifting, that position, the element is going to be overwritten
			int newElement = array[firstUnsortedIndex];
			int i;
			//loop that does the traversal of the sorted partition and looks for the correct position
			//to insert newElement
			//we want to keep looking for the insertion position as long as we haven't
			//hit the front of the array, if we hit the front of the array, it means that the element
			//we're trying to insert is the smallest element we've seen so far and the correct insertion position
			//is zero
			for(i = firstUnsortedIndex;i > 0 && array[i - 1] > newElement; i--) {
				//shifting from left to right
				array[i] = array[i-1];
			}
			//when we find the correct position, we assigned to our working index
			array[i] = newElement;
		}
		for(int x: array) {
			System.out.print(x + " ");
		}
	}
}
