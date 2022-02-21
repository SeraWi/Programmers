package kakao2021;

public class BitOperationEx {
	
	/*
	 * & : 두 비트가 모두1일 경우에만 1 
	 * | : 두 비트 중에서 하나라도 1이면 1 
	 * ^ : 두비트가 같으면 0, 다르면 1 
	 * ~ : 각비트를 반전 
	 * << :비트를 왼쪽으로 이동, 하나 이동할 때 마다 곱하기 2
	 * >> :비트를 오른쪽으로 이동, 하나 이동할 때 마다 나누기 2
	 */
	
	static void printSubsets(char[] arr, int n) {
		for (int i = 0; i<(1 << n); ++i) {
			System.out.print("{");
			
			for( int j= 0; j<n; ++j) {
				if((i &1<< j) != 0) {
					System.out.print(arr[j]+ " ");
				}
			}
			
			System.out.println("}");
		}
	}
	public static void main(String[] args) {
		//비트를 이용한 부분집합
		// {a,b,c,d }: 부분집합의 갯수는 16개
		// 부분집합의 총개수 1 << n
		
		
		char[] data = {'A','B','C','D'};
		printSubsets(data, 4);
	}

}
/*
 * i번쟤 원소가 있는지 확인 
 * (비트로 표현된 집합 ) &(1 << i)결과가 0이 아니면 존재
 * 2번째 원소가 있는지 확인
 * 0101 & (1<<2) == 0101 &0100 = 0100
 * 
 * i번째 원소를 추가
 * (비트로 표현된 짛바) | (1 <<i)
 * 1번쟤 원소를 추가
 * 0101 & (1 <<1) =0101 |0010 = 0111 
 * 
 * i번째 원소를 삭ㅈ
 * (비트로 표현된 집합) & ~(1<<i)
 * 2번째 원소를 삭제
 * 0101 &~(1<<2) = 0101 & ~(0100) = 0101 &1011 = 0011
 * 
 */
