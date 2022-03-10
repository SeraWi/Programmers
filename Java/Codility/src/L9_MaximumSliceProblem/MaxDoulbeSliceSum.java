package L9_MaximumSliceProblem;

public class MaxDoulbeSliceSum {
	// given a non-empty array A consisting of N integers, 
	//returns the maximal sum of any double slice.
    public int solution(int[] A) {
        // write your code in Java SE 8
    	int N = A.length;
    	
    	if(N == 3 || N == 0) {
    		return 0;
    	}
    	int headSum = A[0];
    	int tailSum =0;
    	
    	for( int i= 1 ; i< N-1 ; i++ ) {
    		headSum = Math.max(headSum, headSum + A[i]);
    	}
    	
    	for( int i = N-2; i >=1 ; i--) {
    		tailSum = Math.max(tailSum, tailSum +A[i]);
    	}
    	
    	return 0;
    	
    	
    }
    
    //O(N)
    public static int solution2(int[]A) {    	int[] s = new int [A.length];// start
    	int[] e = new int [A.length]; // end
    	
    	//head 를 저장
    	for( int i = 1; i<A.length -1 ; i++) {
    		s[i] = Math.max(A[i], s[i-1] +A[i]);
    		if(s[i] <0) {
    			s[i] = 0;
    		}
    	}
    	
    	//end 를 저장
    	for( int i= A.length-2 ; i> 0; i--) {
    		e[i] = Math.max(A[i], e[i+1] +A[i]);
    		if(e[i] <0) {
    			e[i] = 0;
    		}
    	}
    	// s = 0,2,8,7,11,16,0,0
    	// e = 0,16,14,8,9,5,-1,0
    	
    	int max =0;
    	
    	// max 구하기
    	for(int i =1; i< A.length-2; i++) {
    		max= Math.max(s[i-1] + e[i+1], max);
    		
    	}
    	return max;
    }
    
    public static void main(String[] args) {
		int A [] = {3,2,6,-1,4,5,-1,2};
		int B[] = {5, 17, 0, 3};
		int C[] = {0,10,-2,-5,0};
		System.out.println(solution2(C));
	}
}
