package com.hackerrank.DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountTriplets {
	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	long ans = 0;
        Long[] array = new Long[arr.size()];
        Map<Long, Long> right = new HashMap<Long, Long>();
        Map<Long, Long> left = new HashMap<Long, Long>();
        for (int i = 0; i < arr.size(); i++) {
            array[i] = arr.get(i);
            right.put(array[i], 0l);
            left.put(array[i], 0l);
        }
 
        for (int i = 0; i < array.length; i++) {
            Long num = array[i];
            right.put(num, right.get(num) + 1);
        }
 
        for (int i = 0; i < array.length; i++) {
            Long num2 = array[i];
            right.put(num2, right.get(num2) - 1);
 
            if (num2 % r == 0) {
                Long num1 = num2 / r;
                Long num3 = num2 * r;
 
                if (left.containsKey(num1) && right.containsKey(num3)) {
                    ans += (left.get(num1) * right.get(num3));
                }
            }
 
            left.put(num2, left.get(num2) + 1);
        }
        return ans;
    } //countTriplets method

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        //List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).map(Long::parseLong).collect(toList());
        String[] arrItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        
        List<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr.add(arrItem);
        }// for

        //long ans = countTriplets(arr, r);
        long ans = countTriplets(arr, r);

        
        
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();
        System.out.println(ans);

        bufferedReader.close();
        //bufferedWriter.close();
    } //main
} //Class

/*
You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio. 
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and 

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and .

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index , , , .
*/