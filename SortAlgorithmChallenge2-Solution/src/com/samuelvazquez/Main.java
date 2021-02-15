package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int [] intArray = {20,35,-15,7,55,1,-22};

		insertionSort(intArray,intArray.length);
//		for(int firstUnsortedArray = 1; firstUnsortedArray < intArray.length; firstUnsortedArray++) {
//			int newElement = intArray[firstUnsortedArray];
//			int i;
//			for(i = firstUnsortedArray; i > 0 && intArray[i-1]> newElement;i--) {
//				intArray[i] = intArray[i-1];
//			}
//			intArray[i]=newElement;
//		}
		for(int x : intArray) {
			System.out.print(x + " ");
		}
	}

	//instead of using a loop to grow the sorted partition, we're using recursion to grow the sorted partition
	//iterative solution - each iteration of the loop grows the sorted partition by one
	//insertionSort - each call to the method grows the sorted partition by one
	public static void insertionSort(int [] input, int numItems) {
		//one element is sorted, breaking condition
		if(numItems < 2) {
			return;
		}
		//the recursive call that called insertionSort with one item will be able to continue executing till line 28
		insertionSort(input,numItems-1);
		int newElement = input[numItems-1];
		int i;
		for(i = numItems-1; i > 0 && input[i-1]> newElement;i--) {
			input[i] = input[i-1];
		}
		input[i]=newElement;
	}
}
