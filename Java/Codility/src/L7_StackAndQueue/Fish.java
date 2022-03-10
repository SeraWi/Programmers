package L7_StackAndQueue;

import java.util.Stack;

public class Fish {
	/*
	 * A 배열은 Fish의 크기를 나타내며, 큰 물고기가 마주치는 물고기를 잡아먹음.
	 * B 배열은 방향을 나타내며, 1은 downstream,
	 * 0은 upstream. 물고기의 속력을 일정하여 방향이 같으면 영원히 만나지 않는다.
		물고기가 서로 다른 방향으로 움직이고 서로 만날 때 큰 물고기가 작은 물고기 잡아먹음
		P < Q, B[P] = 1 이고 B[Q] = 0 일 때 두 물고기는 서로 만난 후
		A[P] > A[Q] 이면 P가 Q 잡아먹고 P는 하류로 이동함.
		A[Q] > A[P] 이면 Q가 P 잡아먹고 Q는 상류로 이동함.
		같은 방향으로 움직이는 물고기는 서로 만나지 않음
	 */

	//	하류로 이동하는 물고기만 (1) stack에 담는다.
	//	상류로 이동하는 물고기를 만날때 사이즈 비교
	//	Stack이 비어있지 않으면 사이즈 비교를 하고, 상류로 이동하는 물고기가 더 클 경우 stack에서 pop해준다.
	//	상류로 올라가는 경우가 하류로 내려오는 물고기들 보다 클 경우 stack은 비게 되고 상류로 올라가는 물고기 수 증가
	
	//O(N)
	public static int solution(int[] A, int[] B) {
		// write your code in Java SE 8
		Stack<Integer> stack = new Stack<>();

		int survivals =0;
		for( int i = 0; i<A.length; i++) {
			int fish = A[i];
			int direction = B[i];
			
			if(direction == 0) {
				boolean survives = true;
				//비어있지 않으면
				while(!stack.isEmpty()) {
					//물고기 꺼내기
					int oppFish = stack.pop();
					//현재랑 비교하기
					if(oppFish > fish) {
						//크다면 다시 넣어주기
						stack.push(oppFish);
						survives= false;
						break;
					}
				}
				// 통과해서 살아남았다면++
				if(survives) {
					survivals++;
				}
				
			}else {
				//direction == 1
				stack.push(fish);
			}
		}
		survivals+= stack.size();
		return survivals;
	}
	public static void main(String[] args) {
		int[]A = new int[]{4,3,2,1,5};
		int[]B = new int[]{0,1,0,0,0};
		// 4는 아무 물고기도 만나지 않음
		// 3은 2를 먹고, 1을 먹고, 마지막에 5에게 먹힘
		// 살아남은 4, 5
		
		System.out.println(solution(A, B));
		
	}
}
