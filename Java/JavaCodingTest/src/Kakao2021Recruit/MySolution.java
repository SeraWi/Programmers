package Kakao2021Recruit;

import java.util.regex.Pattern;

//2021 카카오 Blind Recruitment
// 신규 아이디 추천
public class MySolution {
	//아이디의 길이는 3자 이상 15자 이하여야 합니다.
	//아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
	//단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.


	public static String solution(String new_id) {

		//1~7단계까지 거치면 신규 아이디를 만들고 최종으로 return한다

		// 1단계 대문자 -> 소문자로 바꾸기
		String answer = new_id;
		answer = new_id.toLowerCase();

		// 2단계 알파벳 소문자, 숫자, 빼기 밑줄, 마침표 외에 글자 제외하기
		// \\d : 숫자
		answer = answer.replaceAll("[^a-z\\d\\-_.]*", "");
		
		// 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
		while(answer.contains("..")) {
			answer = answer.replace("..", ".");
		}
		//4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
		if(answer.startsWith(".")) {
			// 처음 인덱스
			answer = answer.replaceFirst(".", "");
		}
		
		if(answer.endsWith(".")) {
			// 마지막 인덱스 .이면 앞에 까지 잘라내기
			answer = answer.substring(0, answer.length()-1);
				
		}
		//5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
		if(answer.length()==0) {
			answer ="a";
		}
		//6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
	    if(answer.length() >=16) {
	    	answer = answer.substring(0,15);
	    }
		// 만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
		if(answer.endsWith(".")) {
			// 마지막 인덱스
			answer = answer.substring(0, answer.length()-1);
		}
		
		//7단계 7단계 new_id의 길이가 2자 이하라면, 
		//new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
		
		if(answer.length() <=2) {
			while(answer.length() <3) {
				answer += answer.substring(answer.length()-1,answer.length());
			}
		}
		
		
		return answer;
	} // solution 함수 끝

	public static void main(String[] args) {
		//String id = "...!@BaT#*..y.abcdefghijklm";
		//String id="z-+.^.";
		String id="=.=";
		System.out.println(solution(id));
	}



}
