package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int [] array = {20,35,-15,7,55,1,-22};

		mergeSort(array, 0 , array.length);

		for(int x: array) {
			System.out.print(x + " ");
		}
	}

	//recursive method
	public static void mergeSort(int [] input, int start, int end) {
		//breaking condition
		//when this method is called with a one element array, there's nothing to be done
		//by definition, a one element array is sorted
		if(end-start < 2) {
			return;
		}
		//for arrays that have two or more elements
		//defining partitions (start and end indices are for the left and right array)
		//end index is always one greater than the last valid index in the array
		int mid = (start + end) / 2;
		//now we want to do a merge sort on the left partition
		//for this implementation, we throw any extra elements into the right partition
		//[20,35,-15] [7,55,1,-22]
		//end index is always one greater than the last valid index in the array
		//handling the left partition
		mergeSort(input, start,mid);
		//handling the right part of the array
		mergeSort(input, mid, end);
		//elements in the first three positions and the elements in the last four positions are in sorted order
		//now is time to merge the left and right partitions.
		merge(input,start,mid,end);

	}

	public static void merge(int[] input, int start, int mid, int end) {
		//modification in order to invert the merge condition now from right to left
		if(input[mid - 1] >= input[mid]) {
			return;
		}

		int i = start;
		int j = mid;

		int tempIndex = 0;

		int[] temp = new int[end - start];

		while(i < mid && j < end) {

			//for this case (descending order) the values for temp array should be greater on the left side instead of the right side
			temp[tempIndex++] = input[i] >= input[j] ? input[i++] : input[j++];
		}

		System.arraycopy(input,i,input,start + tempIndex,mid - i);
		System.arraycopy(temp,0,input,start,tempIndex);
	}
}
