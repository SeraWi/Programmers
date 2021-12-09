package Lv2;

import java.util.Arrays;

//정답 통과
public class H_Index {
	
	
    public static int solution(int[] citations) {
        int answer = 0;
        
        // 오름 차순 정렬
        Arrays.sort(citations);
        
        
        for( int i = 0; i<citations.length; i++) {
        	int currentCite = citations[i];
        	// 현재 논문의 인용횟수 보다 남은 갯수가 많거나 같을때
        	if(currentCite >= citations.length- i) {
        		answer = citations.length-i;
        		break;
        	}
        	
        	
        }
        
        return answer;
        
    }
    
    
    public static void main(String[] args) {
    	int[] citations = {31,66};
    	//int [] citations = {2,3,1,0,5,6,7,2};
		System.out.println(solution(citations));
	}
}
