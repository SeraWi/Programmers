package StackAndQueue;

import java.util.Stack;

//O(N) 통과
public class Nesting {
	public static int solution(String S) {
        // write your code in Java SE 8
		int answer = 1;
		
		char [] charArr = S.toCharArray();
		Stack<Character> s = new Stack<>();
		
		for(char c : charArr) {
			if(c=='(') {
				s.push(c);
			}else {
				if(s.size()== 0 || s.pop()!='(') {
					return 0;
				}
			}
		}
		// 비어있으면 1
		return s.isEmpty()? 1 : 0 ;
    }
	
	public static void main(String[] args) {
		//String S = "(()(())())";
		String S = "())";
		System.out.println(solution(S));
	}
}
