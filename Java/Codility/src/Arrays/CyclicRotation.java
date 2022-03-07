package Arrays;


// Cyclic Rotation
//The goal is to rotate array A K times; 
//that is, each element of A will be shifted to the right K times.
public class CyclicRotation {
	public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
		int len = A.length;
		int [] ans = new int [len]; //반환하는 배열
		
		//0번 rotate 혹은 자기 자신으로 돌아오는 경우
		if(len == 0 || K % len == 0) {
			return A;
		}
		
		K = K % len;
		
		for( int i = 0; i<len ; i++) {
			//현재 Idx에 +K만큼 이동
			// 만약 i+k가 인덱스 범위 넘어가는 것을 막기 위해 다시 길이로 나누면
			// 그 나머지가 움직인 인덱스가 된다.
			ans[(i+K) % len] = A[i];
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int[] ans = solution(new int[] {3,8,9,7,6}, 3);
		
		for( int i : ans) {
			System.out.println(i);
		}
	}
}
