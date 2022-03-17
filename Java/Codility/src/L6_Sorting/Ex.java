package L6_Sorting;

public class Ex {
	// 선택 : min 값을 왼쪽으로 계속 옮긴다.
	// 삽입 : 오른쪽으로 탐색하면서 앞에보다 큰지 확인한다.
	// 버블 : max값을 항상 오른쪽으로 옮긴다.
	// 퀵 : 이진탐색한다. pivot


	public static void swap(int[]arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr	[b] = tmp;
	}
	
	
	public static void selectionSort(int []arr) {
		for( int i = 0; i<arr.length -1; i++) {
			int minIdx = i;
			for( int j = i+1; j<arr.length; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			swap(arr, i, minIdx);
		}
		
		for( int a : arr) {
			System.out.print(a +" ");
		}
		
	}
	
	
	public static void insertSort(int[]arr) {
		for( int i = 1; i<arr.length; i++) {
			for( int j= i-1; j >=0 ; j--) {
				if(arr[i] < arr[j]) {
					swap(arr, i, j);
				}
			}
		}
		for( int a : arr) {
			System.out.print(a +" ");
		}
	}
	
	public static void bubblesort(int[]arr) {
		
		for( int i= arr.length -1; i>0 ; i--) {
			//역방향
			for( int j= 0; j<i; j++) {
				//순방향
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1)
;				}
			}
		}
		for( int a : arr) {
			System.out.print(a +" ");
		}
		
	}
	
	public static void quickSort(int[]arr) {
		sort(arr, 0, arr.length-1);
		
		for( int a : arr) {
			System.out.print(a +" ");
		}
	}
	
	//범위를 나눠준다 (정렬X)
	public static void sort(int[]arr, int start, int end) {
		
		
		if(start>=end ) {
			//인덱스 엉킨 순간 이미 정렬 완료
			return ;
		}
		
		// 분할 해야 하는 index
		int mid = partition(arr,start, end);
		
		//재귀 호출
		sort(arr, start, mid-1);
		sort(arr, mid, end);
		
	}
	
	//실제로 하나의 분할된 파트에서 정렬을 시킨다.
	// 그리고 다음 분할 지점을 반환한다.
	public static int partition(int[]arr, int start,  int end) {
		int pivot = arr[(start + end)/2];
		
		while(start <= end) {
			while(arr[start] < pivot) {
				start ++;
			}
			while(arr[end] > pivot) {
				end--;
			}
			
			//여기에 오면 
			//왼쪽의 한값이 pivot보다 크고
			// 오른쪽의 하나의 값이 pivot보다 작다는 뜻이ㅏㄷ
			// 이 두개를 바꿔준다.
			
			if(start<= end) {
				swap(arr, start, end);
				start++;
				end--;
			}
			
		}
		return start;
		
	}
	
	public static void main(String[] args) {
		int[]arr = {2,7,6,5,3,1,10};
		selectionSort(arr);
		System.out.println();
		insertSort(arr);
		System.out.println();
		bubblesort(arr);
		System.out.println();
		quickSort(arr);
	}
	
}
