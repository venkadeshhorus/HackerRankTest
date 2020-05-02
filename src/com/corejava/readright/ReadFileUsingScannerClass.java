package com.corejava.readright;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileUsingScannerClass {

	public static void main(String[] args) throws FileNotFoundException {
		/*
		File file = new File("C:/Users/rajasekharrp/Desktop/testfile.txt");		
		Scanner scanner = new Scanner(file);
		scanner.useDelimiter("\\Z");
		System.out.println(scanner.next());
		*/
		
		Scanner scanner = new Scanner(System.in);
		int i=1;
		while(scanner.hasNext()){
			scanner.useDelimiter("\\Z");
			System.out.println(i+" "+scanner.nextLine());
			i++;
		}
		

	}

}
