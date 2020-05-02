package com.corejava.readright;

import java.util.Date;

public class OutPutDateAndTimeFormattings {

	public static void main(String[] args) {
		// Full name of the day of week
		//System.out.println(String.format("%tA"));
		System.out.println(String.format("%20d", 93));
		System.out.println(String.format("|%20d|", 93));
		System.out.println(String.format("|%-20d|", 93));
		
		System.out.printf("%-20s%d%n", "Raja",150000);
		
		String output = String.format("%s = %d", "Raja", 150000);
		System.out.println(output);
		System.out.printf("My name is: %s%n","Raja");
				
		/*
		Date d = new Date();
		//Full name of the day of week
		System.out.printf("%tA%n",d);
		//Abbreviation name of the day of week
		System.out.printf("%ta%n",d);
		//Full name of the Month
		System.out.printf("%tB%n",d);
		//Abbreviation name of the day of week
		System.out.printf("%tb%n",d);
		//Date formatted as %tm%td%ty
		System.out.printf("%tD",d);
		System.out.printf("%tm%n",d);
		System.out.printf("%td%n",d);
		System.out.printf("%ty%n",d);
		*/
	}

}
