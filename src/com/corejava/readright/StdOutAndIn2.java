package com.corejava.readright;

import java.util.Scanner;

public class StdOutAndIn2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//int i = scanner.nextInt();
		//Double d = scanner.nextDouble();
		//String s = scanner.next();
		int i = Integer.parseInt(scanner.nextLine());
		Double d= Double.parseDouble(scanner.nextLine());
		String s = scanner.nextLine();
		
		System.out.println("String: "+s);
		System.out.println("Double: "+d);
		System.out.println("Int: "+i);
		scanner.close();

	}

	/*
	 * Difference between nextLine() and next()
	 * next() can read the input till next space. It can't read two words separated by space
	 * nextLine() reads input including space between the words
	 * (It reads till the end of line)
	 * 
	 */
}
