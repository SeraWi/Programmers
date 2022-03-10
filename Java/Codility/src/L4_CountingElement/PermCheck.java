package L4_CountingElement;

import java.util.Arrays;

//O(N) or O(N * log(N))
public class PermCheck {
	
	public int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 1;
		
		boolean[] contains =new boolean[A.length+1];
		
		for( int i = 0; i<A.length; i++) {
			int number = A[i];
			
			if(number <= A.length && !contains[number]) {
				// 해당 값을 인덱스로해서 true 넣기
				contains[number] =true;
			}
		}
		
		for(int i= 1;i <contains.length ;i++) {
			//false 인경우 permutation 이 아님
			if(!contains[i]) {
				return 0;
			}
		}
		
		
		return answer;
    }
	
	
	public static void main(String[] args) {
		
		
	}
}
