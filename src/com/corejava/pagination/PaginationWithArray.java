package com.corejava.pagination;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

			
public class PaginationWithArray {
	public static void paginate(String[][] items, Integer noOfItemsInPage, Integer pageNumber) {
		Integer basePage = noOfItemsInPage * pageNumber;
		String[][] slice = Arrays.copyOfRange(items, basePage, basePage+noOfItemsInPage);
		if(slice != null)
			for(int i=0; i<slice.length; i++)
				if(slice[i] != null)
					System.out.println(slice[i][0]);
	}// paginate method
	
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
	public static void main(String[] args) {
		Scanner myObj  = new Scanner(System.in);
		Integer noOfItems = Integer.parseInt(myObj.nextLine());
		
		Integer noOfAttributesInAnItem = Integer.parseInt(myObj.nextLine());
		String[][] items = new String[noOfItems][];
		
		for(int i=0; i<noOfItems; i++) {
			String itemsWithSpaces = myObj.nextLine();
			String[] itemWithAttributes = new String[noOfAttributesInAnItem];
			String[] itemAfterSplit = itemsWithSpaces.split(" ");
			for(int j=0; j<noOfAttributesInAnItem; j++) {
				itemWithAttributes[j] = itemAfterSplit[j];
			}
			items[i] = itemWithAttributes;
		}
		Integer sortParameter = Integer.parseInt(myObj.nextLine());
		Integer sortOrder = Integer.parseInt(myObj.nextLine());
		Integer noOfItemsInPage = Integer.parseInt(myObj.nextLine());
		Integer pageNumber = Integer.parseInt(myObj.nextLine());
		myObj.close();
		fetchItemsToDisplay(items, sortParameter, sortOrder, noOfItemsInPage, pageNumber);
		
	} //main

} //PaginationUday


class NameComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {
		System.out.println("a[0]...: "+ Integer.parseInt(a[0]));
		System.out.println("b[0]...: "+ Integer.parseInt(b[0]));
		return a[0].compareTo(b[0]);}
}
class DNameComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {System.out.println("a[0]...: "+ Integer.parseInt(a[0]));
	System.out.println("b[0]...: "+ Integer.parseInt(b[0]));return -a[0].compareTo(b[0]);}
}
class PriceComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {
		System.out.println("a[1]...: "+ Integer.parseInt(a[1]));
		System.out.println("b[1]...: "+ Integer.parseInt(b[1]));
		if(Integer.parseInt(a[1]) > Integer.parseInt(b[1]))
			return 1;
		else
			return -1;
	}
}
class DPriceComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {
		System.out.println("a[1]...: "+ Integer.parseInt(a[1]));
		System.out.println("b[1]...: "+ Integer.parseInt(b[1]));
		if(Integer.parseInt(a[1])<Integer.parseInt(b[1]))
			return 1;
		else
			return -1;
	}
}


class RelevanceComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {
		System.out.println("a[2]...: "+ Integer.parseInt(a[2]));
		System.out.println("b[2]...: "+ Integer.parseInt(b[2]));
		if(Integer.parseInt(a[2]) > Integer.parseInt(b[2]))
			return 1;
		else
			return -1;
	}
}
class DRelevanceComparator implements Comparator<String[]>{
	public int compare(String[] a, String[] b) {
		System.out.println("a[2]...: "+ Integer.parseInt(a[2]));
		System.out.println("b[2]...: "+ Integer.parseInt(b[2]));
		if(Integer.parseInt(a[2])<Integer.parseInt(b[2]))
			return 1;
		else
			return -1;
	}
}
			
