package com.corejava.readright;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferWriterExample {

	public static void main(String[] args) throws IOException {
		
		//String str = "Hello Indians. WE are all Indians. We are pruod to be Indian's. We should server our Country to become LENEDARY Country.";
		String str = "Hello Reddy. The INDIAN";
		//File file = new File("C://Users/rajasekharrp/Desktop/output.txt");		
		//FileWriter fr = new FileWriter(file);
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C://Users/rajasekharrp/Desktop/output.txt")));
		System.getenv(str);
		
		bw.write(str);
		bw.close();

	}

}
