package StackAndQueue;

import java.util.Stack;

//that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.
//O(N) 시간복잡도
public class Brackets {
	public static int solution(String S) {
        // write your code in Java SE 8
		if(S.length() == 0) {
			return 1;
		}
		char [] charArr = S.toCharArray();
		Stack<Character> s = new Stack<>();
		
		for(char c : charArr) {
			if((c =='(') || (c =='{') || (c =='[')) {
				//open 된모양을 stack에 넣는다.
				s.push(c);
			}else if(c ==')') {
				// 닫는거 나왔을 때 ->stack 에 들어있는거 팝했을때 닫는 모양이 아니거나,
				// open 이 없는 경우 
				// pop : removes the top
				if(s.size() == 0 || s.pop() != '(') {
					//바로 for문 종료
					return 0;
				}
			}else if(c == '}') {
				if(s.size() == 0|| s.pop()!='{') {
					return 0;
				}
			}else if(c ==']') {
				if(s.size() == 0 || s.pop() != '[') {
					return 0;
				}
			}else {
				continue;
			}
			
		}
		return s.isEmpty() ? 1: 0;
    }
	public static void main(String[] args) {
		String s = "{[()()]}";
		System.out.println(solution(s));
	}

}
