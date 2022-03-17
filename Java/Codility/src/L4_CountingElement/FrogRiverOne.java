package L4_CountingElement;

//시간 복잡도  O(N)
public class FrogRiverOne {
	public int solution(int X, int[] A) {
        // write your code in Java SE 8
		int answer = -1;
		
		//0~X까지 담을 수 있는 배열
		boolean[] isLeaf = new boolean[X+1]; 
		int count = 0;
		
		// 대입연산 1회 
		for( int i = 0; i<A.length ; i++) { // loop : N번
			//포지션
			int position = A[i]; // 대입연산1회
			//포지션이 이미 true 라면 pass
			if(isLeaf[position]) { // 비교연산 1회
				continue;
			}
			//포지션이 false 라면 true로 바꾸기
			isLeaf[position] = true; // 대입
			count++; //true 바뀐 숫자 //대입연산
			
			//true 갯수가 X와 같다면 index 0빼고 모든 배열 true 인 상태로
			//X까지 건너갈 수 있는 상황
			if(count == X) { // 비교연산1회
				// 현재 포지션 반환
				answer = i; 
				break;
			}
 		}
		return answer;
    }
	public static void main(String[] args) {
		
	}
}
