package com.hackerrank.examQuestions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PalindromCounterRanga {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String gb_inputString = "abccba";
		printAllPalindromicSusbtrings(gb_inputString);
	}
	
	static void printAllPalindromicSusbtrings(String gb_inputString) {
		// create an empty set to store all unique palindromic substrings
		List<String> set = new ArrayList<String>();

		for (int i = 0; i < gb_inputString.length(); i++)
		{
			// find all odd length palindrome with str[i] as mid point
			//System.out.println("--------------\nIteration "+i);
			expand(gb_inputString, i, i, set);

			// find all even length palindrome with str[i] and str[i+1]
			// as its mid points
			expand(gb_inputString, i, i + 1, set);
		}

		// print all unique palindromic substrings
		//System.out.print(set);
		System.out.print(set.size());
		
		
	}
	// expand in both directions of low and high to find all palindromes
		public static void expand(String str, int low, int high, List<String> set)
		{
			//System.out.println("Low "+low+"High "+high);
			// run till str[low.high] is a palindrome
			while (low >= 0 && high < str.length()
					&& str.charAt(low) == str.charAt(high))
			{
				//System.out.println("While Low "+low+"While High "+high);
				// push all palindromes into the set
				set.add(str.substring(low, high + 1));
				
				//System.out.println(str.substring(low, high + 1));

				// expand in both directions
				low--;
				high++;
			}
		}
}


