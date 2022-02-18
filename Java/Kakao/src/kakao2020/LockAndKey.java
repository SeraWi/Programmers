package kakao2020;


// 자물쇠와 열쇠 (Lv3)
// 입력 크지 않기 때문에 모든 경우, 완전탐색한다.
// 0은 홈 부분, 1은 돌기 부분을 나타냅니다.

/*
1. 키 위치를 움직인다.(행, 열 방향으로 움직인다 -> 이중 for문)
2. 움직인 위치에서 키를 90도, 180도 , 270도 회전한다. (1번의 경우에 대해 4가지 경우의 수,for 문)
2. 움직일때 마다 새로운 arr[][]을 만든다.
3. arr[][]위에 자물쇠를 복사한다. (이중 for 문으로 행렬 복사한다)
4. 키를 자물쇠에 match한다 (이중for문으로 match 시켜 arr에 key값을 더한다.)
5. arr[][]의 자물쇠 배열이 전부 1로 바뀌었는지 확인한다.
6. 전부 1로 만들어진 경우 : true 반환하고 종료한다.
7. true 반환하기 전까지 전단계를 계속 반복하며 완전탐색한다.

*/

public class LockAndKey {
	
	//키를 자물쇠에 매치 시킨다.       
	//				복사된 자물쇠	키		회전			키위치
	static void match(int[][]arr, int[][]key, int rot, int r, int c) {
		
		
		// arr에 key 를 복사해서 더한다.
		
		int n = key.length;
		
		for(int i= 0; i<n; ++i) {
			for( int j = 0; j<n; ++j) {
				if( rot == 0) {
					// 회전안한 상태
					arr[r+i][c+j] += key[i][j];
				}else if(rot ==1) {
					// 90도 회전한 값
					arr[r+i][c+j] += key[j][n-1-i];
				}else if(rot == 2) {
					//180도 회전한 값
					arr[r+i][c+j] += key[n-1-i][n-1-j];
				}else if(rot == 3) {
					//270도 회전한 값
					arr[r+i][c+j] += key[n-1-j][i];
				}
				
			}
		}
		
	}
	//										    자물쇠 크기
	static boolean check(int[][] arr, int offset, int n) {
		for ( int i = 0; i<n; ++i) {
			for( int j= 0; j<n ; ++j) {
				if(arr[offset +i][offset+j] != 1) {
					//0 이나 2인 경우 -> 안맞다
					return false;
				}
			}
		}
		//이중 포문 모두 돌아가면 -> 맞는거임
		return true;
	}
	
	
	public static boolean solution(int[][] key, int[][] lock) {
		int offset = key.length-1;

		// 키의 위치를 옮겨간다.
		for( int r = 0; r<offset + lock.length ; ++r) {
			for( int c = 0; r < offset + lock.length; ++c) {
				//90 도 회전한다.
				for( int rot = 0 ; rot <4 ; ++rot) {
					// 자물쇠와 키를 두는 배경 어레이
					// 최대치로 만들어 둔다 : 20+20+20-2
					int [][] arr = new int[58][58]; //0으로 기본 초기화
					// 자물쇠 복사하는 이중for문
					for( int i = 0; i<lock.length; ++i) {
						for( int j= 0; j<lock.length; ++j) {
							
							// 기존 자물쇠 lock을 arr위에 복사하기 (중간에 두기)
							// offet 만큼 떨어져서 가로 세로 딱 중간에 위치시킨다.
							arr[offset +i][offset +j] = lock[i][j];
						}
					}
					
					// 키를 자물쇠에 매치시켜보는 함수 호출
					match(arr, key, rot, r, c);
										
					//자물쇠 영역이 전부 1인지 확인 ->맞으면 lock이 풀린다 ->true 반환
					if(check(arr, offset, lock.length)) {
						return true;
					}
				}
			}
		}

		//모든 경우의 수 확인했지만 열리지 않은 경우 false반환

		return false;
	}
	
	public static void main(String[] args) {
		int[][] key = {
				{0,0,0},
				{1,0,0},
				{0,1,1}
		};
		int[][] lock = {
				{1,1,1},
				{1,1,0},
				{1,0,1}
		};
		
		System.out.println(solution(key, lock));
	}
}
