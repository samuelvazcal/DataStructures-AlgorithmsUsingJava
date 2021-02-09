package com.samuelvazquez;

/*
Bubble sort
Time complexity is O of N squared, it's quadratic
What we're trying to do is get some sense of how the number of steps grows
as the number of items we have to sort grows
 */
public class Main {
	public static void main(String[] args) {
		int[] intArray = {20,35,-15,7,55,1,-22};
		//for each iteration of the outer loop, we want to traverse the array
		//and we want to bubble the largest value that's unsorted into the sorted position
		//OUTER LOOP
		for(int lastUnsortedIndex = intArray.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			//We want to bubble the largest value to the end of the array in the inner loop
			//INNER LOOP with a little bit of optimization
			for(int i = 0; i < lastUnsortedIndex; i++) {
				if(intArray[i] > intArray[i+1]) {
					swap(intArray,i,i+1);
				}
			}
		}
		for(int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i]+" ");
		}
	}
	/*
	Swap method
	 */
	public static void swap(int[] array, int i, int j) {
		//there is no element to swap
		if(i==j) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
