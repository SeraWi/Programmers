package StackAndQueue;

import java.util.Stack;




/*두 개의 Stack 을 사용하여 한 개의 Queue 를 구현하시오.
Queue 는 add, remove, peek,isEmpty API 를 제공해야 하며, 
Stack 은 push, pop, peek, isEmpty API 를 이미 제공 하고 있다고 가정한다.*/



public class Question2 {

	public static void main(String[] args) {

		Queue q = new Queue();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(5);
		q.add(7);
		q.add(9);
		System.out.println(q.isEmpty());
		
		
		while(q.size() > 0) {
			System.out.println(q.remove() +"");
		}
		
		System.out.println(q.isEmpty());
		
		
		
	}
}

class Queue{
	Stack<Integer> stackIn;
	Stack<Integer> stackOut;

	Queue(){
		stackIn = new Stack<>();
		stackOut = new Stack<>();
	}

	//enqueue-> add
	public void add(int num) {
		stackIn.push(num);
	}

	//dequeue -> remove(첫번째 값 제거)
	// peek (첫번째값 삭제하지 않고 반환)
	public int remove() {
		// 스택2 비어있다면 스택1원소 넣기
		if(stackOut.isEmpty()) {
			while(!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}

		return stackOut.pop(); //삭제하고 꺼내기
	}

	public int peek() {
		if(stackOut.isEmpty()) {
			while(!stackIn.isEmpty()) {
				stackOut.push(stackIn.pop());
			}
		}

		return stackOut.peek(); //값반환
	}
	
	public int size() {
		return stackIn.size()+ stackOut.size();
	}
	
	public boolean isEmpty() {
		boolean chk = false;
		if(stackIn.size()+ stackOut.size() == 0) {
			chk = true;
		}
		
		return chk;
	}
	
	
}