package kakao2020;

// 기둥과 보 문제
// 2차원 배열
//기둥과 보를 삭제하는 기능도 있는데 기둥과 보를 삭제한 후에 남은 기둥과 보들 또한 위 규칙을 만족해야 합니다. 
//만약, 작업을 수행한 결과가 조건을 만족하지 않는다면 해당 작업은 무시됩니다.
public class Build {

	boolean[][] Pillar ; //기둥
	boolean [][] Bar; // 보
	
	
	// 기둥 세울수 있는지 반환 
	boolean checkPillar(int x, int y) {
		// 바닥일때 , 아래에 기둥이 있을 때 그 위에 기둥 세울 수 있음
		if(y == 0 || Pillar[x][y-1]) {
			return true;
		}
		//  아래에 보가 있는 경우, 같은 위치에 보가 있는 경우
		if(x > 0 && Bar[x-1][y] || Bar[x][y]) {
			return true;
		}
		return false;
	}
	
	//보 세울 수 있는지 반환
	boolean checkBar(int x, int y) {
		//보 아래 기둥 있는 경우 설치 가능
		// 기둥이 오른쪽에 있는 경우
		if(Pillar[x][y-1] || Pillar[x+1][y-1]) {
			return true;
		}
		
		//양쪽에 보있는 경우 설치 가능
		if(x > 0 && Bar[x-1][y] && Bar[x+1][y]) {
			return true;
		}
		
		//그외 설치 불가능
		return false;
	}
	// 보나 기둥을 삭제할 수 있는지
	boolean canDelete(int x, int y) {
		for( int i = Math.max(x-1, 0) ; i<= x+1 ; i++) {
			for( int j =y; j<= y+1 ; j++) {
				if(Pillar[i][j]  && checkPillar(i,j) == false) {
					// 삭제 불가
					return false;
				}
				if(Bar[i][j]  && checkBar(i,j) == false) {
					return false;
				}
			}
		}
		// 삭제 가능
		return true;
	}
	
	public int[][] solution(int n, int[][] build_frame) {
		//				조금 더 크게 만들기
		Pillar = new boolean[n+2][n+2];
		Bar = new boolean[n+2][n+2];
		
		int count = 0;
		for( int[] build : build_frame) {
			int x = build[0], y = build[1];
			int type = build[2], cmd = build[3];

			if( type == 0) {
				//기둥
				if(cmd ==1 ) {
					// 기둥 설치
					if(checkPillar(x,y)) {
						Pillar[x][y] = true;
						count++;
					}
				}else {
					// 기둥 삭제
					// 기둥 삭제 하고 나서 주변의 보와 기둥이 존재 할 수 있는지 확인한다.
					Pillar[x][y]=false;
					if(canDelete(x,y) == false) {
						//삭제 불가능
						Pillar[x][y] = true;
						
					}else {
						//삭제 성공
						count--;
					}
				}
			}else {
				//보
				if(cmd == 1) {
					//보 설치
					if(checkBar(x,y)) {
						Bar[x][y]= true;
						count++;
					}
				}else {
					//보 삭제
					Bar[x][y] = false;
					if(canDelete(x,y) == false) {
						//삭제 불가능한 경우 다시 true로 바꾼다.
						Bar[x][y] = true;
					}else {
						//삭제 성공
						count--;
					}
				}
			}
		}

		int[][] answer = new int[count][3];
		
		count  = 0;
		
		for( int x = 0; x<= n; ++x) {
			for( int y = 0; y <=n; ++y) {
				if(Pillar[x][y]) {
					//기둥이 있으면
					answer[count][0] = x;
					answer[count][1] = y;
					answer[count++][2] = 0;
					
				}
				if(Bar[x][y]) {
					// 보가 있으면
					answer[count][0] = x;
					answer[count][1] = y;
					answer[count++][2] = 1;
				}
			}
		}
		
		return answer;
	}
}
