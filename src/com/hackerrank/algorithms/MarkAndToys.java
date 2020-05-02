package com.hackerrank.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys {
	// Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int noOfItemsBought = 0;
        int budget = k;
        Arrays.sort(prices);
        for(int i=0; i<prices.length; i++){
            if(budget>prices[i]){
                noOfItemsBought++;
                budget-=prices[i];
            }
        }// for      
        
        return noOfItemsBought;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        //int result = maximumToys(prices, k);

        // Checking the Range Condition
        boolean rangeCheck = false;
        if(n>=1 && n<=Math.pow(10,5) && k>=1 && k<=Math.pow(10,9)){
            for(int i=0; i<prices.length; i++){
                if(prices[i]>=1 && prices[i]<=Math.pow(10,9)){
                    rangeCheck = true;
                }
                else{
                    rangeCheck = false;
                    break;
                }
            }// for        
        } else{
            rangeCheck = false;
        } // if        
        if(rangeCheck){
            int result = maximumToys(prices, k);
            System.out.println(result);
        }else{
            //System.out.println("Entered values are not in the Range...");
        }// if     
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();
        //bufferedWriter.close();

        scanner.close();
    }
}
