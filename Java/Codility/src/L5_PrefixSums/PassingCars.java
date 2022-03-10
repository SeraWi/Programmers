package L5_PrefixSums;

public class PassingCars {
//0 represents a car traveling east,
// 1 represents a car traveling west.
	
	//time out error O(N*N)
	public int solution(int[] A) {
        // write your code in Java SE 8
		int answer = 0;
		
		for( int i = 0; i<A.length-1; i++) {
			// 0== east 일경우만
			if(A[i] == 0) {
				for( int j =i+1; j<A.length ; j++) {
					if(A[j] == 1) {
						answer++;
					}
				}
			}
			
		}
		if(answer > 100000000) {
			return -1;
		}
		return answer;
    }
	//참고 풀이 O(N)
	public int solution2(int[]A) {
		int count = 0;
		int incrementVal = 0;
		
		
		for( int  i = 0; i<A.length ; i++) {
			//east 찾으면 
			if(A[i] == 0) {
				incrementVal++;
			}else {
				count += incrementVal;
			}
		}
		if(count>1000000000) {
			return -1;
		}
		
		return count;
				
	}
}
