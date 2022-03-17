package ASCII;

public class AlpabetPush {


	public String solution(String s, int n) {
		String answer = "";


		//s를 charArr로 바꾸기
		// loop를 돌면서 n만큼 더한 알바벳 다시 answer에 더하기
		// 만약 범위를 넘어갈 경우 Z -> A로 보내기


		char[] ch = s.toCharArray();

		for( int i = 0; i<ch.length; i++) {

			char newChar = 0;
			// 대문자 계산
			if((int)ch[i] +n > (int)'A' + 26 &&(int)ch[i] >= (int)'A') {
				//범위를 넘어가는 경우
				// 다시 앞에서 부터 
				newChar = (char)(((int)ch[i] + n)-26);
			}else if((int)ch[i] >= (int)'A') {
				newChar =(char) ((int)ch[i] + n); 
			}

			//소문자
			if((int)ch[i] +n > (int)'a' + 26 && (int)ch[i] >= (int)'a' && (int)ch[i] <=(int)'z') {
				//범위를 넘어가는 경우
				// 다시 앞에서 부터 
				newChar = (char)(((int)ch[i] + n)-26);
			}else if((int)ch[i] >= (int)'a' && (int)ch[i] <= (int)'z') {
				newChar =(char) ((int)ch[i] + n); 
			}

			answer += String.valueOf(newChar);


		}




		return answer;
	}

	public static String solution2(String s, int n) {
		String result ="";
		
		n = n %26;//나머지
		for( int  i= 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			System.out.println("curr CH : " + ch );
			if(Character.isLowerCase(ch)) {
				//소문자만
				// a가 들어오면 0 +1  %26
				// b가들어오면 1 +1 -> 
				ch = (char)((ch -'a' +n) %26 +'a');
			}else if(Character.isUpperCase(ch)) {
				ch = (char)((ch-'A' +n) %26 +'A');
				
			}
			System.out.println("after : " + ch);
			
			result += ch;
		}
				
				
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(solution2("abc",1));
		System.out.println((char)('a' +1));
	}

}
