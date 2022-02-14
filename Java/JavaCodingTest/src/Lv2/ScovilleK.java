package Lv2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/*scoville의 길이는 2 이상 1,000,000 이하입니다.
K는 0 이상 1,000,000,000 이하입니다.
scoville의 원소는 각각 0 이상 1,000,000 이하입니다.
모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
섞은 음식의 스코빌 지수 = 
가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
*/

public class ScovilleK {
	
	public static int solution(int[] scoville, int k) {
		
		PriorityQueue<Integer> q = new  PriorityQueue<Integer>();
		
		for( int s : scoville) {
			q.offer(s);
		}
			
		int cnt = 0;
		while(q.peek() < k  && q.size()>1) {
			int first = q.poll();
			int second = q.poll();
			
			q.offer(first + second *2);
			cnt ++;
			
		}
		
		
		if(q.size()== 1 && q.peek() < k) {
			cnt = -1;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int k = 7;
		System.out.println(solution(scoville, 7));
	}
}
