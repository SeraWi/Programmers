package Kakao2020Recruit;

import java.util.ArrayList;

// 2020 카카오 blind recruitment  : 문자열 압축 문제(실패)
public class StringManipulation {
	public static int solution(String s) {
		int minimum = s.length();
		
		ArrayList<String> results = new ArrayList<>();
		
		for(int i= 1 ; i< (s.length()/2)+1; i++){
			int  cnt =0;
			String answer ="";
			
			for(int j= 0; j< s.length(); j=j+i) {
				// Index Out of Bounds EXception 해결해야
					String before = s.substring(j, j+i); // 0,2
					String after = s.substring(j+i, j+i+i); // 2, 4
				if( !before.equals(after)) {
					if (cnt > 0) {
						answer += ""+(cnt+1) + s.substring(j,j+i);
					}else {
						answer += s.substring(j, j+i);
					}
				}else {
					// 같을 때
					cnt +=1;
				}
				
				System.out.println(answer);
			}// 안쪽 for
			
			results.add(answer); // 압축된거 저장시키기
			
		}// 바깥 for
		
		for ( int i = 0; i< results.size(); i++) {
			if(results.get(i).length() < minimum && results.get(i).length() != 0) {
				minimum = results.get(i).length();
			}
		}
		
		return minimum;
	}
	
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
	}
}
