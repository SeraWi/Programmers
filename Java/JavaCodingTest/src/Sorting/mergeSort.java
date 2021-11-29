package Sorting;
// 병합정렬 : nlogn을 보장한다.

public class mergeSort {
	public static int[] src; // 정렬할 배열
	public static int[] tmp; // 정렬된 배열  -> 전역변수로 선언
	
	public static void main(String[] args) {
		src= new int[] {1, 9, 8, 5, 4, 2, 3, 7, 6, 12, 10, 11};
		tmp = new int[src.length];
		//printArray(src); 
		mergeSort(0, src.length-1); 
		printArray(src);

	}
	// start : 시작 인덱스 , end : 마지막 인덱스
	public static void mergeSort(int start, int end) {
		if(start < end) {
			// break the list until it has only one item in each list
			
			int mid = (start+ end) /2; //분할 지점 : 중간!
			mergeSort(start, mid); // 분할기점으로 앞에 재귀함수 호출 , 왼쪽파트
			mergeSort(mid+1, end); // 뒤쪽 재귀함수 호출, 오른쪽 파트
			// make smaller list 
			
			int p= start ; // 시작 인덱스
			int q= mid +1; // 시작 인덱스
			int idx = start;
			
			// 작은 순서대로 배열에 삽입
			// 왼쪽 배열이 끝까지 가거나 오른쪽 배열이 끝까지 갈때까지 반복한다
			while( p <=mid || q<= end) {
				
				if(q>end ||(p<=mid && src[p] < src[q])) {//왼쪽이 작으면
					//값 넣은뒤 idx증가시키기
					tmp[idx++] =src[p++]; // 왼쪽을 넣고 인덱스 증가
				}else {
					tmp[idx++] =src[q++]; // 오른쪽이 작으면 오른쪽을 넣고 증가
				}
			}
			
			// 남은 데이터도 삽입
			for(int i=start; i<=end ; i++) {
				src[i] =tmp[i];
				
			}
		}
	}
	
	public static void printArray(int[]a) {
		for(int i=0; i<a.length; i++) {
			System.out.print( a[i] +" ");
		}
	}


}
