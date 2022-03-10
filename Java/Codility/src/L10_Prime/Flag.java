package L10_Prime;

import java.util.ArrayList;
import java.util.List;
//returns the maximum number of flags that can be set on the peaks of the array.
//1. peak P와 Q사이의 거리(배열 A에서 index)가 챙겨간 깃발의 갯수보다 크거나 같아야 깃발을 꽂을 수 있다.
//2. 이 때, 배열 A의 peak에 꽂을 수 있는 가장 큰 깃발의 수를 구하면 된다.
public class Flag {
	//O(N) : for 안에 while이 들어있어도 O(N)
    public int solution(int[] A) {
        // write your code in Java SE 8
    	//peaks만 담는 list
    	List<Integer> peaks = new ArrayList<>();
    	for( int i =1; i<A.length-1; i++) {
    		if(A[i-1] <A[i]) {
    			if(A[i] > A[i+1]) {
    				peaks.add(i);
    			}
    		}
    	}
    	
    	if(peaks.size() <=1) {
    		return peaks.size();
    	}
    	//최대 꽂을 수 있는 깃발 수
    	int maxFlags = (int)Math.ceil(Math.sqrt(peaks.get(peaks.size()-1)-peaks.get(0)));
    
    	for(int flags = maxFlags ; flags > 1 ; flags--) {
    		int startIndex = 0;
    		int endIndex = peaks.size()-1;
    		
    		int startFlag = peaks.get(startIndex);
    		int endFlag = peaks.get(endIndex);
    		
    		int flagsPlaced = 2;
    		
    		while(startIndex < endIndex) {
    			startIndex ++;
    			endIndex--;
    			
    			if(peaks.get(startIndex)>= startFlag + flags) {
    				
    				if(peaks.get(startIndex) <= endFlag-flags) {
    					flagsPlaced ++;
        				startFlag = peaks.get(startIndex);
    				}
    				
    			}
    			
    			if(peaks.get(endIndex) >= startFlag +flags) {
    				if(peaks.get(endIndex) <= endFlag-flags) {
    					flagsPlaced ++;
        				endFlag = peaks.get(endIndex);
    				}
    				
    			}
    			if(flagsPlaced == flags) {
    				return flags;
    			}
    			
    		}
    				
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
    	int[] A = {1,5,3,4,3,4,1,2,3,4,6,2};
		System.out.println(new Flag().solution(A));
	}
}
