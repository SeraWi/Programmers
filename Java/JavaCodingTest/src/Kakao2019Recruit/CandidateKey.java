package Kakao2019Recruit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CandidateKey {
	// int = 4bytes = 32 bits 1byte = 8bit
	
	// n<<i의 의미 : n 숫자의 비트를 좌측으로 i만큼 이동시킨다.
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
			
			for(int j=0;j<n; j++) {
				String now ="";
				for( int k=0; k<m;k++) {
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
