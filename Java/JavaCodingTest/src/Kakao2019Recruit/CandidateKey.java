package Kakao2019Recruit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/*relation은 2차원 문자열 배열이다.
relation의 컬럼(column)의 길이는 1 이상 8 이하이며, 각각의 컬럼은 릴레이션의 속성을 나타낸다.
relation의 로우(row)의 길이는 1 이상 20 이하이며, 각각의 로우는 릴레이션의 튜플을 나타낸다.
relation의 모든 문자열의 길이는 1 이상 8 이하이며, 알파벳 소문자와 숫자로만 이루어져 있다.
relation의 모든 튜플은 유일하게 식별 가능하다.(즉, 중복되는 튜플은 없다.)
*/

// 후보키 갯수를 return하기
// 후보키: 유일성 + 최소성
// bit를 사용해서, 각 attributem colum과 비교하여 후보키를 찾는다
// 예를들어
// 0001(1) : 학번
// 0010(2) : 이름 / 0011(3) : 학번, 이름 0100(4) :전공 이런식으로!


public class CandidateKey {
	// int = 4bytes = 32 bits 1byte = 8bit
	
	// n<<i의 의미 : n 숫자의 비트를 좌측으로 i만큼 이동시킨다.
	// 유일성을 체크하는 메서드
	private static boolean possi(List<Integer> list, int now) {
		for( int i=0; i<list.size(); i++) {
			if((list.get(i) &now) == list.get(i)) {
				return false;
			}
		}
		return true;
	}
	public static int solution(String[][] relation) {
		int answer = 0;
		
		int n = relation.length; //가로
		int m = relation[0].length; //세로
		
		List<Integer> list =new ArrayList<Integer>();
		// 세로 길이 만큼 비트연산으로 밀기 1000000
		for(int i=1; i<(1<<m); i++) {
			//set :중복 허용 불가
			Set<String> s= new HashSet<String>();
			
			// 컬럼 갯수만큼 for문 돌리기
			for(int j=0;j<n; j++) {
				String now ="";
				// 행 갯수만큼 for문 돌리기
				for( int k=0; k<m;k++) {
					// 컬럼 인덱스와, 1을 행만큼 shift시킨 bit와 and 연산
					// 0이면??, 0이 아니면??
					if((i & (1<<k))>0) {
						now += relation[j][k];
					}
				}
				s.add(now);
			}
			
			if(s.size()== n && possi(list, i)) {
				list.add(i);
			}
		}
		
		
		
		
		return list.size();
	}
	public static void main(String[] args) {
		String[][] relation = {

				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","4"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}

		};
		System.out.println(solution(relation));
	}
}
