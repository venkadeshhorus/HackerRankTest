package com.hackerrank.string;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndTheValidString {
	// Complete the isValid function below.
    static String isValid(String s) {
    	HashMap<Character, Integer> map = new HashMap<>();
	    char[] str_arr= s.toCharArray();
	    for(char c:str_arr)
	    {
	        if(map.containsKey(c))
	        {
	            map.put(c, map.get(c)+1);
	        }
	        else
	        {
	            map.put(c,1);
	        }
	    }

	    //define min max frequencies
	    int min = (int) Math.pow(10, 5);	  
	    int max = 0;
	    for(int value : map.values()) {
	        if (value < min ) {
	            min = value;
	        }
	        if(value > max ) {
	            max = value;
	        }
	    }

	    if(min == max) { return "YES";} //all frequencies equal
	    if( (max - min) > 1) {return "NO";} //removing one character can not make the equal

	    //for other cases make sure that only one frequency is different
	    int countBiggerThanMin = 0;
	    for(int value : map.values()) {
	        if(value > min ) {
	            countBiggerThanMin++;
	        }
	    }

	    if((countBiggerThanMin == 1) || //only one bigger than min
	            (countBiggerThanMin == (map.size() - 1))) { //min is samller than all others
	        return "YES";
	    }
	    return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s = scanner.nextLine();
        String result = isValid(s);
        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    } //main
} //Class



/*
Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.

For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .

Function Description

Complete the isValid function in the editor below. It should return either the string YES or the string NO.

isValid has the following parameter(s):

s: a string
Input Format

A single string .

Constraints

Each character 
Output Format

Print YES if string  is valid, otherwise, print NO.

Sample Input 0

aabbcd
Sample Output 0

NO
Explanation 0

Given , we would need to remove two characters, both c and d  aabb or a and b  abcd, to make it valid. We are limited to removing only one character, so  is invalid.

Sample Input 1

aabbccddeefghi
Sample Output 1

NO
Explanation 1

Frequency counts for the letters are as follows:

{'a': 2, 'b': 2, 'c': 2, 'd': 2, 'e': 2, 'f': 1, 'g': 1, 'h': 1, 'i': 1}

There are two ways to make the valid string:

Remove  characters with a frequency of : .
Remove  characters of frequency : .
Neither of these is an option.

Sample Input 2

abcdefghhgfedecba
Sample Output 2

YES
Explanation 2

All characters occur twice except for  which occurs  times. We can delete one instance of  to have a valid string.
 */
