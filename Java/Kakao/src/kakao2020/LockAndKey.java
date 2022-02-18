package kakao2020;


// 자물쇠와 열쇠 (Lv3)
// 입력 크지 않기 때문에 모든 경우, 완전탐색한다.
// 0은 홈 부분, 1은 돌기 부분을 나타냅니다.
public class LockAndKey {
	
	//키를 자물쇠에 매치 시킨다.       
	//				복사된 자물쇠	키		회전			
	void match(int[][]arr, int[][]key, int rot, int r, int c) {
		
		int n = key.length;
		for(int i= 0; i<n; ++i) {
			for( int j = 0; j<n; ++j) {
				if( rot == 0) {// 회전안한 상태
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
	//										자물쇠 크기
	boolean check(int[][] arr, int offset, int n) {
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
	
	
	public boolean solution(int[][] key, int[][] lock) {
		int offset = key.length-1;


		for( int r = 0; r<offset + lock.length ; ++r) {
			for( int c = 0; r < offset + lock.length; ++c) {

				//90 도 회전한다.
				for( int rot = 0 ; rot <4 ; ++rot) {
					// 자물쇠와 키를 두는 배경 어레이
					// 최대치로 만들어 둔다 : 20+20+20-2
					int [][] arr = new int[58][58]; //0으로 기본 초기화
					
					// 자물쇠 복사하는 이중for문
					for( int i = 0; i<lock.length; i++) {
						for( int j= 0; j<lock.length; j++) {
							
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
}
