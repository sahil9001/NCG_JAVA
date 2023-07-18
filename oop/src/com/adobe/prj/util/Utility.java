package com.adobe.prj.util;

public class Utility {
	// OCP ==> pass rectangles, circles, string, ...
	// program to contract
	public static void sort(IComparable[] elems) {
		for (int i = 0; i < elems.length; i++) {
			for (int j = i + 1; j < elems.length; j++) {
				if(elems[i].compare(elems[j]) > 0) {
					IComparable temp = elems[i];
					elems[i] = elems[j];
					elems[j] = temp;
				}
			}
		}
	}
}
