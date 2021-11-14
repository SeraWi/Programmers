package StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MySolution {
	//프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 
	//각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
	//또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고, 
	//이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.
	//먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
	//각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

	public static ArrayList<Integer> solution(int[] progresses, int[] speeds) {
		// 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
		// 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
		// progresses : 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
		// speeds : 각 작업의 개발 속도가 적힌 정수 배열


		Queue<Integer> days = new LinkedList<>();

		for(int i=0; i< progresses.length; i++) {
			// 몇일 걸리는지 계산-> arraylist 에 추가
			days.add((int) Math.ceil((100-progresses[i])/speeds[i]));
		}
		
		int answer =0;
		ArrayList<Integer> answers = new ArrayList<>(); 
		
// 		while(days.size()>0) {
//			int first = days.poll();
//			answer++;
//			int second = days.peek();
//			
//			if(first> second) {
//				days.poll();
//				answer++;
//				answers.add(answer);
//			}
//			
//		}


		
		return answers;
	}

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int [] speeds = {1, 30, 5};

		System.out.println(solution(progresses, speeds));
	}
}
