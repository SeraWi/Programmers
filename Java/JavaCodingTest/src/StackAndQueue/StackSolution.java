package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class StackSolution {
	public static int[]solution(int[] progresses, int[] speeds){
		// Queue : FIFO 구조, 제일 먼저 저장한 것을 제일 먼저 꺼낸다
		// Stack : LIFO 구조 , 마지막에 저장된 것을 제일 먼저 꺼낸다.
		Queue<Integer> q = new LinkedList<>();
		List<Integer> answerList = new ArrayList<>();
		
		for(int i =0; i<speeds.length ; i++) {
			double remain = (100-progresses[i])/ (double) speeds[i];
			// 완료까지 걸리는 일수
			int date = (int) Math.ceil(remain);
			
			if(!q.isEmpty() && q.peek() <date) {
				// peek() 삭제없이 요소 읽어온다, 없으면 null  반환
				// poll() queue 에서 객체를 꺼내서 반환, 비어있으면 null반환
				// isEmpty()
				// q가 비어있지 않고 첫번째 꺼낸 date가 현재 작업의 date 보다 작다면
				// 1,2
				
				answerList.add(q.size());
				// q 비우기
				q.clear();
				
				
			}
			// 완료일 저장
			q.offer(date);
			
		}
		
		answerList.add(q.size());
		
		int[] answer  = new int[answerList.size()];
		
		for(int i=0; i<answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		
		
		return answer;
	}
	
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int [] speeds = {1, 30, 5};

		int[] answer =solution(progresses, speeds);
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
