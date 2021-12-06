package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckAndBridge {
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		// bridge_length 다리길이
		// weight  견딜 수 있는 무게
		// truck_weight : 트럭 무게
		
		int spendTime = weight;
		Queue<Integer> truckQueue = new LinkedList<>();
		Queue<Integer> bridgeQueue = new LinkedList<>();
		
		
		// truckQueue에 truck 넣기
		for( int i = 0 ; i < truck_weights.length; i++) {
			truckQueue.add(truck_weights[i]);
		}
		//초기 bridge에 세팅해주기
		for( int i = 0; i<bridge_length ; i++) {
			bridgeQueue.offer(0);
		}
		
		int time = 0;
		int totalWeight = 0;
		
		//bridgequeue가 빌때까지 반복
		while(!bridgeQueue.isEmpty()) {
			
			//while한번 돌면 1초경과
			totalWeight -=bridgeQueue.peek();
			//브릿지에 있는 숫자 제거
			bridgeQueue.poll();
			
			//트럭큐가 비어이있는지
			if(truckQueue.isEmpty()) {
				//즉 브릿지에는 트럭이 있는데 트럭큐에는 트럭이 다 나감
				//그러면 마지막 트럭이 다리를 건너는 중
				//다리 길이 만큼 더해주고 while문 탈출
				
				time+=bridge_length;
				break;
			}else {
				// 하중을 견딜 수 있으면 트럭 추가하기
				if(totalWeight + truckQueue.peek() <= weight) {
					bridgeQueue.offer(truckQueue.peek());
					totalWeight += truckQueue.peek();
					truckQueue.poll();
				}else {
					// 더할 트럭이 없으면 0을 넣어준다
					bridgeQueue.offer(0);
				}
			}
			time++;
		}
		answer = time;
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] truck_weight = {7,4,5,6};
		System.out.println(solution(2,10, truck_weight));
	}
}
