package L6_Sorting;

import java.util.Arrays;

public class Triangle {
	//O(N*log(N))
	//triangle 있으면 1반환, 없으면 0반환
    public int solution(int[] A) {
        // write your code in Java SE 8
    	
    	//인덱스 순서가 중요하지 않다!
    	if(A.length <3 ) {
    		return 0;
    	}
    	
    	Arrays.sort(A);
    	for( int i = 0; i<A.length-2;i++) {
    		if((long)A[i] +A[i+1] > A[i+2]) { 
    			//오버플로우 발생 가능성 ->long 타입으로 막기 
    			return 1;
    		}
    	}
    	return 0;
    	
    }
	public static void main(String[] args) {
		System.out.println(new Triangle().solution(new int[]{10,2,5,1,8,20}));
	}
}
