package LineTechChallenge;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//정답 통과
public class Question1 {

	public static int[] solution(String[] record) {
		int[] answer = new int[2];

		// 총 판매 갯수 (FIFO사용)
		int totalSaleNum = 0;

		// lifo 결과
		int lifoResult= 0;

		// FIFO
		Queue<Integer> q = new LinkedList<>();

		// LIFO
		Stack<Integer> st = new Stack<>();

		for(int i =0; i<record.length; i++) {
			// 공백 기준으로 자르기
			String [] splitRec = record[i].split(" ");

			//queue와 stack에 purchase 값만 순서대로 저장하기
			if( splitRec[0].equals("P")) {
				// purchase수만큼 반복하며 저장
				for(int j = Integer.parseInt(splitRec[2]); j >0 ; j-- ) {
					// queue 저장
					q.add(Integer.parseInt(splitRec[1]));
					// stack 저장
					st.push(Integer.parseInt(splitRec[1]));
				}
			}else {
				// s로 시작할 경우
				totalSaleNum += Integer.parseInt(splitRec[2]);

				// s가 있는 순간  lifo 메서드 실행 
				lifoResult += lifo(st,Integer.parseInt(splitRec[2]));
			}
		}

		// fifo 계산 결과
		int fifoResult = fifo(q, totalSaleNum);

		answer[0] = fifoResult;
		answer[1] = lifoResult;

		return answer;
	}

	// fifo 메서드
	public static int fifo(Queue<Integer> priceQueue, int totalSaleNum) {
		int fifoSale = 0;

		// totalSaleNum : 전체 구입 갯수

		for(int i=totalSaleNum ; i > 0 ; i--) {
			fifoSale += priceQueue.poll();
		}

		return fifoSale;

	}

	//lifo 메서드
	public static int lifo(Stack<Integer> priceStack, int currentSaleNum) {
		int lifoSale = 0;

		// currentSaleNum : 현재 구매 갯수
		
		for(int i= currentSaleNum; i> 0; i--) {
			lifoSale += priceStack.pop();
		}

		return lifoSale;
	}



	public static void main(String[] args) {
		String[] record = {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"};
		
		//"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"
		//"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"
		System.out.println(solution(record));

	}
}
