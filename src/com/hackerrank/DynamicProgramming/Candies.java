package com.hackerrank.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class Candies {
	// Complete the candies function below.
    static long candies(int n, int[] arr) {
    	int[] cache = new int[arr.length];
        cache[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                cache[i] = cache[i-1] + 1;
            }
            if (arr[i-1] >= arr[i]) {
                cache[i] = 1;
            }
        }// for

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i+1]) {
                if (cache[i] <= cache[i+1]) {
                    cache[i] = cache[i+1] + 1;
                }
            }
        }// for

        Long sum = Long.valueOf(0);
        for (int i = 0; i < cache.length; i++) {
            sum +=Long.valueOf(cache[i]);
        } //for

        return sum;
    } // candies method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }
        long result = candies(n, arr);
        //bufferedWriter.write(String.valueOf(result));
        System.out.println(result);
        //bufferedWriter.newLine();
        //bufferedWriter.close();
        scanner.close();
    } //main
} //Class
