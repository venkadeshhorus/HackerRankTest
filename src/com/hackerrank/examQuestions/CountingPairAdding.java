package com.hackerrank.examQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CountingPairAdding {

	public static int countPairs(List<Integer> numbers, int k) {
		Set<Integer> set = new LinkedHashSet<Integer>();
		set.addAll(numbers);
		numbers.clear();
		numbers.addAll(set);
		int arr[] = numbers.stream().mapToInt(i -> i).toArray();
		int count = 0;
		for (int n = 0; n < arr.length; n++) {

			if (set.contains(arr[n] + k)) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		List<Integer> obj = new ArrayList<Integer>(n);
		for (int i = 1; i <= n; i++)
			obj.add(new Integer(scan.nextInt()));

		int k = scan.nextInt();
		System.out.println(countPairs(obj, k));
	}
}

/*
 * 
 * 
 * int arr[] = new int[n];
 * 
 * for(int i=0; i<arr.length;i++) arr[i] = scan.nextInt();
 * 
 * List<Integer> obj = new ArrayList(Arrays.asList(arr));
 * 
 * int k = scan.nextInt();
 */
