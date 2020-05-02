package com.corejava.readright;

import java.util.Scanner;

public class StdOutAndIn {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		final int a, b, c;
		a = scanner.nextInt();
		b = scanner.nextInt();
		c = scanner.nextInt();
		scanner.close();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}
