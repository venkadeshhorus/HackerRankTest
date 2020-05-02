package com.hackerrank.algorithms.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class DiagonalDifference {
	public static int diagonalDifference(int[][] arr) {
    	int d1=0, d2=0;
    	int n = arr.length;
    	for (int i = 0; i < n; i++) 
        { 
            for (int j = 0; j < n; j++) 
            { 
                // finding sum of primary diagonal 
                if (i == j) 
                    d1 += arr[i][j]; 
      
                // finding sum of secondary diagonal 
                if (i == n - j - 1) 
                    d2 += arr[i][j]; 
            } 
        } //for
    	return Math.abs(d1-d2);
    } //diagonalDifference
	
	public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] arrRowItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            for (int j = 0; j < n; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        } //for
        
        int result = diagonalDifference(arr);
        System.out.println(result);
        bufferedReader.close();
    }
} //DiagonalDifference Class
