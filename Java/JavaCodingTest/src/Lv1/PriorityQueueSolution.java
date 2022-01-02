package Lv1;

import java.util.PriorityQueue;

public class PriorityQueueSolution {
	public static int solution(int[] scoville, int K) {
		int answer =0;
		
		PriorityQueue<Integer> sco = new PriorityQueue<Integer>();
		
		
		// scoville에 있는 요소들 sco 에 add 하기
		for(int temp: scoville) {
			sco.add(temp);
		}
		
		// 가장 작은 수가 K보다 큰지만 확인 하면 된다.
		// 우선순위가 가장 높은 값을 확인하기 peek()
		
		int count =0;
		
		while(sco.peek() < K && sco.size() >1) {
			// 우선순위 가장 높은 값이 k보다 작으면 계속 섞기
			// 삭제 : 우선순위가 가장 높은 게 삭제된다. poll()
			
			int weakHot = sco.poll();
			int secondWeakHot = sco.poll();
			
			int mixHot = weakHot + (secondWeakHot *2);
			sco.add(mixHot);
			count++;
			
		}
		
		if(sco.size() <=1 && sco.peek() <K) {
			count =-1;
		}
		
		
		return count;
		
		
	}
	
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		System.out.println(solution(scoville, K));
	}
}
