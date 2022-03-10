package L4_CountingElement;

//시간 복잡도  O(N)
public class FrogRiverOne {
	public int solution(int X, int[] A) {
        // write your code in Java SE 8
		int answer = -1;
		
		//0~X까지 담을 수 있는 배열
		boolean[] isLeaf = new boolean[X+1];
		int count = 0;
		
		for( int i = 0; i<A.length ; i++) {
			//포지션
			int position = A[i];
			//포지션이 이미 true 라면 pass
			if(isLeaf[position]) {
				continue;
			}
			//포지션이 false 라면 true로 바꾸기
			isLeaf[position] = true;
			count++; //true 바뀐 숫자
			
			//true 갯수가 X와 같다면 index 0빼고 모든 배열 true 인 상태로
			//X까지 건너갈 수 있는 상황
			if(count == X) {
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
