package PriorityQueue;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;


public class PriorityQueueEx {
	// PriorityQueue
	// 우선순위가 가장 높은 데이터를 가장 먼저 삭제
	// 높은 우선순위의 요소를 먼저 꺼내서 처리하는 구조
	// 내부요소는 힙으로 구성되어 이진트리 구조로 이루어져있음
	// 내부구조가 힙으로 구성되어 있기에 시간 복잡는 O(NlogN)
	// 응급실과 같이 우선순위를 중요시해야 하는 상황에서 쓰임
	
	
	// 자료구조 : 스택, 큐, 우선순위큐
	// 스택: 가장 나중에 삽입된 데이터 추출
	// 큐:가장 먼저 삽입된 데이터 추출 
	//우선순위 큐 : 가장 우선순위가 높은 데이터 추출
	
	public static void main(String[] args) {
		
		// PriorityQueue 선언
		// int 형 priorityQueue선언 (우선 순위가 낮은 숫자 순)
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		
		// int 형 priorityQueue선언 (우선 순위가  높은숫자 순)
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
		
		// String 형 priorityQueue선언 (우선 순위가 낮은 숫자 순)
		PriorityQueue<String> pq3 = new PriorityQueue<>();
		
		// String 형 priorityQueue선언 (우선 순위가 높은 숫자 순)
		PriorityQueue<String> pq4 = new PriorityQueue<>(Collections.reverseOrder());
		
		pq1.add(1);
		pq1.add(15);
		pq1.add(10);
		pq1.add(21);
		pq1.add(25);
		pq1.add(18);
		pq1.add(8);
	
		
		System.out.println(pq1); //[1, 15, 8, 21, 25, 18, 10]
		
		// 삭제 : 우선순위가 가장 높은 게 삭제된다.
		pq1.poll();
		System.out.println(pq1);//[8, 15, 10, 21, 25, 18]
		pq1.poll();
		System.out.println(pq1);//[10, 15, 18, 21, 25]
		
		//priority queue 크기
		
		System.out.println(pq1.size()); // 5
		
		// 출력하기
		Iterator iterator = pq1.iterator(); 
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		
		pq2.add(1);
		pq2.add(15);
		pq2.add(10);
		pq2.add(21);
		pq2.add(25);
		pq2.add(18);
		pq2.add(8);
		System.out.println(pq2);//[25, 21, 18, 1, 15, 10, 8]
		
		pq2.poll();
		System.out.println(pq2); //[21, 15, 18, 1, 8, 10]

		
	}
	
	
	

}
