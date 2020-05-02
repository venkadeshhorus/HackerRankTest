package com.corejava.readright;

import java.util.Scanner;

public class OutPutFormatting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1 = sc.next();
            int x = sc.nextInt();
            
            System.out.printf("%-15s%03d%n",s1,x);            
        }
        sc.close();
        System.out.println("================================");
	}

	/*
	 * s[0][1] s[0][2]
	 * s[2][1] s[2][2]
	 * s[3][1] s[3][2]
	 */
}


