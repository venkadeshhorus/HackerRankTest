package com.corejava.aaaaaaall;

import java.io.IOException;
import java.util.Scanner;

public class TwoStrings {
	// Complete the twoStrings function below.
	static String twoStrings2(String s1, String s2) {
        String resultString = "NO";
        for(char c : "abcdefghijklmnopqrstuvwxyz".toCharArray())
        {
        	if(s1.indexOf(c) > -1 && s2.indexOf(c) > -1)
        		resultString = "YES";
        }
        
        return resultString;
    }// twoStrings2 method
	
	
    static String twoStrings(String s1, String s2) {
    	char[] charArray1 = s1.toCharArray();
    	char[] charArray2 = s2.toCharArray();
    	String commonLetter = "NO";
    	if(s1.length() >= s2.length())
	    	for(int i=0; i<s1.length(); i++){
	    		for(int j=0; j<s2.length(); j++){
	    			if(charArray1[i] == charArray2[j]){
	    				commonLetter = "YES";
	    			}
	    		}
	    	}else{
	    		for(int i=0; i<s2.length(); i++){
		    		for(int j=0; j<s1.length(); j++){
		    			if(charArray2[i] == charArray1[j]){
		    				commonLetter = "YES";
		    			}
		    		}
	    		}// for
	    	}//if
    	return commonLetter;
    } // twoStrings method.

    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();
            String result = twoStrings2(s1, s2);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
            System.out.println(result);
        }
        //bufferedWriter.close();
        scanner.close();
    } // main
} // Class
