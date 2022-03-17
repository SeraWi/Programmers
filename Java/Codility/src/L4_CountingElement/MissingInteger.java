package L4_CountingElement;

import java.util.Arrays;
import java.util.HashSet;

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
	
	
	//O(N) or O(N * log(N))
	public int solution2(int[] A) {
		
		HashSet<Integer> nums = new HashSet<Integer>();
		
		// 1부터길이보다 하나크게 까지 만들기
		for( int i = 1; i<= A.length+1 ; i++) {
			//중복 제거
			nums.add(i);
		}
		
		//하나씩 지워나가기
		for( int a : A) {
			nums.remove(new Integer(a));
		}
		//최초로 나오는거 출력
		return nums.iterator().next();
		
	}
	public static void main(String[] args) {
		int [] A = {1, 3, 6, 4, 1, 2};
		System.out.println(solution(A));
	}

}
