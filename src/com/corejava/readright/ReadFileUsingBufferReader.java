package com.corejava.readright;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingBufferReader {

	public static void main(String[] args) throws IOException {		
		File file = new File("C:/Users/rajasekharrp/Desktop/testfile.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String st;
		while((st = br.readLine()) != null){
			System.out.println(" "+st);			
		}
		
	} // main
} // Class
