package L9_MaximumSliceProblem;

public class MaxSliceSum {
	//that, given an array A consisting of N integers, returns the maximum sum of any slice of A.
	//카데인 알고리즘
	public static int solution(int[] A) {
        // write your code in Java SE 8
		if(A.length ==1) {
			return A[0];
		}
		
		int localMaxSum = A[0];
		int globalMaxSum = A[0];
		
		for( int i = 1; i<A.length ; i++) {
			localMaxSum = Math.max(A[i], localMaxSum+A[i]);
			globalMaxSum =Math.max(globalMaxSum, localMaxSum);
		}
		
		return globalMaxSum;
    }
	
	public static void main(String[] args) {
		int A[] = new int[] {3,2,-6,4,0};
		System.out.println(solution(A));
	}
}
