package L3_TimeComplexity;

import java.util.Arrays;

//Write an efficient algorithm 
//for the following assumptions:
public class PermMissingElem {

	//정확성떨어짐
	public int solution(int[] A) {
		int ans =0;

		Arrays.sort(A);//오름차순 정렬
		if(A.length == 1) {
			return 1;
		}


		for( int i = 0;i<A.length; i++) {
			if(i+1 !=A[i]) {
				return i+1;
			}
		}

		return ans;
	}
	
	
	//O(N) or O(N * log(N))
	public int solution2(int[]A) {
		int answer = 0;
		boolean[] contains = new boolean[A.length+2];
		for( int a: A) {
			contains[a] = true;
		}
		
		for( int i = 1;i<contains.length ; i++) {
			if(!contains[i]) {
				answer = i;
				break;
			}
		}
		
		return answer;

	}

	public static void main(String[] args) {
		int[]A = {1,2,3,5};
	}
}
