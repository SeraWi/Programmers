package Kakao2019Recruit;

import java.util.ArrayList;
import java.util.List;

public class CandidateKey {
	// int = 4bytes = 32 bits 1byte = 8bit
	
	// n<<i의 의미 : n 숫자의 비트를 좌측으로 i만큼 이동시킨다.
	
	public static int solution(String[][] relation) {
		int answer = 0;
		
		int n = relation.length; //가로
		int m = relation[0].length; //세로
		
		List<Integer> list =new ArrayList<Integer>();
		
		
		
		
		
		return answer;
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
