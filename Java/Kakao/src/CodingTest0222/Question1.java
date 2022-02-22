package CodingTest0222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;


// 시간 복잡도 N
public class Question1 {
	// 가장 긴 단어를 return
	// 두개 이상의 단어가 있다면, 그리고 같은 길이라면, 첫번째 단어를 return 하세여!
	// puncuation 무시 하기
	// 영어와 숫자가 섞여 있을 수 있다.
	//static int maxlen;
	
	public static String StringChallenge(String sen) {
		
		// 특수문자 제거
		String match ="[^\\uAC00-\\uD7A30-9a-zA-Z]";
		sen = sen.replaceAll(match," ");
		
		//문자열 자르기
		StringTokenizer tockenizer = new StringTokenizer(sen);
		
		//<길이, 문자>형식의 map
		Map<Integer, String> smap = new HashMap<>();
		
		// 문자열 길이 최대값 저장 변수
		int maxlen = 0;
		
		while(tockenizer.hasMoreTokens()) {
			String curr = tockenizer.nextToken(); //현재 문자
			int len = curr.length(); // 현재 문자열의 길이
			
			//최대 길이 저장
			maxlen = Math.max(maxlen, len);
			
			if(!smap.containsKey(len)) {
				//최초의 경우에만 put해서 저장
				smap.put(len, curr);
			}
		}
		
		return smap.get(maxlen);
	}

	public static void main (String[] args) {  
		// keep this function call here     
		Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge(s.nextLine())); 
	}
}
