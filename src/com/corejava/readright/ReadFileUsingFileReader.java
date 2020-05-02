package com.corejava.readright;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileUsingFileReader {

	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("C:/Users/rajasekharrp/Desktop/testfile.txt");
		
		int i;
		while((i = fr.read()) != -1){
			//System.out.println((char)i);
			System.out.println(fr.read());
		}
		
	}

}
