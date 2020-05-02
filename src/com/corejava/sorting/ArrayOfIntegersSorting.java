package com.corejava.sorting;

public class ArrayOfIntegersSorting {
	public static void main(String[] args) {
		int intArray[] = {45, 12, 2, 86, 32, 5, 8, 7, 96, 6};
		
		for(int i=0; i<intArray.length; i++){
			for(int j=0; j<intArray.length-1; j++){
				if(intArray[j] > intArray[j+1]){
					int temp = intArray[j];
					intArray[j] = intArray[j+1];
					intArray[j+1] = temp;					
				}
			}
		}
		
		for(int i=0; i<intArray.length; i++){
			System.out.print(intArray[i]+"\t");
		}
	}
}
