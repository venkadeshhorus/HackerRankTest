package com.corejava.readright;

import java.util.Scanner;

public class NumberMultiplicationLoop {
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {		
		System.out.println(Math.pow(2, 63)-1);
		/*
		int N = scanner.nextInt();		
		if(N>=2 && N<=20){
			for(int i=1;i<=10;i++){
				System.out.printf("%d x %d = %d %n",N,i,(N*i));
			} // for
		} // 2<= N <= 20
		*/
		scanner.close();
	}

}
