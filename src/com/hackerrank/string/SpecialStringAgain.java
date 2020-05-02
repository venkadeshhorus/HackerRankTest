package com.hackerrank.string;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SpecialStringAgain {
	char text; long counter;
	SpecialStringAgain(char t, long c){
	        text = t;
	        counter = c;
	    }
	 
	// Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long palindromeCount = 0L;
        long equalCounter = 1L;
        List<SpecialStringAgain> countList = new ArrayList<SpecialStringAgain>();

        for(int i=1; i<s.length();i++){        	
            if(s.charAt(i)==s.charAt(i-1)){
                equalCounter++;
            }
            else{            	
                countList.add(new SpecialStringAgain(s.charAt(i-1),equalCounter));
                equalCounter = 1L;
            }
        }
        countList.add(new SpecialStringAgain(s.charAt(s.length()-1), equalCounter));

        for(int i=0; i<countList.size(); i++){
            palindromeCount += (countList.get(i).counter+1)*countList.get(i).counter/2;
        }
        for (int i = 1; i < countList.size()-1; i++) {
            if(countList.get(i).counter == 1
            && countList.get(i-1).text == countList.get(i+1).text){
                palindromeCount += Math.min(countList.get(i-1).counter,countList.get(i+1).counter);
            }
        }
        return palindromeCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        String s = scanner.nextLine();
        long result = substrCount(n, s);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    } //main
} //Class

/*
A string is said to be a special string if either of two conditions is met:

All of the characters are the same, e.g. aaa.
All characters except the middle one are the same, e.g. aadaa.
A special substring is any substring of a string which meets one of those criteria. Given a string, determine how many special substrings can be formed from it.

For example, given the string s=mnonopoo, we have the following special substrings: .
{m, n, o, n, o, p, o, o, non, ono, opo, oo}

Function Description

Complete the substrCount function in the editor below. It should return an integer representing the number of special substrings that can be formed from the given string.

substrCount has the following parameter(s):

n: an integer, the length of string s
s: a string
Input Format

The first line contains an integer, , the length of . 
The second line contains the string .

Constraints

 
Each character of the string is a lowercase alphabet, .

Output Format

Print a single line containing the count of total special substrings.

Sample Input 0

5
asasd
Sample Output 0

7 
Explanation 0

The special palindromic substrings of  are 

Sample Input 1

7
abcbaba
Sample Output 1

10 
Explanation 1

The special palindromic substrings of  are 

Sample Input 2

4
aaaa
Sample Output 2

10
Explanation 2

The special palindromic substrings of s=aaaa  are {a, a, a, a, aa, aa, aa, aaa, aaa, aaaa}
*/