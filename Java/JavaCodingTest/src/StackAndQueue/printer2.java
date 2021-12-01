package StackAndQueue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

// 시간 초과 걸림
public class printer2 {
	// priority queue 사용하기
	// priorities 를 pq와 일반 queue에 동시에 담기
	
	public int solution(int[] priorities, int location) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();
        
        
        //우선순위 큐에 저장
        for(int p : priorities) {
        	pq.add(p);
        }
        
        // index 저장
        for( int i=0; i<priorities.length; i++) {
        	q.offer(i);
        }
        
        int result =1;
        
        // q가 다 없어질 때까지 반복
        while(!q.isEmpty()) {
        	int originIndex = q.poll(); //remove 하고 return
        	int originValue = priorities[originIndex];
        	int maxValue = pq.peek(); //가장 큰수가 나옴, does not remove
        	
        	if(originValue < maxValue) {
        		//우선순위가 낮다면
        		q.offer(originIndex); //다시 뒤쪽에 추가한다.
        		
        	}else if(originValue == maxValue) {
        		//가장 높은 우선순위일 경우
        		
        		if(originIndex == location) {
        			//내가 요청한 인쇄일 경우
        			return result;
        		}else {
        			q.remove();// remove head of the queue
        			result++;
        		}
        	}
        }
        
        return result;
      
    }
}
