package Kakao2020Recruit;

public class BracketsSolution {
	public static String solution(String p) {
		return getCorrectParenthesis(p);
	}

	private static boolean isCorrectParenthesis(String p) {
		int open = 0;

		for( int i = 0; i<p.length(); i++) {
			if(p.charAt(i)=='(') {
				open++;
			}else {
				if(open== 0) {
					// open 이 음수가된다 -> 올바른 괄호아님
					return false;
				}
				open--;
			}
		}
		return true;
	}

	private static String getCorrectParenthesis(String p) {
		if(p.length()==0) {
			return p;
		}

		int open = 0;
		int close = 0;
		for(char c : p.toCharArray()) {
			if(c=='(') {
				open++;
			}else {
				close++;
			}

			if(open== close) {
				break;
			}
		}

		int str = open+ close;
		String u = p.substring(0,str);
		String v = p.substring(str);

		if(isCorrectParenthesis(u)) {
			return u+getCorrectParenthesis(v);
		}else {
			String uDash = "(" + getCorrectParenthesis(v)+")";

			for( int i =1; i<str -1; i++) {
				if(u.charAt(i) =='(') {
					uDash +=")";
				}else {
					uDash +="(";
				}
			}
			return uDash;
		}
		
	}
	public static void main(String[] args) {
		String  p="()))((()";
		System.out.println(solution(p));
	}
}
