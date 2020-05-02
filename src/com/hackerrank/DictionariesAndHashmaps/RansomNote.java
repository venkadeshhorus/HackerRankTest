package com.hackerrank.DictionariesAndHashmaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RansomNote {
	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Map<String,Integer> magMap = new HashMap<>();
        Map<String, Integer> noteMap = new HashMap<>();
        
        for(String s:magazine) {
            if(magMap.containsKey(s)) {
                int i = magMap.get(s);
                i = i=i+1;
                magMap.put(s,i);
            }else {
                magMap.put(s, 1);
            }
        }
        
        for(String s:note) {
            if(noteMap.containsKey(s)) {
                int i = noteMap.get(s);
                i = i+1;
                noteMap.put(s,i);
            }else {
                noteMap.put(s, 1);
            }
        }
        
        Set<String> noteKey = noteMap.keySet();
        int flag = 0;
        for(String s: noteKey) {
            if(magMap.containsKey(s)) {
                if(magMap.get(s)>=noteMap.get(s)) {
                    flag = 1;
                }else {
                    flag = 0;break;
                }
            }else {
                flag = 0;break;
            }
            
        }
        if(flag ==1) {
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }


    } //checkMagazine method

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");
        int m = Integer.parseInt(mn[0]);
        int n = Integer.parseInt(mn[1]);
        String[] magazine = new String[m];
        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }
        String[] note = new String[n];
        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }
        checkMagazine(magazine, note);
        scanner.close();
    } //main
} //Class
