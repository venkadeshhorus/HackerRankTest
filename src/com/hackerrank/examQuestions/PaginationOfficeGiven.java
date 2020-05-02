package com.hackerrank.examQuestions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
	//public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber){
	public static List<String> fetchItemsToDisplay(List<List<String>> dataSet, int sortField, int sortOrder, int rowsPerPage, int pageNumber){
		if(rowsPerPage ==0){
			return new ArrayList<>();
		}
		int startIndex = 0;
		int endIndex = rowsPerPage-1;
		if(pageNumber != 0){
			startIndex = (rowsPerPage * pageNumber);
			endIndex = (rowsPerPage * (pageNumber + 1))-1;
		}
		Comparator<List<String>> comparator = (h1, h2) -> h1.get(sortField).compareTo(h2.get(sortField));
		Collections.sort(dataSet, comparator);
		if(sortOrder != 0){
			Collections.reverse(dataSet);
		}
		List<String> list = new ArrayList<>();
		for(int i=startIndex; i<endIndex; i++){
			list.add(dataSet.get(i).get(0));
		}
		return list;
	} //fetchItemsToDisplay method
} //Class

public class PaginationOfficeGiven{
	public static void main(String[] args) throws IOException{
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
		Scanner scanner = new Scanner(System.in);
		
		int itemsRows = Integer.parseInt(bufferReader.readLine().trim());
		int itemsColumn = Integer.parseInt(bufferReader.readLine().trim());
		
		List<List<String>> items = new ArrayList<List<String>>();
		IntStream.range(0, itemsRows).forEach(i->{
			try{
				//items.add(Stream.of(bufferReader.readLine().replaceAll("\\s+$", "").collect(toList())));
				items.add((List<String>) Stream.of(bufferReader.readLine().replaceAll("\\s+$", "").split(" ")));
			}catch (Exception e) {
				throw new RuntimeException(e);
			}//try
		});
		int sortParameter = Integer.parseInt(bufferReader.readLine().trim());
		int sortOrder = Integer.parseInt(bufferReader.readLine().trim());
		int itemPerPage = Integer.parseInt(bufferReader.readLine().trim());
		int pageNumber = Integer.parseInt(bufferReader.readLine().trim());
		
		List<String> result = Solution.fetchItemsToDisplay(items, sortParameter, sortOrder, itemPerPage, pageNumber);
		//bufferWriter.write(result.stream().collect(joining("\n"))+"\n");
		
		bufferReader.close();
		//bufferWriter.close();
	}
}
