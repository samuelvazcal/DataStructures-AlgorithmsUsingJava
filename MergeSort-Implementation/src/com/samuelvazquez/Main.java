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
		//mid is the first element in the right side and it's one greater than the last element
		//in the left side, so input[mid -1] -> is the last element in the left partition & input[mid] is
		//the first element in the right partition
		//if the next condition is true, that means all the elements in the left partition are less than or equal
		//than the smallest element in the right partition because both of these arrays are sorted
		//and so, none of the positions of the elements are going to change
		//if they weren't sorted, we couldn't do this check
		if(input[mid - 1] <= input[mid]) {
			return;
		}
		//if not, that means that we have some elements in the left array that are greater, than some of the
		//elements in the right array, so there is merging to do.
		int i = start;
		int j = mid;
		//tempIndex is going to keep track of where we are	in the temporary array, when we're doing the copy
		int tempIndex = 0;
		//temporary array, large enough to old the number of elements in the left and right partitions
		int[] temp = new int[end - start];
		//stepping through the left and right arrays, and compare whatever is at index i in the left array, with
		//whatever is at index j in the right array, and we are going to write the smaller of the two into
		//the current position in temp
		while(i < mid && j < end) {
			//when i == mid, we'll have finished traversing the left array, so as soon as we've finished traversing the left array
			//we want to drop out or, same for j == end

			//compare the current element (i) in the left partition with the current element (j) in the right partition
			//and the smaller of the two we are going to write it to the temporary array
			temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
		}
		//When we've completely traversed the one of the arrays, the other array (or partition or sub array) will
		//have some elements left over that we have not copied into temp
		//handling the remaining elements in the array that we have in traverse

		//if we have elements remaining in the left partition, we have to copy them into the temp array,
		//but if we have elements remaining in the right partition we don't have to do anything.

		//{32,34} {33,36}
		//{32,33,34}
		//remember, we're always copying the smallest of the elements, if we have elements left over
		//in the right, we know that they're greater that everything else, that's why they haven't been copied yet

		//but if we have elements left over in the left array, then those elements are greater than everything and
		//obviously we need to write those, because their positions are going to change
		//{32,36},{33,34}
		//{32,33,34} 36 is left over
		 //it's going to go from coming second, to coming fourth
		//so when we copy back to the original array, the input array, the position of 36 will have to change

		/*
		input - source array
		i - start to copy, this is the first index of the first element that we still haven't handled
		input - destination array
		start+tempIndex = destination index to start copy
		 */
		System.arraycopy(input,i,input,start + tempIndex,mid - i);
		System.arraycopy(temp,0,input,start,tempIndex);
	}
}
