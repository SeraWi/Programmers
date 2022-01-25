package CodingTest;

import java.util.ArrayList;
import java.util.List;

public class NewBracket {
	public int solution(String s) {
		int answer = 0;
		List<String> sList = new ArrayList<>();
		
		for( int i = 0; i<s.length(); i++) {
			sList.add(s.substring(i, i+1));
		}
		
		
		return answer;
	}
	
	
	
}
