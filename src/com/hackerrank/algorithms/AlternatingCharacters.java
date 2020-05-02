package com.hackerrank.algorithms;

import java.io.IOException;
import java.util.Scanner;

public class AlternatingCharacters {
	// Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        char[] charArray = s.toCharArray();
        int alternateCharacters = 0;
        for(int i=0; i<charArray.length-1; i++){
            if(charArray[i]==charArray[i+1]){
                alternateCharacters++;
            }
        }// for
        return alternateCharacters;
    } // static block

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();
            int result = alternatingCharacters(s);
            //bufferedWriter.write(String.valueOf(result));            
            //bufferedWriter.newLine();            
            System.out.print(result);
            System.out.println();
        }
        //bufferedWriter.close();
        scanner.close();
    }// main
} //Class
