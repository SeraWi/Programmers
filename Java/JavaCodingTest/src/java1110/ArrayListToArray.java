package java1110;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {
	public static void main(String[] args) {
		String [] array = new String[3];
		array[0] = "Test1";
		array[1] = "test2";
		array[2] ="test3";
		// 배열 -> arrayList
		// Arrays.asList(배열);
		ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(array));
		System.out.println(arrayList);
		
		// arrayList ->배열
		// arrayList.toArray()
		String [] array2 = arrayList.toArray(new String[arrayList.size()])		;
		System.out.println(array2[0]);
		System.out.println(array2[1]);
		System.out.println(array2[2]);
		
	}
	
}
