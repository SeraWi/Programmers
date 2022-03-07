package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//that, given an array A consisting of N integers fulfilling the above conditions, 
//returns the value of the unpaired element.
// 짝이 맞지 않은 element반환하기
public class OddOccurrence {
	
	// 통과 O(N) or O(N*log(N))
	public static int solution(int[] A) {
		// write your code in Java SE 8
		
		Arrays.sort(A); //오름차순 정렬
		for( int i= 0; i<=A.length-1;i+=2) {
				if(i+1<A.length) {
					if( A[i] != A[i+1] && i+1<A.length) {
						return A[i];
					}
				}
				if( i==A.length-1) {
					return A[i];
				}
		}

		return 0;
	}
	//O(N) or O(N*log(N))
	public int solution2(int[]A) {
		Map<Integer, Integer> map = new HashMap<>();
		for( int i = 0; i<A.length; i++) {
			//getOrDefault : 있으면 value 값 반환, 없으면 0반환
			map.put(A[i], map.getOrDefault(A[i], 0) +1); 
		}
		
		for( int  key : map.keySet()) {
			if(map.get(key)%2 == 1) {
				return key;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] A= {2,3,4,2,3,4,5};
		System.out.println(solution(A));
	}
}
