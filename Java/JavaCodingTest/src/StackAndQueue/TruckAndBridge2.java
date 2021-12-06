package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;


public class TruckAndBridge2 {

	//트럭 클래스 만들기
	class Truck{
		int weight;
		int move;

		//생성자 초기화
		public Truck(int weight) {
			this.weight = weight;
			this.move= 1;
		}
		
		//moving 함수
		public void moving() {
			move++;
		}
	}


	public int solution(int bridge_length, int weight, int[] truck_weights) {
		//대기중이 트럭
		Queue<Truck> waitQ = new LinkedList<>();
		// 다리위에 건너는 중인 트럭
		Queue<Truck> moveQ = new LinkedList<>();
		
		
		//큐에 저장
		for ( int t : truck_weights) {
			waitQ.offer(new Truck(t));
		}

		int answer =0;
		int curWeight = 0;
		
		//대기 트럭이 존재거나, 다리 위 트럭이 존재할 때 계속 반복
		while(!waitQ.isEmpty()|| !moveQ.isEmpty()) {
			//while이 한번 실행될때 1초 경과
			
			answer ++;

			if(moveQ.isEmpty()) {
				//다리위에 트럭이 없으면, 대기 트럭 꺼내서 넣기
				Truck t = waitQ.poll();
				//다리 위의 무게 
				curWeight +=t.weight;
				moveQ.offer(t);
				
			}
			
			// 1초지나면 1칸씩 움직이기
			for(Truck t : moveQ) {
				//다리 위에 있는 트럭 들 모두 1칸씩 움직이기
				t.moving();
			}
			
			// 움직이고 나서 다리를 탈출시키기
			if(moveQ.peek().move > bridge_length) {
				// 다리 길이 보다 move의 값이 커지면
				// 다리 위에 있는 트럭빼내기
				Truck t = moveQ.poll();
				//다리 위 무게 줄어든다
				curWeight -= t.weight;
				
			}
			
			// 대기 트럭이 남아있고       현재 무게에 다음트럭을 더한 값이 하중을 견딜 수 있으면
			if(!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
				//트럭 빼내기
				Truck t = waitQ.poll();
				curWeight += t.weight;
				
				//다리 위 큐에 추가하기
				moveQ.offer(t);
						
			}
			
		}

		return answer;
	}
	
}
