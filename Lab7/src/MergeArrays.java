// package com.gradescope.mymerge;

import java.util.ArrayList;

public class MergeArrays {

	public static <T> ArrayList<T> merge(T[] first, T[] second) {
		if(first.length < second.length) {
			return mergeInOrder(first, second);
		}
		else {
			return mergeInOrder(second, first);
		}
	}
	
	// take first as the shorter array
	private static <T> ArrayList<T> mergeInOrder(T[] first, T[] second){
		ArrayList<T> mergedArrays = new ArrayList<>();
		for(int i = 0; i < first.length; i++) {
			mergedArrays.add(first[i]);
			mergedArrays.add(second[i]);
		}
		
		for(int i = first.length; i < second.length; i++) {
			mergedArrays.add(second[i]);
		}
		return mergedArrays;
	}
	
}
