package Kakao2021Recruit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//각 손님들이 주문한 단품메뉴들이 문자열 형식으로 담긴 배열 orders, 
//"스카피"가 추가하고 싶어하는 코스요리를 구성하는 단품메뉴들의 갯수가 담긴 배열 course가 매개변수로 주어질 때, "스카피"가 새로 
//추가하게 될 코스요리의 메뉴 구성을 문자열 형태로 배열에 담아 return 하도록 solution 함수를 완성해 주세요.
public class NewCourse {
	
	static HashMap<String, Integer> map;
	static int m;
	
	
    public String[] solution(String[] orders, int[] course) {
    	//코스 요리의 메뉴 구성은 손님 2명이 그렇게 시킨적이 있을 경우에만 추가 가능
    	//정답은 각 코스요리 메뉴의 구성을 문자열 형식으로 배열에 담아 사
    	// 전 순으로 오름차순 정렬해서 return 해주세요. -> answer 오름차순 시키기!
    	
    	PriorityQueue<String> pq = new PriorityQueue<String>();
    	
    	//corse갯수 한번돌때마다 map하나씩 만들기
    	for(int i =0; i<course.length; i++) {
    		map = new HashMap<>();
    		
    		m= 0;
    		
    		for( int j=0;j<orders.length; j++) {
    			find(0,"",course[i],0, orders[j]);
    		}
    		
    		for(String s: map.keySet()) {
    			if(map.get(s) == m && m >1) {
    				pq.offer(s);
    			}
    		}
    	}
    	
    	
        String[] answer = new String[pq.size()];
        int k =0;
        while(!pq.isEmpty()) {
        	answer[k++] = pq.poll();
        }
        return answer;
    }


	public void find(int cnt,String str, int targetNum, int idx, String word) {

		if(cnt == targetNum) {
			char[]c = str.toCharArray();
			Arrays.sort(c);
			String temps ="";
			for( int i=0;i<c.length; i++) {
				temps +=c[i];
				map.put(temps, map.getOrDefault(temps,0)+1);
				m = Math.max(m, map.get(temps));
				return;
			}
		}
		
		
		for( int i=idx;i<word.length();i++) {
			char now = word.charAt(i);
			find(cnt+1, str+now, targetNum, i+1, word);
		}
		
	}
}
