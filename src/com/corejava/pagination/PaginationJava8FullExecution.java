package com.corejava.pagination;

//import lombok.AllArgsConstructor;
//import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	private Result() {}
	public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder,
			int itemPerPage, int pageNumber) {

		List<Item> itemList = new ArrayList<>();
		items.stream().forEach(i -> itemList.add(new Item(i.get(sortParameter))));
		//items.stream().forEach(i -> {itemList.add(new Item(i.get(sortParameter)));});
		Collections.sort(itemList, sortOrder == 0 ? new ItemAscComparator() : new ItemDescComparator());
		List<String> finalList = new ArrayList<>();
		List<String> retList = new ArrayList<>();
		for (int i = itemPerPage * pageNumber; i < Math.min((itemPerPage * pageNumber) + itemPerPage,
				items.size()); i++) {
			//finalList.add(itemList.get(i).getVal());
			finalList.add(itemList.get(i).getVal());
		}
		// Code to find ItemName after sorting
		for(String var:finalList){
			items.stream().forEach(a ->{
				if(a.get(sortParameter).equals(var)){
					//System.out.println(a.get(0));					
					retList.add(a.get(0));
				}
			});
		}//for
		
		return retList;
	}//fetchItemsToDisplay method

	static class ItemAscComparator implements Comparator<Item> {
		//@Override
		public int compare(Item o1, Item o2) {
			if (StringUtils.isNumeric(o1.getVal())) {
				return Integer.parseInt(o1.getVal()) - Integer.parseInt(o2.getVal());
			}
			return o1.getVal().compareTo(o2.getVal());
		}
	}// ItemAscComparator Class

	static class ItemDescComparator implements Comparator<Item> {
		//@Override
		public int compare(Item o1, Item o2) {
			if (StringUtils.isNumeric(o1.getVal())) {
				return Integer.parseInt(o2.getVal()) - Integer.parseInt(o1.getVal());
			}
			return o2.getVal().compareTo(o1.getVal());
		}
	}//ItemDescComparator Class

	// @Data
	// @AllArgsConstructor
	static class Item {
		private String val;
		public Item(String val) {
			this.val = val;
		}
		public String getVal() {
			return val;
		}
	} //Item Class
}//Result Class

public class PaginationJava8FullExecution {
	public static void main(String[] args) throws IOException {
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
		List<String> result = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemPerPage, pageNumber);
		//bufferedWriter.write(result.stream().collect(joining("\n")) + "\n");
		for(String var:result){
			System.out.println(var);
		}
		bufferedReader.close();
		//bufferedWriter.close();
	} //main
} //Class
