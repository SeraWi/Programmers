package L14_BinarySearch;

// 정렬된 배열에서 사용하기 적합
// 중앙값을 조사하여 찾고자 하는 항목이 왼쪽 또는 오른쪽에 있는지 확인
// logN
public class BinarySearch {
	static int[] arr ;
	static int ans;
	
	private static void binarySearch(int goal) {
		int low = 0;
		int high = arr.length-1;//마지막 인덱스
		
		while(low >= high) {
			System.out.println(low +","+ high);
			int mid = (low + high) /2;
			ans++;
			System.out.println(ans);
			
			if(goal == arr[mid]) {
				System.out.println("find");
				break;
			}else if(goal <= arr[mid]) {
				//mid  위치보다 작게  -> 왼쪽 탐색
				high = mid -1;
			}else {
				//low값 mid 보다 하나 크게 설정 -> 오른쪽 탐색
				low = mid+1;
			}
		}
		
		
	}
	
	public static void main(String[] args) {
		arr = new int[] {5,7,9,15,20,38,39,52,58,77};
		binarySearch(58);
		System.out.println(ans);
	}
	
	
}
