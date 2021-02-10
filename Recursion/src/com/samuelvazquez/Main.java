package com.samuelvazquez;

public class Main {
	public static void main(String[] args) {
		System.out.println(iterativeFactorial(7));
		System.out.println(recursiveFactorial(7));
	}

	//iterative implementation
	public static int iterativeFactorial(int num) {
		//breaking condition or base case
		if(num==0) {
			return 1;
		}
		int factorial = 1;
		for(int i = 1; i <= num; i++) {
			factorial *= i;
		}
		return factorial;
	}

	//recursive implementation
	//1! = 1 * 0! = 1
	//2! = 2 * 1 = 2 * 1!
	//3! = 3 * 2 * 1 = 3 * 2!
	//4! = 4 * 3 * 2 * 1 = 4 * 3!
	//We multiply the number by minus one factorial
	//n! = n * (n-1)!

	//we're calling the same method, we're calling the method itself
	//the call to a recursive method may result in many more calls before it returns
	//and data in pause is collect temporarily in call stack memory
	//none of the recursive calls return until they receive the result from the method
	//that they invoked recursively
	public static int recursiveFactorial(int num) {
		if(num == 0) {
			return 1;
		}
		return num * recursiveFactorial(num-1);
	}
}
