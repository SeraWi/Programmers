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
    public int solution2(int[] citations) {
    	Arrays.sort(citations);
    	
    	int max =0;
    	//정렬을 뒤에서 부터 본다.
    	//원소값 이상인 것의 개수는 점점 감소한다. 변화가 증가하다가 감소하는 지점을 찾으면 답이 된다.
    	for ( int i= citations.length-1; i> -1; i--) {
    		int min = (int) Math.min(citations[i], citations.length-i);
    		if(max< min) {
    			max= min;
    		}
    	}
    	
    	return max;
    }
    
    public static void main(String[] args) {
    	int[] citations = {31,66};
    	//int [] citations = {2,3,1,0,5,6,7,2};
		System.out.println(solution(citations));
	}
}
