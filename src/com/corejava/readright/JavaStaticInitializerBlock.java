package com.corejava.readright;

import java.util.Scanner;

public class JavaStaticInitializerBlock {
	
	static int B;
	static int H;
	static boolean flag = false;
	private static final Scanner scanner = new Scanner(System.in);
	static{
		B = scanner.nextInt();
		H = scanner.nextInt();
		if(B>=-100 && B<=100 && H>=-100 && H<=100){
			if(B>0 && H>0){
				flag = true;
			} else{
				System.out.println("java.lang.Exception: Breadth and height must be positive");
			}
		}
	}
	public static void main(String[] args) {			
			if(flag){
				int area=B*H;
				System.out.print(area);
			}
			
		} // B and H Range Check from -100 to 100
	}


