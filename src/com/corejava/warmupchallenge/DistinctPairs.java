package com.corejava.warmupchallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctPairs {
	
	public static int SumPairs(Integer[] input, int k){
	    Map<Integer, Integer> frequencies = new HashMap<Integer, Integer>();
	    int pairsCount = 0;      

	    for(int i=0; i<input.length; i++){
	        int value = input[i];
	        int complement = k - input[i];

	        if(frequencies.containsKey(complement)){                
	            int freq = frequencies.get(complement) - 1;
	            pairsCount++;
	            //System.out.println(value + ", " + complement);    
	            if(freq == 0){
	                frequencies.remove(complement);
	            }else{
	                frequencies.put(complement, freq);
	            }
	        }else{
	            if(frequencies.containsKey(value)){         
	                frequencies.put(value, frequencies.get(value) + 1);             
	            }else{
	                frequencies.put(value, 1);
	            }
	        }
	    }
	    return pairsCount;
	}
	
	public static void main(String[] args) {
//		int k=1;
//		Integer[] input={1,2,3,4,5,6};
		
		int k=1;
		Integer[] input={1,1,2,2,3,3};
		
//		int k=12;
//		Integer[] input={6,6,3,9,3,5,1};
		
		int result=SumPairs(input, k);
		System.out.println(result);
		
	}

}
