package com.hackerrank.Tutorials;

import java.util.HashMap;
import java.util.Scanner;

public class HashTablesIceCreamParlor {
	
	static void solve(int[] arr, int money) {
        // Complete this function
        if (arr == null || arr.length < 1) {
            //System.out.println(-1 + " " + -1);
            return;
        }
        // core logic
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < money) {
                if (hashMap.containsKey(money - arr[i])) {
                	//System.out.println(money-arr[i]);
                    int index = hashMap.get(money - arr[i]);
                    //System.out.println(index+"index");
                    //we add 1 to index becoz is 0 based index to make 1 based index we add 1
                    System.out.println((index + 1) + " " + (i + 1));
                    return;
                }
                if (!hashMap.containsKey(arr[i])) {
                	//System.out.println("not conatains");
                    hashMap.put(arr[i], i);
                }
            }
        } // for -loop
    } // solve
	
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int[] cost = new int[n];
            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }
            solve(cost, money);
        } // for - loop

        scanner.close();
    } // main
} // Class

/*
Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool their money to buy ice cream. On any given day, the parlor offers a line of flavors. Each flavor has a cost associated with it.

Given the value of  and the  of each flavor for  trips to the Ice Cream Parlor, help Sunny and Johnny choose two distinct flavors such that they spend their entire pool of money during each visit. ID numbers are the 1- based index number associated with a . For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

For example, there are  flavors having . Together they have  to spend. They would purchase flavor ID's  and  for a cost of . Use  based indexing for your response.

Note:

Two ice creams having unique IDs  and  may have the same cost (i.e., ).
There will always be a unique solution.
Function Description

Complete the function whatFlavors in the editor below. It must determine the two flavors they will purchase and print them as two space-separated integers on a line.

whatFlavors has the following parameter(s):

cost: an array of integers representing price for a flavor
money: an integer representing the amount of money they have to spend
Input Format

The first line contains an integer, , the number of trips to the ice cream parlor.

Each of the next  sets of  lines is as follows:

The first line contains .
The second line contains an integer, , the size of the array .
The third line contains  space-separated integers denoting the .
*/