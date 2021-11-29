package Sorting;
// mergeSort is recursive(method that calls itself)
// mergeSort does log n merge steps because each merge step doubles the list size
// it does n work for each merge step because it must look at every item.
// so it runs in O(n log n)
// Divide - and Conquer algorithm

import java.util.Arrays;

public class mergeSort2 {
	static int[] sorted = new int[8];
	
	public static void merge(int a[], int m, int middle, int n) {
		int part1 = m;//leftpart 의 시작 위치 설정
		int part2 =middle+1; //right part 의 시작 위치 설정
		int index= m; //배열 sorted에 정렬된 원소를 저장할 위치 설정
		
		
		while(part1 <=middle && part2 <=n) {
			if(a[part1] <= a[part2]) {
				sorted[index]= a[part1];
				part1++; //left half 옆으로 한칸 옮기기
			}else {
				sorted[index] =a [part2];
				part2++; //right half 옆으로 한칸 옮기기
			}
			index++;
		}
		//뒤쪽 배열은 비었고 앞쪽 배열에 남아있는 경우
		for (int i= 0; i<middle-part1 ; i++) {
			sorted[index+i] = a[part1+i];
		}
		
		for(int t=m; t<=n; t++) {
			a[t] = sorted[t];
		}
		System.out.println(Arrays.toString(a));
		
		
	}
	public static void mergeSort(int a[], int m, int n) {
		int middle;
		if (m<n){
			middle = (m+n)/2;
			mergeSort(a,m, middle); // left part
			mergeSort(a,middle+1,n); //right part
			merge(a, m, middle, n); //병합작업 수행
		}
	}
	public static void main(String[] args) {
		int[] list = {2,4,5,1,78,234,134};
		mergeSort(list,0, list.length-1);
	}
}
