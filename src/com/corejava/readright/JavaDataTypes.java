package com.corejava.readright;

import java.util.Scanner;

public class JavaDataTypes {
	private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>=-2.147483648E9 && x<=2.147483647E9)System.out.println("* int");
                if(x>=-9.223372036854776E18 && x<=9.223372036854776E18)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            } // try - catch
        } // for
        sc.close();
	} // main

} // Class
