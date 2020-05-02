package com.hackerrank.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class Abbreviation {
	// Complete the abbreviation function below.
    static String abbreviation(String a, String b) {
    	if (a.length() < b.length()) {
    	      return "NO";
    	} //if

    	boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];

    	for (int i = 0; i <= a.length(); i++) {
   	      for (int j = 0; j <= b.length(); j++) {
    	        if (j > i) {
    	          dp[i][j] = false;
    	        } else if (i == 0 && j == 0) {
    	          dp[i][j] = true;
    	        } else if (j == 0) {
    	          dp[i][j] = !Character.isUpperCase(a.charAt(i - 1)) && dp[i - 1][j];
    	        } else if (Character.isUpperCase(a.charAt(i - 1))) {
    	          boolean tmp = a.charAt(i - 1) == b.charAt(j - 1) && dp[i - 1][j - 1];
    	          dp[i][j] = tmp;
    	        } else {
    	          boolean tmp = (Character.toUpperCase(a.charAt(i - 1)) == b.charAt(j - 1)) &&                          dp[i - 1][j - 1];
    	          boolean tmp2 = (tmp || dp[i - 1][j]);
    	          dp[i][j] = tmp2;
    	        }
    	      } //for j
    	    } //for i
    	    return dp[a.length()][b.length()] ? "YES" : "NO";
    } //abbreviation method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();
            String b = scanner.nextLine();
            String result = abbreviation(a, b);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
            System.out.println(result);
        }
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class
/*
You can perform the following operations on the string, :

Capitalize zero or more of 's lowercase letters.
Delete all of the remaining lowercase letters in .
Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.

For example, given  and , in  we can convert  and delete  to match . If  and , matching is not possible because letters may only be capitalized or discarded, not changed.

Function Description

Complete the function  in the editor below. It must return either  or .

abbreviation has the following parameter(s):

a: the string to modify
b: the string to match
Input Format

The first line contains a single integer , the number of queries.

Each of the next  pairs of lines is as follows: 
- The first line of each query contains a single string, . 
- The second line of each query contains a single string, .

Constraints

String  consists only of uppercase and lowercase English letters, ascii[A-Za-z].
String  consists only of uppercase English letters, ascii[A-Z].
Output Format

For each query, print YES on a new line if it's possible to make string  equal to string . Otherwise, print NO.

Sample Input

1
daBcd
ABC
Sample Output

YES
Explanation

image

We have  daBcd and  ABC. We perform the following operation:

Capitalize the letters a and c in  so that  dABCd.
Delete all the remaining lowercase letters in  so that  ABC.
Because we were able to successfully convert  to , we print YES on a new line.
*/