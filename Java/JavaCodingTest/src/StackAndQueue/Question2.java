package StackAndQueue;

import java.util.Stack;


public class Question2 {

	public static void main(String[] args) {

		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(5);
		q.add(7);
		q.add(9);
		System.out.println(q.isEmpty());//false
		
		while(q.size() > 0) {
			System.out.println(q.peek());
			System.out.println(q.remove() +""); // 1,2,3,5,7,9
		}
		
		System.out.println(q.isEmpty()); //true
		
	}
}

class Queue{
	Stack<Integer> stackIn;
	Stack<Integer> stackOut;

	Queue(){
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}
	//StackIn에 데이터 저장
	public void add(int num) {
		stackIn.push(num);
	}
	
	public int remove() {
		// stackOut이 비어있는 경우 실행
		if(stackOut.isEmpty()) {
			// StackIn의 데이터가 빌때까지 StackOut으로 옮긴다.
			while(!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}

		return stackOut.pop(); 
	}

	public int peek() {
		if(stackOut.isEmpty()) {
			while(!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}

		return stackOut.peek(); 
	}
	
	public int size() {
		return stackIn.size()+ stackOut.size();
	}
	
	// 두개의 스택 사이즈가 0이라면 데이터가 없는 상태
	public boolean isEmpty() {
		boolean chk = false;
		if(stackIn.size()+ stackOut.size() == 0) {
			chk = true;
		}
		
		return chk;
	}
	
	
}