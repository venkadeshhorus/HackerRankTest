package com.corejava.sorting;

public class StringCheckToLowerCase {
	public static void main(String[] args) {
		String str = "lower case string";
		System.out.println("Is String Lowercase...: "+isStringLowerCase(str));
		System.out.println("Given String in UPPER CASE...: "+str.toUpperCase());		
	} // main
	private static boolean isStringLowerCase(String str){
		char[] charArray = str.toCharArray();
		for(int i=0; i<charArray.length; i++){
				if(!Character.isLowerCase(charArray[i]))
					return false;
		} //for		
		return true;
	} // isStringLowerCase
		
	
} // Class
