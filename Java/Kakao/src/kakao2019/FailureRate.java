package kakao2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FailureRate {
	
	static Comparator<Fail>comp = new Comparator<Fail>() {
		public int compare(Fail a,Fail b) {
			if(a.rate<b.rate) {
				return 1;
			}else if(a.rate > b.rate) {
				return -1;
				
			}else {
				//같은 경우 스테이지 넘버 작은거 먼저 정렬
				if(a.stage > b.stage) {
					return 1;
				}else if(a.stage< b.stage) {
					return -1;
				}else {
					return 0;
				}
			}
		}
	};
	
	
	public static int[] solution(int N, int[] stages) {
		
		
		int[] answer = new int[N];
		
		List<Fail> fails = new ArrayList<Fail>();
		int total = stages.length; // 사람 수
		
		int[] users = new int[N+1]; // 각 스테이지에 도달한 사람 , idx 가 곧 스테이지 넘버
		for(int s: stages) {
			// s가 2이면 1단계까지만 도달한거임, 2단계에서 실패함
			users[s-1] ++; 
		}
		for(int i =0; i<N; i++) {
			if(users[i] ==0) {
				// 첫단계 모두 탈락한 경우
				fails.add(new Fail(i+1, 0));
			}else{
				//users[1] == 1단계에 도달한 사람 2단계 실패
				fails.add(new Fail(i+1, (double)users[i]/total));
				total -= users[i];
			}
		}
		// 실패율 큰 순서로 정렬
		Collections.sort(fails, comp);
		for( int i = 0; i<N; i++) {
			answer[i] = fails.get(i).stage;
		}
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2,1,2,6,2,4,3,3};
		int [] answer = solution(N, stages);
		
		for( int a : answer) {
			System.out.print(a +",");
		}
		
	}
}

class Fail{
	int stage;
	double rate;
	
	
	Fail(int stage, double rate){
		this.stage = stage;
		this.rate = rate;
	}
}
