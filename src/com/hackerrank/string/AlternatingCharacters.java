package com.hackerrank.string;

import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {
	// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	char[] charArray = s.toCharArray();
    	int alternateCharacters = 0;
    	for(int i=0; i<charArray.length-1; i++){
    		if(charArray[i]==charArray[i+1]){
    			alternateCharacters++;
    		}
    	}// for
    	return alternateCharacters;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            //bufferedWriter.write(String.valueOf(result));            
            //bufferedWriter.newLine();            
            System.out.print(result);
            System.out.println();
        }
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class


/*
You are given a string containing characters  and  only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

Your task is to find the minimum number of required deletions.

For example, given the string , remove an  at positions  and  to make  in  deletions.

Function Description

Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

alternatingCharacters has the following parameter(s):

s: a string
Input Format

The first line contains an integer , the number of queries. 
The next  lines each contain a string .

Constraints

Each string  will consist only of characters  and 
Output Format

For each query, print the minimum number of deletions required on a new line.

Sample Input

5
AAAA
BBBBB
ABABABAB
BABABA
AAABBB
Sample Output

3
4
0
0
4
Explanation

The characters marked red are the ones that can be deleted so that the string doesn't have matching consecutive characters.
*/