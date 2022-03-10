package L8_Leader;

import java.util.HashMap;
import java.util.Map;
//The leader of this array is the value that occurs in more than half of the elements of A.
//len의 절반 이상인 수를 leader라고 한다.
//leader는 딱 하나임

//O(N)
//모든 부분집합을 구하지 않고도 풀 수 있음
public class EquiLeader {
	
	private int dominator; //dominator
	private int dominatorCount; //카운트 숫자 세기
	
	public int solution(int[] A) {
		// write your code in Java SE 8

		Map<Integer, Integer> counters = new HashMap<>();

		for( int i = 0; i<A.length; i++) {
			int a = A[i];
			if(!counters.containsKey(a)) {
				//새로 추가한다.
				counters.put(a, 1);
			}else {
				// 기존에 있으면 count 증가
				counters.put(a,counters.get(a)+1);
			}

			if(counters.get(a) > A.length/2) {
				//dominator임
				dominator = a; //dominator save
				dominatorCount = counters.get(a);//몇번 카운트인지
			}
		}
		
		int equiLeaders = 0; //equiLeaders 상황이 나오는 경우의 수를 카운트 후 return 
		// 최초에는 (원소 없음,원소전체)이런식으로 설정
		int leadersInRightSide =dominatorCount;
		int countRightSide = A.length;
		int countLeftSide = 0;
		int leadersInLeftSide = 0;
		
		for( int i =0; i<A.length; i++) {
			if(A[i] == dominator) {
				//원소 돌아가며 dominator인지확인
				leadersInRightSide --; //있으면 오른편에 있는걸 왼편으로 넘기기
				leadersInLeftSide++;
				
			}
			// dominator이던 아니던 상관 없이
			countLeftSide ++; // 한번 loop이 돌때마다 왼쪽편으로 원소를 하나씩 보낸다.
			countRightSide--;
			
			// 
			if(leadersInLeftSide > countLeftSide /2) {
				if(leadersInRightSide > countRightSide /2) {
					equiLeaders++;
				}
			}
		}
		
		return equiLeaders;

	}
	public static void main(String[] args) {
		int[] A = {4,3,4,4,4,2};
		System.out.println(new EquiLeader().solution(A));
	}
}
