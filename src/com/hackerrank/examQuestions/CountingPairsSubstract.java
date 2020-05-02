package com.hackerrank.examQuestions;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountingPairsSubstract {
	// Complete the pairs function below.
	static int pairs(int gb_target, int[] arr) {
	    Set<Integer> gb_inputSet = new HashSet<Integer>();
	    int pairCount = 0;
       for(int gb_n=0; gb_n< arr.length; gb_n++){           
           gb_inputSet.add(arr[gb_n]);
        }       
        for(int n=0; n< arr.length; n++){
            if(gb_inputSet.contains(arr[n]-gb_target)){
                pairCount++;
            }
        }
        return pairCount;
    } // pairs

//	private static int pairs(int[] ls, int k) {
//		int pairs = 0;
//		Arrays.sort(ls);
//		int i = 0;
//		int j = 1;
//		while (j < ls.length) {
//			if (ls[j] - ls[i] == k) {
//				++i;
//				++j;
//				++pairs;
//			} else if (ls[j] - ls[i] > k) {
//				++i;
//			} else {
//				++j;
//			}
//		}
//		return pairs;
//	}// pairs
	
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }
        int result = pairs(k, arr);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    } // main
} // Class



//You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.
//
//For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: , , and .
//
//Function Description
//
//Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.
//
//pairs has the following parameter(s):
//
//k: an integer, the target difference
//arr: an array of integers
//Input Format
//
//The first line contains two space-separated integers  and , the size of  and the target value. 
//The second line contains  space-separated integers of the array .
