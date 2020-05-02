package com.hackerrank.examQuestions;

import java.util.Scanner;

public class Coder {

    public static String winner(String erica, String bob) {
    // Write your code here
        char[] ericaCharvrv = erica.toCharArray();
        char[] bobCharvrv = bob.toCharArray();

        int ericaCountvrv = calculateCount(ericaCharvrv);
        int bobCountvrv = calculateCount(bobCharvrv);

        if(ericaCountvrv > bobCountvrv) {
            return "Erica";
        } else if(ericaCountvrv < bobCountvrv) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private static int calculateCount(char[] inputArrayvrv) {
        int scorevrv = 0;
        for(int i = 0; i < inputArrayvrv.length; i++) {
            if(inputArrayvrv[i] == 'E') {
                scorevrv += 1;
            } else if(inputArrayvrv[i] == 'M') {
                scorevrv += 3;
            } else if(inputArrayvrv[i] == 'H') {
                scorevrv += 5;
            }
        }
        return scorevrv;
    }
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	String ab = sc.next();
	String cd = sc.next();
	
	System.out.println(winner(ab,cd));
	}

}





	
	

