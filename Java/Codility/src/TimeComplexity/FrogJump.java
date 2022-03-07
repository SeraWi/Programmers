package TimeComplexity;

import java.util.Arrays;

// Time Complexity : O(Y-X)
public class FrogJump {
	
	//frogJump 내풀이 , 효율성 탈락
	public int solution(int X, int Y, int D) {
        
		int answer = 0;
		
		while(X<Y) {
			X +=D;
			answer++;
		}
		
		return answer;
    }
	
	//frogjump 참조 풀이
	public int solution2(int X, int Y, int D) {
        
		int answer = 0;
		
		if(X==Y) {
			return 0;
		}
		
		return (Y-X)%D == 0? (Y-X)/D : (Y-X)/D +1;
    }
	
	public int solution2(int[] A) {
        // write your code in Java SE 8
		
		int answer =0;
		//A를 오름차순으로 정렬 시켜
				
		Arrays.sort(A);
		if(A.length == 0) {
			answer = 0;
		}
		
		for(int i = 0; i<A.length; i++) {
			if(A[i] != i+1) {
				answer = i+1;
			}
		}
		
		return answer;
		
    }

}
