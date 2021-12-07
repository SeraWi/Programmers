package Kakao2019Intern;

import java.util.Stack;

public class DollGame {
	//인형 쌓아 올리기
	static Stack<Integer>dollStack = new Stack<>();
	static int totalPickDollNum;
	
	//크레인 작동 시 인형이 집어지지 않는 경우는 없으나 
	//만약 인형이 없는 곳에서 크레인을 작동시키는 경우에는 아무런 일도 일어나지 않습니다. 
	// 터트려져 사라진 인형의 갯수를 return 
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        //인형 뽑기 -> board움직이기
        for( int i = 0; i<moves.length; i++) {
        	board= moving(board, moves[i]-1);
        }

        answer = totalPickDollNum - dollStack.size();
        
        return answer;
        
    }
	
	//인형 뽑기 메서드
	public static int[][] moving(int[][]board, int moveIdx){
		
		//moveIdx가 들어오면 열에 0이 아닌 값을 찾는다
		// dollNum에 현재값 저장하기
		
		int dollNum = 0;
		
		for ( int i= 0; i<board.length; i++) {
			if(board[i][moveIdx] == 0) {
				continue;
			}else {
				// 뽑은 인형의 숫자 찾기
				dollNum = board[i][moveIdx];
				
				// 뽑고 나서 0으로 만들기
				board[i][moveIdx] = 0;
				
				// 뽑은 인형의 갯수 올려주기
				totalPickDollNum++;
				
				// 뽑은 인형 바구니에 쌓기
				dollStack.add(dollNum);
				
				// 인형 터트리기
				dollStack= dollBomb(dollStack, dollNum);
				
				break; // 뽑고 나면 for문 탈출
			}
		}
		
		return board;
	}
	
	//인형 터트리기 메서드
	public static Stack<Integer> dollBomb(Stack<Integer> dollStack, int currentDollNum) {
		//인형이 한개 이상일 때 무조건 실행
		if(dollStack.size()> 1) {
			dollStack.pop(); //currentDollNum이 뽑힌 상태
			int secondDoll = dollStack.peek();// 그 앞에꺼랑 비교위해 peek
			
			//현재 인형이 앞에 인형 이랑 같으면 터뜨리기
			if(currentDollNum == secondDoll) {
				dollStack.pop();
			}else {
				//아니면 다시 넣어주기
				dollStack.add(currentDollNum);
			}
		}
		return dollStack;
		
	}
	
	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},
				{0,0,1,0,3},
				{0,2,5,0,1},
				{4,2,4,4,2},
				{3,5,1,3,1}
		};
		int[] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board,moves));
	}
}
