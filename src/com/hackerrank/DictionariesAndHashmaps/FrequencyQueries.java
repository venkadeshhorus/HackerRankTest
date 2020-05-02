package com.hackerrank.DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyQueries {
	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	Map<Integer, Integer> numFreqMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> freqCountMap = new HashMap();
        List<Integer> ret = new ArrayList();
        
        for(List<Integer> values : queries) {
            int op = values.get(0);
            int val = values.get(1);
            
            if(op==3) {
                if(freqCountMap.containsKey(val)) {
                    ret.add(1);
                }else {
                    ret.add(0);
                }
            }else {
                if(op==1) {
                    Integer beforeFreq = numFreqMap.get(val);
                    beforeFreq = (beforeFreq == null) ? 0 : beforeFreq;
                    
                    if(beforeFreq == 0) {
                        numFreqMap.put(val, 1);
                    }else {
                        numFreqMap.put(val, beforeFreq+1);
                    }
                 
                    Integer count = freqCountMap.get(beforeFreq);
                    count = (count==null) ? 0 : count;
                    if(count ==0 ) {
                        
                    }else if(count == 1) {
                        freqCountMap.remove(beforeFreq);
                    }else {
                        freqCountMap.put(beforeFreq, count-1);
                    }
                    
                    Integer temp = freqCountMap.get(beforeFreq+1);
                    temp = temp==null ? 0:temp;
                    freqCountMap.put(beforeFreq+1, temp+1);
                    
                }else if(op==2) {
                    Integer beforeFreq = numFreqMap.get(val);
                    beforeFreq = (beforeFreq == null) ? 0 : beforeFreq;
                    
                    if(beforeFreq == 0) {
                        
                    }else if(beforeFreq == 1) {
                        numFreqMap.remove(val);
                    }else {
                        numFreqMap.put(val, beforeFreq-1);
                    }              
                        
                    Integer count = freqCountMap.get(beforeFreq);
                    count = (count==null) ? 0 : count;
                    
                    if(count == 0) {
                        
                    }else if(count == 1) {
                        freqCountMap.remove(beforeFreq);
                    }else {
                        freqCountMap.put(beforeFreq, count-1);
                    }
                    Integer temp = freqCountMap.get(beforeFreq-1);
                    temp = temp==null ? 0:temp;
                    freqCountMap.put(beforeFreq-1, temp+1);                
                }    
            }
        }
        return ret;
    } // freqQuery method

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(bufferedReader.readLine().trim());
        List<List<Integer>> queries = new ArrayList<>();
            try {
                for (int i = 0; i < q; i++) {
                    String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
                    List<Integer> queriesRowItems = new ArrayList<>();
                    for (int j = 0; j < 2; j++) {
                        int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
                        queriesRowItems.add(queriesItem);
                    }
                    queries.add(queriesRowItems);
                }
                List<Integer> ans = freqQuery(queries);
               
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }// try

        List<Integer> ans = freqQuery(queries);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(String.valueOf(ans.get(i)));
        }
    } //main
} //Class

/*
You are given  queries. Each query is of the form two integers described below: 
-  : Insert x in your data structure. 
-  : Delete one occurence of y from your data structure, if present. 
-  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: .

Function Description

Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

freqQuery has the following parameter(s):

queries: a 2-d array of integers
Input Format

The first line contains of an integer , the number of queries. 
Each of the next  lines contains two integers denoting the 2-d array .

Constraints

All 
Output Format

Return an integer array consisting of all the outputs of queries of type .

Sample Input 0

8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0

0
1
Explanation 0

For the first query of type , there is no integer whose frequency is  (). So answer is . 
For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

Sample Input 1

4
3 4
2 1003
1 16
3 1
Sample Output 1

0
1
Explanation 1

For the first query of type , there is no integer of frequency . The answer is . 
For the second query of type , there is one integer,  of frequency  so the answer is .

Sample Input 2

10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2

0
1
1
Explanation 2

When the first output query is run, the array is empty. We insert two 's and two 's before the second output query,  so there are two instances of elements occurring twice. We delete a  and run the same query. Now only the instances of  satisfy the query.

*/