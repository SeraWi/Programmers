package kakao2020;

import java.util.Arrays;

// 외벽 점검 문제
// 완전 탐색 + 재귀
public class Wall {
	
	static final int INF =987654321; //임의의 큰수 지정
	int MinCnt;
	int N;
	int[]Weak;
	int[]Dist;
	
	
	void solve(int cnt, int pos, int visited) {
		
		if(cnt > Dist.length ) {
			return;
		}
		if(cnt >= MinCnt) {
			return;
		}
		
		for( int i=0; i<Weak.length; i++) {
			int nextPos =( pos +i ) % Weak.length;
		    // 거리 = 끝점 - 시작점
			int diff = Weak[nextPos] - Weak[pos];
			
			// 원점을 지나친 경우
			if(nextPos < pos) {
				diff += N;
			}
			//			거리가 큰것부터 쓴다
			if(diff > Dist[Dist.length-cnt]) {
				break;
			}
			
			visited |= 1 <<nextPos;
		}
		
		if(visited ==(1<<Weak.length) -1) {
			MinCnt = cnt;
			return;
		}
		
		for(int i = 0; i<Weak.length; ++i) {
			if((visited  & (1<<i)) != 0) {
				continue;
			}
			//재귀 호출
			solve(cnt+1, i, visited);
		}
	}
	
	
	//					길이,  취약점,			이동거리
    public int solution(int n, int[] weak, int[] dist) {
        // 오름차순
    	Arrays.sort(dist);
    	N= n;
    	Weak = weak;
    	Dist = dist;
    	MinCnt = INF;
    	
    	for( int i = 0; i<Weak.length; ++i) {
    		solve(1, i, 0);
    	}
    	if(MinCnt == INF) {
    		return -1;
    	}
        return MinCnt;
    }
}
