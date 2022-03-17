package L4_CountingElement;

import java.util.Arrays;

public class ex {
	public int solution(int X, int[] A) {
		// write your code in Java SE 8

		// X까지의 숫자가 모두 나오는 순간을 리턴한다.

		// 인덱스 1에 1
		boolean[] leaves = new boolean[X+1];    
		int cnt = 0;

		//loop돌며 leaves true로 바꾸기
		for( int i= 0; i<A.length ; i++){
			int currleaf = A[i];
			if(!leaves[currleaf]){
				//처음 나온거면
				leaves[currleaf] = true;
				cnt++;
			}else{
				//이미 true 이면 무시하고 넘어가기
			}

			if(cnt == X){
				//X까지 다 채워짐
				return i+1;
			}
		}
		return cnt;    
	}


	public int solution2(int[] A) {
		// write your code in Java SE 8

		// A원소 모두 음수일경우 1리턴
		// 양수, 음수 섞인 경우 positive Integer 반환
		// A 오름차순 정렬시키기
		// 0이상이면서 연속되지 않는 순간의 숫자를 리턴

		Arrays.sort(A);

		//마지막 인덱스 0보다 작은 경우
		if(A[A.length -1] <= 0){
			return 1;
		}

		//숫자 체크하는 불리언 배열
		boolean[] check = new boolean[A.length+1];

		//그외의 경우
		for ( int i = 0; i<A.length-1 ; i++){

			//처음 들어오는 숫자인경우

			if(A[i] > 0){
				if(!check[A[i]]){
					check[A[i]] = true; 
				}else if(check[A[i]]){
					//이미 있는 숫자의 경우
					//pass
				}
			}

		}

		for( int i=1 ; i<check.length ; i++){
			//처음으로 false나오는 숫자를 반환
			if(!check[i]){
				return i;
			}
		}

		return 0;


	}

	public static void main(String[] args) {
		System.out.println(new ex().solution2(new int[] {1,2,3}));
	}
}
