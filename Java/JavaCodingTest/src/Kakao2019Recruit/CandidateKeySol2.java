package Kakao2019Recruit;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


//문제풀이에 필요한 개념 : Bitmask -2진법
// 컬럼들로 만들 수 있는 조합을 비트마스킹으로 만든다
//& 비트 연산자로 포함관계를 파악할 수 있다.
// int 1 = 0001
// int 3 = 0011
// 0001 &0011 = 0001 = 1  3은 1을 포함한다.
// 각 컬럼을 하나의 비트로 매기고
// 예를들어 학번 1000, 이름 0100, 전공 0010, 학년 0001로 매기고
// 경우의 수를 학번, 이름== 1100, 학번 전공 == 1010 이런식으로 만든다
// 그리고 일단 유일성을 체크하고, 유일성을 만족하지 않는다면, 
// 예를들어 전공0010이 유일성을 만족하지 않는다면, 전공을 포함한 모든 경우의 수는 and연산으로 확인해서 제거한다.


public class CandidateKeySol2 {
	//유일성을 체크하는 메서드
	// subset이 1~16(컬ㄻ수가4일떄)중에서 이번차례의 경우의 수를 가져온다.
	boolean check(String[][]relation, int row_num, int col_num,int subset) {
		
		for( int i=0; i<row_num-1; i++) {
			for(int j= i+1; j<row_num; j++) {
				boolean isSame = true;
				for( int  k=0; k<col_num; k++) {
					if((subset & (1<<k)) == 0) {
						//이번 경우의 수가 아니면 넘어간다
						continue;
					}
					//다른 로우와 일치하면 이 경우의 수는 유일성을 만족하지 못한다.
					if(!relation[i][k].equals(relation[j][k])) {
						isSame = false;
						break;
					}
				}
			}
		}
		
		
		return true; //유일성만족하면 true반환
	}
	public int solution(String[][]relation) {
		int answer =0;
		
		int row_num = relation.length;
		int column_num = relation[0].length;
		
		
		List<Integer> candidates = new LinkedList<Integer>();
		
		//모든 경우의 수로 유일성을 체크한다
		//					컬럼으로 만들 수 있는 조합을 비트마스킹으로 표현
		for( int i=1; i<(1<<column_num); i++) {
			if(check(relation, row_num, column_num, i)) {
				//유일성 만족하면 list에 넣는다.
				candidates.add(i);
			}
			
		}
		
		
		//list에 들어 있는 유일성 체크를 통과한 경우의 수들 -> 최소성 체크하기
		while(candidates.size()!=0) { //리스트에서 하나씩 꺼내면서 최소성을 확인한다.
			int n= candidates.remove(0); // 꺼내고 삭제
			answer++;
			
			for(Iterator<Integer>it =candidates.iterator(); it.hasNext();) {
				
				//현재 선택된 경우의 수 n과 다른 모든 경우의 수 c를 and연산한다
				
				int c = it.next();
				
				//c가 n을 포함한 경우는 c는 최소성을 만족하지 못하기 때문에 list에서 제거한다
				// ex n= 0001, c =0101일때, 0001 & 0101 = 0001 최소성을 만족하지 못한다.
				if((n &c)== n) {
					it.remove();
				}
			}
			
			
		}
		
		
		
		
		
		return answer;
		
	}
}

