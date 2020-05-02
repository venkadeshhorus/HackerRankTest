package com.hackerrank.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HourGlassTest {
	
	public static void main(String[] args) {
		/*int[][] array1 = {{1,1,1,0,0,0,},
						 {2,1,2,0,0,0},
						 {1,1,1,0,0,0},
						 {0,0,0,0,0,0},
						 {0,0,0,0,0,0},
						 {0,0,0,0,0,0}};*/
		
		int[][] array = {{1,1,1,0,0,0},
						 {0,1,0,0,0,0},
						 {1,1,1,0,0,0},
						 {0,0,2,4,4,0},
						 {0,0,0,2,0,0},
						 {0,0,1,2,4,0}};
		
		//System.out.println(array.length);
				
		List<Integer> sumOfAllHourGlasses = new ArrayList<Integer>();
		for(int a=0; a<array.length-2; a++){
			for(int b=0; b<array.length-2; b++){
				//Internal loop starts
				int sum = 0;				
				for(int i=a; i<=(a+2); i++){
					for(int j=b; j<=(b+2); j++){
						//System.out.print("array["+i+"]["+j+"]");
						System.out.print(array[i][j]+"\t");						
						if((i==a+1&&j==b) || (i==a+1&&j==b+2)){
							//Ignore
						}else{
							sum = sum+array[i][j];
						}// if
					}
					System.out.println();
				} // for
				System.out.println(sum);
				sumOfAllHourGlasses.add(sum);
				//System.out.println();
				//Internal loop Ends
			} // for b
		}// for a
				
		System.out.println(sumOfAllHourGlasses);
		System.out.println(Collections.max(sumOfAllHourGlasses));
		
		
					
	}
	
	private static  int houraddition(int[][] arr, int a, int b )
	{
		int hourglasssize = 3;
		int[][] matrix = {{1,1,1,0,0,0},
				 {0,1,0,0,0,0},
				 {1,1,1,0,0,0},
				 {0,0,2,4,4,0},
				 {0,0,0,2,0,0},
				 {0,0,1,2,4,0}};

		int[][] matrix1 = {{1,2,3},
		 		 {4,5,6},
		 		 {7,8,9}}	;
		int sum = 0;
		for(int i=0; i<=matrix.length - hourglasssize;i++)
			for(int j=0; j<=matrix.length-hourglasssize;j++)
				sum+=houraddition(matrix,i,j);
		System.out.println("Sum --->"+ sum);
		
		if(arr.length!=3)
		{
			//error
		}
		
		for(int i=a;i<hourglasssize+a;i++){
			for(int j=b; j<hourglasssize+b; j++){
				//System.out.print(arr[i][j]+"\t");
			   if(i==a+1 && (j==b || j==b+2) )
			   {
				   //ignore
			   }
			   else
			   {
				sum=sum+arr[i][j]	;
			   }
			}
			System.out.println();
		}
		//System.out.println("Sum --->"+ sum);
		return sum;
	} //main
} //Class


/*
Given a 6 X 6 2D Array, arr:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We define an hourglass in  to be a subset of values with indices falling in this pattern in 's graphical representation:

a b c
  d
e f g
There are  hourglasses in , and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in , then print the maximum hourglass sum.

For example, given the 2D array:

-9 -9 -9  1 1 1 
 0 -9  0  4 3 2
-9 -9 -9  1 2 3
 0  0  8  6 6 0
 0  0  0 -2 0 0
 0  0  1  2 4 0
We calculate the following  hourglass values:

-63, -34, -9, 12, 
-10, 0, 28, 23, 
-27, -11, -2, 10, 
9, 17, 25, 18
Our highest hourglass value is  from the hourglass:

0 4 3
  1
8 6 6
Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

Function Description

Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.

hourglassSum has the following parameter(s):

arr: an array of integers
Input Format

Each of the  lines of inputs  contains  space-separated integers .

Constraints

Output Format

Print the largest (maximum) hourglass sum found in .

Sample Input

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
Sample Output

19
Explanation

 contains the following hourglasses:

image

The hourglass with the maximum sum () is:

2 4 4
  2
1 2 4
*/
