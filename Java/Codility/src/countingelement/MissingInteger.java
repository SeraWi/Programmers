package countingelement;

import java.util.Arrays;

public class MissingInteger {
	//that, given an array A of N integers, returns the smallest positive integer (greater than 0) 
	//that does not occur in A.
	// 가장 작은 정수반환(아직 A에 나오지 않은)
	public static int solution(int[] A) {
		// write your code in Java SE 8
		int ans = 1;
		
		Arrays.sort(A);
		//1, 3, 6, 4, 1, 2
		// 1,1,2,3,4,6
		// 같은경우에 1증가시킨다.
		for( int i =0; i<A.length; i++) {
			if(ans == A[i]) {
				ans ++;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int [] A = {1, 3, 6, 4, 1, 2};
		System.out.println(solution(A));
	}

}
