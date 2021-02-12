package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		int [] radixArray = {4725,4586,1330,8792,1594,5729};

		radixSingleSort(radixArray,10,4);

		for(int i = 0;  i < radixArray.length; i++) {
			System.out.println(radixArray[i]);
		}
	}

	public static void radixSort(int [] input, int radix, int width) {
		for(int i = 0; i <width; i++) {
			//calling method for each position in our values
			radixSingleSort(input, i, radix);
		}
	}

	public static void radixSingleSort(int [] input, int position, int radix) {
		//how many items that we're gonna sorting
		int numItems = input.length;
		//large enough to hold all the possible values
		int[] countArray = new int[radix];
		//it will return a digit, zero to nine
		for(int value: input) {
			countArray[getDigit(position, value, radix)]++;
		}
		//adjust the count array
		for(int j = 1; j < radix; j++) {
			countArray[j] += countArray[j-1];
		}
		int[] temp = new int[numItems];
		for(int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
			temp[--countArray[getDigit(position,input[tempIndex],radix)]] = input[tempIndex];
		}
		for(int tempIndex = 0;tempIndex < numItems; tempIndex++) {
			input[tempIndex] = temp[tempIndex];
		}

	}

	public static int getDigit(int position, int value, int radix) {
		return value/(int) Math.pow(radix, position) % radix;
	}
}
