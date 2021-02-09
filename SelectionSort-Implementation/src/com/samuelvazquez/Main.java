package com.samuelvazquez;

/*
Selection sort is a quadratic algorithm, O(n^2)
usually a loop is considered an n, and so, we have n times n
 */
public class Main {
	public static void main(String[] args) {
		int [] array = {20,35,-15,7,55,1,-22};

		//OUTER LOOP is the one that's increasing the sorted partition by one, it's growing
		//it from right to left
		for(int lastUnsortedIndex = array.length -1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 0;
			//INNER LOOP is the one that's looking for the largest element, and then when we know which one is the largest,
			//we're gonna swap the largest element with the last element in the unsorted partition
			for(int i = 1; i <= lastUnsortedIndex; i++) {
				if(array[i] > array[largest]) {
					largest = i;
				}
			}
			swap(array,largest,lastUnsortedIndex);
		}
		for(int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	public static void swap(int [] array, int i, int j) {
		if(i==j) {
			return;
		}
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}


