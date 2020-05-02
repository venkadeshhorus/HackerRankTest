package com.hackerrank.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class TwoRobots {
	/*
     * Complete the twoRobots function below.
     */
    static int twoRobots(int m, int[][] queries) {
        
    	return 1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int t = Integer.parseInt(scanner.nextLine().trim());
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0].trim());
        int n = Integer.parseInt(mn[1].trim());
        int[][] queries = new int[n][2];
        for (int queriesRowItr = 0; queriesRowItr < n; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            for (int queriesColumnItr = 0; queriesColumnItr < 2; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }
        int result = twoRobots(m, queries);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        System.out.println(result);
    } //main
} //Class
