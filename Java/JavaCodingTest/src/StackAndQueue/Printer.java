package StackAndQueue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer {
//	현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
//	인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
//	location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 
//대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
	public static int solution(int[] priorities, int location) {
		int answer =0;
		int l = location ;
		
		
		//queue : fifo구조임
		Queue<Integer> que= new LinkedList<Integer>();
		for(int i: priorities) {
			que.add(i);
		}
		// 오름차순 정렬하기
		Arrays.sort(priorities);
		int size = priorities.length-1;
		
		while(!que.isEmpty()) {
			//가장 먼저 들어온거 빼내기
			
			Integer i = que.poll();
			
			if( i== priorities[size-answer]) {
				answer ++;
				l--;
				if(l < 0) {
					break;
				}
			}else {
				// 빼낸 값을 뒤로 다시 삽입하기
				que.add(i);
				l--;
				if(l <0) {
					l= que.size()-1;
				}
	
			}
		}
		
		return answer;
	}
	
	
	//우선순위 큐 사용법
	public static int solution2(int[] priorities, int location) {
		int answer =1;
		PriorityQueue p = new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int i=0;i<priorities.length ; i++) {
			p.add(priorities[i]);
			//System.out.println(p);
		}
		//System.out.println(p);	
			
		while(!p.isEmpty()) {
			// p의 원소들이 없어질때까지 반복
			
			// priorities의 갯수만큼 돌리면서 뽑아내기
			for(int i =0; i<priorities.length;i++) {
				System.out.println("i : " + i );
				if(priorities[i] == (int) p.peek()) {
					if( i == location) {
						// 최댓값이 현재 location과 같다
						System.out.println(answer);
						return answer; // 메서드 전체 종료
					}
					// 최댓값 꺼내기
					p.poll();
					System.out.println(p);
					answer ++;
					System.out.println(answer);
				}
			}
		}
		
		
		return answer;
	}
	
	public static int solution3(int [] priorities, int location) {
		int answer  =0;
		
		PriorityQueue<Integer>  pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		Queue<value> q = new LinkedList<>();
		
		for( int i =0; i<priorities.length; i++) {
			pq.add(priorities[i]); //우선순위큐에 담기
			q.add(new value(i, priorities[i])); // 일반 queue에 인스턴스를 담기
			
		}
		
		while(!q.isEmpty()) {
			//queue가 빌때까지 반복
			
			int prior = pq.peek().intValue(); //우선순위가 가장높은거 꺼내기
			pq.poll();
			
			
			int n ;
			while(true) {
				n = q.peek().x ; //원소의 순서 저장 ==index
				int nPrior = q.peek().y; // 중요도
				q.poll();
				
				if(nPrior == prior) {// 우선순위큐의 중요도와 같다면 break;
					break;
				}
				
				q.add(new value(n, nPrior)); //중요도 같지 않으면 q에 다시 삽입
				
			}
			
			answer ++;
			
			if(n == location) {
				break;
			}
			
			
		}
		System.out.println(answer);
		
		return answer;
	}
	
	
	public static void main(String[] args) {
		//int[] priorities = {1, 1, 9, 1, 1, 1};
		
		int[] priorities = {2, 1, 3, 2};
		//System.out.println(solution(priorities, 2));
		//System.out.println(solution2(priorities, 0));
		System.out.println(solution3(priorities, 2));
	}
}

class value{//클래스를 만들어서 !><
	int x;
	int y;
	
	public value(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}
