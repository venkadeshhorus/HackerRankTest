package com.hackerrank.DictionariesAndHashmaps;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SherlockAndAnagrams {
	// Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	// go through a string and add every value to a hashmap
        HashMap<String, Integer> map = new HashMap<>();
            
        // total of anagrams
        int total = 0;
        
        // for each key, add one to value
        for(int i = 0; i < s.length(); i++) {
            for(int j = i+1; j <= s.length(); j++) {
                // get substring and sort it!
                String sub = s.substring(i,j);
                    
                // sorting the string
                char tempArray[] = sub.toCharArray();
                Arrays.sort(tempArray);
                sub = new String(tempArray);
                    
                if(map.containsKey(sub)){
                    // adds one to last value
                    int oldValue = map.get(sub);
                    total+=oldValue;
                    map.put(sub, ++oldValue);
                } else {
                    // add to map if not seen
                    map.put(sub, 1);
                }
            }
        }
        return total;
    } //sherlockAndAnagrams method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = sherlockAndAnagrams(s);
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class


/*
Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries. 
Each of the next  lines contains a string  to analyze.

Constraints

 
 
String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and respectively.

For the second query: 
There are 6 anagrams of the form  at positions  and . 
There are 3 anagrams of the form  at positions  and . 
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and . 
There are three anagrammatic pairs of length :  at positions  respectively.
 */
