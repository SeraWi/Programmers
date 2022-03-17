package L6_Sorting;

public class Sorting {
	//삽입, 선택, 버블, (퀵, 힙)
	
	
	//삽입 정렬
	// 최악의 경우 : 입력자료 역순, log(N*2)
	// 최선의 경우 :o(N)
	public static void insertionSort(int[]A) {
		// 두번째 자료부터 시작하여 그 앞의 자료들과 비교하여 옮긴다.
		// 특징 1. 추가 공간 사용하지 않고 주어진 배열에서 옮기기 때문에 공간복잡도 O(1)
		// 특징 2. 정렬범위를 2개로 시작해서 전체로 확장한다.
		
		for( int end = 1; end < A.length; end++) {
			//바깥쪽 루프는 순방향 으로
			for( int i = end ; i > 0; i--) {
				// 안쪽 루프는 역뱡향으로 탐색
				if(A[i-1] > A[i]) {
					//앞에가 더크면 swap한다.
					swap(A, i-1, i);
				}
			}
		}
	}
	
	// 삽입정렬 최적화
	public static void insertionSortOpt(int[]A) {
		
		// 하나의 수가 왼쪽 보다 크다면 그 앞쪽의 루프를 모두 돌 필요 없다.
		for( int end = 1; end<A.length; end++) {
			int i = end;
			while( i> 0 && A[i-1] > A[i]) {
				// 오른쪽이 왼쪽보다 작은경우에만 루프를 돌고
				// 만약 한번이라고 왼 < 오 이순간이 나오면
				// 그 앞쪽 원소들은 루프 돌며 확인할 필요 없다.
				swap(A, i-1, i);
				i--;
			}
		}
	}
	private static void swap(int[]arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b]= tmp;
	}
	
	// 한번의 루프를 돌면 가장 큰 수를 오른쪽으로 옮긴다.
	// 시간복잡도 O(N*N), worst, best, avg 모두
	public static void bubbleSort(int[]arr) {
		for( int i= arr.length-1; i> 0 ; i--) {
			//제일 큰거를 뒤로 옮기고 그 앞을 채워나간다.
			for( int j = 0; j<= i; j++) {
				if(arr[j] > arr[j+1]) {
					// 앞에 수가 더큰면 swap
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	//최적화
	public static void bulbbeSortOpt(int[]arr) {
		for( int i= arr.length-1; i > 0; i--) {
			boolean swapped = false;
			
			for( int j = 0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					swap(arr, j, j+1);
					swapped = true;
				}
			}
			if(!swapped) {
				break;
			}
		}
	}
	
	//재귀로 버블 정렬 수행
	public static void bubbleRecursive(int[]arr, int last) {
		if(last > 0) {
			//마지막 인덱스가 0보다 클때까지 계속 반복
			for( int i = 1 ; i<= last; i++) {
				if(arr[i-1] > arr[i]) {
					swap(arr, i-1, i);
				}
			}//마지막 인덱스를 정렬 시킨 상태
			
			//마지막 인덱스 하나 줄여서 재귀로 호출
			bubbleRecursive(arr, last-1);
		}
	}
	
	//선택 정렬 : 가장 작은 값을 앞으로 옮기는 정렬
	// 작은값을 계속 비교해서 배열끝에왔을 때 min값을 가장 앞고 교체
	//시간복잡도 O(N*N)
	public static void selectionSort(int[]arr) {
		for( int i = 0; i<arr.length-1; i++) {
			//제일처음 숫자가 교체 대상이다. 가장 마지막 앞까지 하면 된다.
			int minIdx =i;
			for( int j = i+1; j<arr.length; j++) {
				if(arr[j] <arr[minIdx]) {
					//작은경우 계속 idx저장
					minIdx = j;
				}
			}
			// 한번의 안쪽 루프 끝나면 가장 앞의 idx와 min값의 idx로 교체하기
			swap(arr, i, minIdx);
		}
	}
	
	
	//Arrays.sort()함수나 프로그래밍에 내장된 정렬함수는 퀵소트로 구현되어있다.
	// 피봇으로 임의의 기준값을 사용해서 피봇 왼쪽은 피봇보다 작은값을
	// 피봇 오른쪽은 피봇보다 큰 값으로 정렬한다.
	// 특징1. 피봇값을 어떤걸로 선택하냐 에 따라 성능이 달라진다.
	// avg : nlogN, worst : n*n
	public static void quickSort(int[]arr) {
		
		sort(arr, 0, arr.length-1);
		
		// 결과 출력
		for(int a: arr) {
			System.out.print(a +" ");
		}
	}
	
	public static void sort( int[]arr, int low, int high) {
		
		if(low >= high) {
			return;
		}
		//중간값 정하기
		int mid =partition(arr, low, high);
		
		//왼쪽 정렬
		sort(arr, low, mid-1);
		
		//오른쪽 정렬
		sort(arr, mid, high);
		
	}
	
	//low: 시작인덱스 high : 끝 인데스
	private static int partition(int[]arr, int low, int high) {
		int pivot = arr[(low+high)/2];
		
		while(low <= high) {
			while(arr[low] < pivot) {
				low++; //인덱스 오른쪽으로 이동하면서 확인
			}
			while(arr[high] > pivot) {
				//인덱스 끝에서부터 왼쪽으로 이동하면서 확ㅇㄴ
				high--;
			}
			
			// 피봇 기준으로 정렬이 제대로 되지 않은경우
			if(low <= high) {
				// index 지나치지 않았는지 확인
				swap(arr, low, high);
				low++; //다시 인덱스 증가시켜서 반복 수행
				high--; // 왼쪽으로 옮기기
			}
			
		}
		return low;//다음 재귀함수의 호출 분할 기점
	}
	
	public static void main(String[] args) {
		int[]arr = {2,7,6,5,3,1,10};
		quickSort(arr);
		
	}
}
