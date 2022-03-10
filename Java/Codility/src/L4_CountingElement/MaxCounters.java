package L4_CountingElement;

public class MaxCounters {
	public int[] solution(int N, int[] A) {
		// write your code in Java SE 8
		
		int[] answer = new int[N];
		int base =0;
		int max =0;
		
		for( int i= 0; i<A.length; i++) {
			if(A[i] >=1 && A[i] <= N) {
				if(answer[A[i]-1] <base) {
					answer[A[i] -1]= base;
				}
				
				if(++answer[A[i]-1] > max) {
					max = answer [A[i] -1];
				}
			}else if(A[i] == N+1) {
				base = max;
			}
		}
		
		for( int  i = 0; i<answer.length; i++) {
			if(answer[i] <base) {
				answer[i] = base;
			}
		}
		return answer;
	}
}
