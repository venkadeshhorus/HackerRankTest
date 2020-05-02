package com.hackerrank.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class ChennaiPlayer{
    String name;
    int score;
    
    ChennaiPlayer(String name, int score){
        this.name = name;
        this.score = score;
    }
} // ChennaiPlayer

class SortChennaiPlayerByScore implements Comparator<ChennaiPlayer>{
	@Override
	public int compare(ChennaiPlayer a, ChennaiPlayer b) {
		if (a.score < b.score) {
	      return 1;
	    } else if (a.score > b.score) {
	      return -1;
	    } else {
	      return a.name.compareTo(b.name);
	    }
	} //compare
} //SoryByPlayerScore

class SortChennaiPlayerByName implements Comparator<ChennaiPlayer>{
	@Override
	public int compare(ChennaiPlayer a, ChennaiPlayer b) {
		return a.name.compareTo(b.name);
	} // compare
} // SoryByName
	



public class JavaComparatorOnArrayList
{
	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<ChennaiPlayer> al = new ArrayList<ChennaiPlayer>();
        //ChennaiPlayer[] player = new ChennaiPlayer[n];
        //Checker checker = new Checker();
        
        for(int i = 0; i < n; i++){
            //player[i] = new Player(scan.next(), scan.nextInt());
        	al.add(new ChennaiPlayer(scan.next(), scan.nextInt()));
        }
        scan.close();

        //Arrays.sort(player, player);
        Collections.sort(al, new SortChennaiPlayerByName());
        for(ChennaiPlayer p:al){
        	System.out.println(p.name+"\t"+p.score);
        }
	} //main
} //Class

/*

Comparators are used to compare two objects. In this challenge, you'll create a comparator and use it to sort an array.

The Player class is provided for you in your editor. It has  fields: a  String and a  integer.

Given an array of  Player objects, write a comparator that sorts them in order of decreasing score; if  or more players have the same score, sort those players alphabetically by name. To do this, you must create a Checker class that implements the Comparator interface, then write an int compare(Player a, Player b) method implementing the Comparator.compare(T o1, T o2) method.

Input Format

Input from stdin is handled by the locked stub code in the Solution class.

The first line contains an integer, , denoting the number of players. 
Each of the  subsequent lines contains a player's  and , respectively.

Constraints

 players can have the same name.
Player names consist of lowercase English letters.
Output Format

You are not responsible for printing any output to stdout. The locked stub code in Solution will create a Checker object, use it to sort the Player array, and print each sorted element.

Sample Input

5
amy 100
david 100
heraldo 50
aakansha 75
aleksa 150
Sample Output

aleksa 150
amy 100
david 100
aakansha 75
heraldo 50
*/