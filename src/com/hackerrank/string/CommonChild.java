package com.hackerrank.string;

import java.io.IOException;
import java.util.Scanner;

public class CommonChild {
	// Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
    	int length1 = s1.length();
        int length2 = s2.length();
        int[][] commonLengths = new int[length1 + 1][length2 + 1];
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    commonLengths[i][j] = commonLengths[i - 1][j - 1] + 1;
                } else {
                    commonLengths[i][j] = Math.max(commonLengths[i - 1][j], commonLengths[i][j - 1]);
                }
            }
        }
        return commonLengths[length1][length2];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    } //main
} //Class

/*
A string is said to be a child of a another string if it can be formed by deleting 0 or more characters from the other string. Given two strings of equal length, what's the longest string that can be constructed such that it is a child of both?

For example, ABCD and ABDC have two children with maximum length 3, ABC and ABD. They can be formed by eliminating either the D or C from both strings. Note that we will not consider ABCD as a common child because we can't rearrange characters and ABCD  ABDC.

Function Description

Complete the commonChild function in the editor below. It should return the longest string which is a common child of the input strings.

commonChild has the following parameter(s):

s1, s2: two equal length strings
Input Format

There is one line with two space-separated strings,  and .

Constraints

All characters are upper case in the range ascii[A-Z].
Output Format

Print the length of the longest string , such that  is a child of both  and .

Sample Input

HARRY
SALLY
Sample Output

 2
Explanation

The longest string that can be formed by deleting zero or more characters from HARRY and SALLY is AY, whose length is 2.

Sample Input 1

AA
BB
Sample Output 1

0
Explanation 1

AA and BB have no characters in common and hence the output is 0.

Sample Input 2

SHINCHAN
NOHARAAA
Sample Output 2

3
Explanation 2

The longest string that can be formed between  and  while maintaining the order is .

Sample Input 3

ABCDEF
FBDAMN
Sample Output 3

2
Explanation 3 
BD is the longest child of the given strings.
 */
