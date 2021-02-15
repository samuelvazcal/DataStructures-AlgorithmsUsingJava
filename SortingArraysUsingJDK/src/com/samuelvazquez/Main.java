package com.samuelvazquez;

import java.util.Arrays;


public class Main {
	public static void main(String[] args) {
		int [] intArray = {20,35,-15,7,55,2,-22};

		Arrays.parallelSort(intArray);
		Arrays.sort(intArray);

		for(int x: intArray) {
			System.out.print(x + " ");
		}
	}
}
