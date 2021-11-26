package Lv1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

// 수포자 3명이 1번부터 마지막 문제까지 찍는다
// 1번은 1,2,3,4,5
// 2번은 2,1,2,3,2,4,2,5
// 3번ㅇㄴ 3,3,1,1,2,2,4,4,5,5
public class TestAnswer {
	
	static int[] number1 = {1,2,3,4,5};
	static int[] number2 = {2,1,2,3,2,4,2,5};
	static int[] number3 = {3,3,1,1,2,2,4,4,5,5};
	
	 public static int[] solution(int[] answers) {
		 //가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	        int[] answer = {};
	        
	        HashMap<Integer, Integer> map = new HashMap<>();
	        //int cnt = 0;
	        map.put(1,count(number1, answers));
	        map.put(2,count(number2, answers));
	        map.put(3,count(number2, answers));
	        
	        List<Integer> keySetList = new ArrayList<>(map.keySet());
	        Collections.sort(keySetList, (o1,o2) ->map.get(o2).compareTo(map.get(o1)));

	        
	        return answer;
	    }
	 
	 public static int count(int[] person , int[]answer) {
		 int cnt =0;
		 
		 for( int i=0 ; i< answer.length ;i+= person.length) {
			 for( int j = 0; j<person.length ; j++) {
				 if(j+i <answer.length) { //index 벗어나지 않도록
					 if(answer[j+i] == person[j]) { 
						 cnt++;
					 }
				 }
				 
			 }
		 }
		 return cnt;
	 }
	 public static void main(String[] args) {
		 int [] answers = {1,3,2,4,2};
		System.out.println(solution(answers));
	}
}
