package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		//int [] array = {20,35,-15,7,55,1,-22};
		int [] array = {3,5,2,7,4};
		//first loop is going to initialise the gap value that we are using and the
		//reduce it on each iteration

		//if the gap is zero, that means that we're gonna be comparing elements against themselves
		//so we need a gap of one (final iteration always has to have a gap of one, to be insertion sort)
		for(int gap = array.length/2;gap > 0; gap /=2  ) {
			//comparing and shifting via insertion sort
			for(int i = gap; i < array.length;i++) {
				//array[i] is the value that we're going to be looking at
				int newElement = array[i];
				//i for traversing
				int j = i;
				//we hit the front of the array if j becomes less than the gap,
				while(j >= gap && array[j-gap] > newElement) {
					//we shift the element at array[j-gap] up gap positions
					array[j] = array[j-gap];
					j -= gap;
				}
				array[j] = newElement;
			}
		}
		for(int x: array) {
			System.out.print(x + " ");
		}
	}
}
