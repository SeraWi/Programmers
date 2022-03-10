package L6_Sorting;

import java.util.Arrays;

//Your goal is to find the maximal product of any triplet.
public class MaxProduct {
	
	// 부분집합을 구하지 않고 정렬로 구현할 수 있다.
	
	//O(N * log(N))
	public int solution(int[] A) {
        // write your code in Java SE 8
		
		Arrays.sort(A);// 오름차순 정렬
		// 가장 큰 수 3개 곱한값
		int n = A[A.length-1] * A[A.length-2] * A[A.length-3];
		// 가장 작은 수 두개 곱하면 : 양수로 바꿀 수 있다. * 가장 큰수
		int m = A[0] * A[1] * A[A.length-1];
		
		return Math.max(n, m);
    }
}
