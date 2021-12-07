package Kakao2019Intern;

import java.util.Stack;

public class DollGameOtherSol {
	public int solution(int[][]board, int[]moves) {
		int answer =0;
		Stack<Integer> stack = new Stack<>();
		
		for( int move : moves) {
			for (int j=0; j<board.length; j++) {
				if(board[j][move-1] != 0) {
					
					// 바구니 비어있으면 인형 추가해주기
					if(stack.isEmpty()) {
						stack.push(board[j][move-1]);
						//추가한뒤 보드판 0으로 만드릭
						board[j][move-1] = 0;
						//그다음  두번째 for문 탈출
						
						break;
					}
					// 뽑는 인형이 이미 있는 stack에 존재한다면
					if(board[j][move-1]== stack.peek()) {
						//인형 터트리기
						stack.pop();
						//터뜨린 인형 +2
						answer +=2;
					}else {
						//아니라면 바구니에 넣기
						stack.push(board[j][move-1]);
						
						//보드판 0으로 숫자 바꾸기
						board[j][move-1] = 0;
						break; //for문 탈출
					}
					
				}
			}
		}
		
		return answer;
	}
}
