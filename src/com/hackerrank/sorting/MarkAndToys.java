package com.hackerrank.sorting;

import java.io.*;
import java.util.*;


public class MarkAndToys {
	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {   	
    	int noOfItemsBought = 0;
    	int budget = k;
    	Arrays.sort(prices);
    	
    	for(int i=0; i<prices.length; i++){
    		if(budget>prices[i]){
    			noOfItemsBought++;
    			budget-=prices[i];
    		}
    	}// for
    	    	
		return noOfItemsBought;
    }
	static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        } // for
        
        //***************************************************************************
        // Checking the Range Condition
        boolean rangeCheck = false;
        if(n>=1 && n<=Math.pow(10,5) && k>=1 && k<=Math.pow(10,9)){
        	for(int i=0; i<prices.length; i++){
        		if(prices[i]>=1 && prices[i]<=Math.pow(10,9)){
        			rangeCheck = true;
        		}
        		else{
        			rangeCheck = false;
        			break;
        		}
        	}// for    	
        } else{
        	rangeCheck = false;
        } // if        
        if(rangeCheck){
        	int result = maximumToys(prices, k);
        	System.out.println(result);
        }else{
        	System.out.println("Entered values are not in the Range...");
        }// if        
        //***************************************************************************
        
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class

/*
Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.

Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if  and Mark has  to spend, he can buy items  for , or  for  units of currency. He would choose the first group of  items.

Function Description

Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.

maximumToys has the following parameter(s):

prices: an array of integers representing toy prices
k: an integer, Mark's budget
Input Format

The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend. 
The next line contains  space-separated integers 

Constraints

 
 
 
A toy can't be bought multiple times.

Output Format

An integer that denotes the maximum number of toys Mark can buy for his son.

Sample Input

7 50
1 12 5 111 200 1000 10
Sample Output

4
Explanation

He can buy only  toys at most. These toys have the following prices: .
*/