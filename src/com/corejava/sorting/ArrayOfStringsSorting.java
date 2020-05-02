package com.corejava.sorting;

//import java.util.Scanner;

public class ArrayOfStringsSorting {
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		//int n = scanner.nextInt();
		String []strArray = {"ab","bcc","ade","cab","dee","bda","c","db","a","cbb"};
		
		char[] charArray1;
		char[] charArray2;
				
		for(int i=0; i<strArray.length; i++){
			for(int j=0; j<strArray.length-1; j++){
				charArray1 = strArray[j].toCharArray();
				charArray2 = strArray[j++].toCharArray();				
				stringComparison(charArray1, charArray2);
			}
		}
	} // main
	
	public static int stringComparison(char[] charArray1, char[] charArray2){
		int charArraysize1 = charArray1.length;
		int charArraysize2 = charArray2.length;
		int minLength = Math.min(charArraysize1, charArraysize2);
		for(int i=0, j=0; i<minLength; i++, j++){
			
		}
		return 0;
	}
		
	
} // Class
