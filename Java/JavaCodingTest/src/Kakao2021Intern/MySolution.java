package Kakao2021Intern;

import java.util.HashMap;

// 2021 카카오 인턴쉽 문제(정답 통과)
public class MySolution {
	//네오와 프로도가 숫자놀이를 하고 있습니다. 네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 
	//프로도는 원래 숫자를 찾는 게임입니다.

	public static int solution(String s) {
		// String s -> 영문자를 숫자로 바꾸기
		int answer = 0;

		HashMap<String, String> numbers= new HashMap<>();
		numbers.put("zero","0");
		numbers.put("one","1");
		numbers.put("two","2");
		numbers.put("three","3");
		numbers.put("four","4");
		numbers.put("five","5");
		numbers.put("six","6");
		numbers.put("seven","7");
		numbers.put("eight","8");
		numbers.put("nine","9");

		for(String key :numbers.keySet()) {
			if(s.contains(key)) {
				//key값에 해당하는게 있으면 숫자로 치환시키기
				String value = numbers.get(key);
				s= s.replace(key, value);
			}
		}
		
		
		answer = Integer.parseInt(s);
		return answer;
		

	}
	
	public static void main(String[] args) {
		String s ="one4seveneight";
		System.out.println(solution(s));
	}
}
