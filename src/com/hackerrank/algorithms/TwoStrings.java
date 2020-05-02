package com.hackerrank.algorithms;

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
}
