package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int [] array = {20,35,-15,7,55,1,-22};

		quickSort(array,0,array.length);

		for(int x: array) {
			System.out.print(x + " ");
		}
	}

	public static void quickSort(int [] input, int start , int end) {
		//we are dealing with a one element array
		if(end - start < 2) {
			return;
		}
		//more than one element
		//where the pivot will belong in the sorted array
		//position at the pivot and at that position everything to the left of the pivot
		//will be smaller then the pivot and everything to the right will be larger
		int pivotIndex = partition(input, start, end);
		//after that, we want to do the same thing with the left array and the right array
		quickSort(input, start, pivotIndex);
		quickSort(input, pivotIndex + 1, end);
	}

	public static int partition(int [] input, int start, int end) {
		//This is using the first element as the pivot
		int pivot = input[start];
		int i = start;
		int j = end;
		//now the traversal, i is going to traverse from left to right,
		//and j is going to be traversing from right to left
		//and we want to stop when i and j cross each other
		while(i < j) {
			//looking for elements that are less than the pivot
			//empty loop body, we are using it to keep decrementing j until we either find an element that's less
			//that the pivot or j crosses i
			//right
			while(i < j && input [--j] >= pivot);
			//we are going to make sure we didn't fall out of it because J crossed i
			if(i < j) {
				input[i] = input[j];
			}
			//looking for elements that are greater than the pivot, and we wanna move them to the right of the pivot
			//for prefix decrement and prefix increment, when we execute their statements, we'll decrement j and then we'll use
			//the result as the index and recall that end will always be one les/greater than the last index of the array
			//left
			while(i < j && input[++i] <= pivot);
			if(i < j) {
				input[j] = input[i];
			}
		}
		//the value of j will be the index where we want to insert the pivot
		input[j] = pivot;
		return j;
	}
}
