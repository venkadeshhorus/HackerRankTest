package com.corejava.pagination;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

			
public class PaginationListToArray {
	static List<String> resultList = new ArrayList<>();
	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber){
		// Converting List<List<String>> to String Array[][]
				List<String> list = new ArrayList<String>();
				items.forEach(i  -> {list.add(String.valueOf(i));});
				//Looping to find number of Items in the Row
				int listOfItemsInDataSetList = 0;
				for(int i=0; i<items.size(); i++) {
					listOfItemsInDataSetList = String.valueOf(list.get(i)).split(",").length;
				}
				
				String[][] myArray = new String[items.size()][listOfItemsInDataSetList];
				//System.out.println("list.size()....: "+list.size());
				for(int i=0; i<items.size(); i++) {
					String s = String.valueOf(list.get(i));
					String newString = s.substring(1, s.length()-1);
					String[] array = newString.split(",");
					for(int j=0; j<newString.split(",").length; j++) {
						myArray[i][j] = array[j];
					}
				}
				for(int i=0; i<myArray.length; i++) {
					for(int j=0; j<3; j++) {
						System.out.print(myArray[i][j]);
					}System.out.println();
				}
				fetchItemsToDisplay(myArray, sortParameter, sortOrder, itemPerPage, pageNumber);
				return resultList;
		//Concerting List<List<String>> to String Array[][]
	}
	
public static void fetchItemsToDisplay(String[][] items, int sortParameter, int sortOrder, int noOfItemsInPage, int pageNumber) {
		
		if(sortParameter == 0 && sortOrder == 0)
			Arrays.sort(items, new NameComparator());
		else if(sortParameter == 0 && sortOrder == 1)
			Arrays.sort(items, new DNameComparator());
		
		if(sortParameter == 1 && sortOrder == 0)
			Arrays.sort(items, new PriceComparator());
		else if(sortParameter == 1 && sortOrder == 1)
			Arrays.sort(items, new DPriceComparator());
		
		if(sortParameter == 2 && sortOrder == 0)
			Arrays.sort(items, new RelevanceComparator());
		else if(sortParameter == 2 && sortOrder == 1)
			Arrays.sort(items, new DRelevanceComparator());
		
		paginate(items, noOfItemsInPage, pageNumber);
		//return null;
	}
	
	public static void paginate(String[][] items, Integer noOfItemsInPage, Integer pageNumber) {
		Integer basePage = noOfItemsInPage * pageNumber;
		String[][] slice = Arrays.copyOfRange(items, basePage, basePage+noOfItemsInPage);
		System.out.println(slice);
		if(slice != null)
			for(int i=0; i<slice.length; i++)
				if(slice[i] != null)
					System.out.println(slice[i][0]);
	}// paginate method
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
		//BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter((System.getenv("OUTPUT_PATH")))));
		int itemsRows = Integer.parseInt((bufferedReader.readLine().trim()));
		int itemsColumns = Integer.parseInt((bufferedReader.readLine().trim()));
		List<List<String>> items = new ArrayList<>();
		IntStream.range(0, itemsRows).forEach(i -> {
			try {
				items.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		int sortParameter = Integer.parseInt(bufferedReader.readLine().trim());
		int sortOrder = Integer.parseInt(bufferedReader.readLine().trim());
		int itemPerPage = Integer.parseInt(bufferedReader.readLine().trim());
		int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());
		List<String> result = fetchItemsToDisplay(items, sortParameter, sortOrder, itemPerPage, pageNumber);
		//System.out.println(result);
		for(String s:result)
			System.out.println(s);
		//bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");
		//bufferedReader.close();
		//bufferedWriter.close();
		
	} //main

} //PaginationUday

