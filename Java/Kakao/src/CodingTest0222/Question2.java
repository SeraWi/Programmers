package CodingTest0222;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


//시간복잡도 N^2
public class Question2 {
	//글자에서 반복이 많은 글자를 return


	public static String StringChallenge(String str) {

		Map<Integer, String> map = new HashMap<>();

		//문자열 공백으로 나누기
		String[] strSplit = str.split(" ");

		int maxCnt = 0;

		for(String s : strSplit) {
			// 반복횟수 count
			int cnt = 0;
			
			String newS = "";
			// s에서 중복된 알파벳을 뺀 길이
			char[] sChar = s.toCharArray();

			for( char x : sChar) {
				if(!newS.contains(String.valueOf(x))) {
					newS += x;
				}
			}
			System.out.println(newS);
			int newLen = newS.length(); //중복된거 뺀 문자열 길이
			cnt = s.length() - newLen;
			

			//maxCnt 갱신
			maxCnt = Math.max(maxCnt, cnt);
			System.out.println(maxCnt);

			//map에 저장
			if(!map.containsKey(cnt)) {
				map.put(cnt, s);
			}
		}
		System.out.println(maxCnt);

		if(maxCnt == 0) {
			str = "-1";
		}else {
			str = map.get(maxCnt);
		}

		return str;
	}

	public static void main (String[] args) {  
		// keep this function call here     
		Scanner s = new Scanner(System.in);
		System.out.print(StringChallenge(s.nextLine())); 
	}

}
