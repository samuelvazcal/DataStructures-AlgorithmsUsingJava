package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int[] array = {2,5,9,8,2,8,7,10,4,3};
		countingSort(array,1,10);
		for(int x : array) {
			System.out.print(x + " ");
		}
	}

	public static void countingSort(int [] input, int min, int max) {
		int [] countArray = new int[(max - min) + 1];

		//traverse the array and we're goona count how many of each value we have
		for(int i = 0; i < input.length; i++) {
			//where each value is counted, that's going to be the index of where to count each value
			//if we got a 10, 10 minus one is nine and we'd increment element nine in the countArray
			countArray[input[i]-min]++;
		}
		//j is the index we're going to use to write to the input array
		//i is the index that we're going to use to traverse the countArray
		int j = 0;
		for(int i = min; i <= max; i++) {
			while(countArray[i-min]>0 ) {
				input[j++] = i;
				countArray[i-min]--;
			}
		}
	}
}
