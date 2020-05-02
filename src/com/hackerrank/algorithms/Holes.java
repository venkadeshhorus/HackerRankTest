package com.hackerrank.algorithms;

public class Holes {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long GB_n = 1000;	
		//approachOne(GB_n);
		approachTwo(GB_n);
	} // main
	
	static void approachTwo(long GB_n) {
		int holeCount = 0;
		int holes[] = {1,0,0,0,1,0,1,0,2,1};
		while(GB_n>0) {
			int GB_digit = (int)GB_n%10;
			holeCount = holeCount+holes[GB_digit];
			GB_n = GB_n/10;
		}
		System.out.println(holeCount);
	} // approachTwo
	
	static void approachOne(long GB_n) {
		String GB_String = Long.toString(GB_n);
		char[] stringToCharArray = GB_String.toCharArray();
		 int holesCount = 0;
		for (char digits : stringToCharArray) {
			//System.out.println(digits);
			long numericVal = Character.getNumericValue(digits);
			if(numericVal == 0 || numericVal == 4 || numericVal == 6||numericVal ==9){
				holesCount = holesCount+1;
			}else if(numericVal==8) {
					holesCount = holesCount+2;
			} else {
				holesCount = holesCount;
			}
		}
		System.out.println(holesCount);
	} // approachOne
} // Class
