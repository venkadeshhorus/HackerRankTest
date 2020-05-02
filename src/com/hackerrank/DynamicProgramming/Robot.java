package com.hackerrank.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class Robot {
	/*
     * Complete the robot function below.
     */
    static int robot(int[][] vp) {
        
    	return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");
        int[][] vp = new int[n][2];
        for (int vpRowItr = 0; vpRowItr < n; vpRowItr++) {
            String[] vpRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int vpColumnItr = 0; vpColumnItr < 2; vpColumnItr++) {
                int vpItem = Integer.parseInt(vpRowItems[vpColumnItr]);
                vp[vpRowItr][vpColumnItr] = vpItem;
            }
        }
        int result = robot(vp);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
        scanner.close();
    } //main
} //Class
