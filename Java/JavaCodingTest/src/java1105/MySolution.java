package java1105;

import java.util.stream.IntStream;

//0부터 9까지의 숫자 중 일부가 들어있는 배열 numbers가 매개변수로 주어집니다. 
//numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
public class MySolution {
	public static int i =0;
	
    public static int solution(int[] numbers) {
    	
    	// numbers 길이 1~9, 모든 수는 0~9 사이
    	
    	//numbers 정렬하기
    	int answer =0;
    	
    	for( i = 0; i<10 ;i++) {
    		if(!IntStream.of(numbers).anyMatch(x ->x ==i)) {
    			//System.out.println(i+"는 없음!");
    			answer += i;
    		}
    	}
    	
        return answer;
    }
    
    public static void main(String[] args) {
    	int[]numbers = {1,2,3,4,6,7,8,0};
		System.out.println(solution(numbers));
	}

}
