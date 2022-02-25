package kakao2020;

import java.util.LinkedList;
import java.util.Queue;

public class Robot {
	static final int UP = 0;
	static final int RIGHT = 1;
	static final int DOWN = 2;
	static final int LEFT = 3;
	
	int[][] D = {{-1,0},{1,0},{0,-1},{0,1}};
	
	int[][] Board;
	int N;
	Queue<Point[]> Q = new LinkedList<>();
	boolean[][][] Visited = new boolean[100][100][4];
	
	public int solution(int[][] board) {
		Board = board;
		N = board.length;
		
		Q.add(new Point[] {new Point(0,0,RIGHT,0), new Point(0,1,LEFT,0)});
		Visited[0][0][RIGHT] = true;
		Visited[0][1][LEFT] = true;
		//BFS 탐색

		Point[] curr = new Point[2];
		Point[] newPt  = new Point[2];
		
		while((curr = Q.poll()!= null) {
			for( int j = 0 ; j<4; ++j ) {
				for( int i = 0; i<2 ; ++i) {
					newPt[2] = new Point(curr[i].row+D[j][0], curr[i].col+ D[j][1],curr[i].dir, curr[i].time+1);
							
				}
				
				if(isValid(newPt) == false) {
					continue;
				}
			}
		}
		
				
		int answer = 0;
		
		return answer ;
	}
	
	boolean isValid(Point[] pt) {
		for( int i = 0; i<2; i++) {
			if(pt[i].row<0 || pt[i].row > N-1 || pt[i].col<0|| pt[i].col>N-1) {
				return false;
			}
			if(Board[pt[i].row][pt[i].col]==1) {
				return false;
			}
			
			if(Visited[pt[i].row][pt[i].col][pt[i].dir] == true) {
				return false;
			}
			
		}
		return true;
	}
	
	
	class Point{
		int row, col, dir, time;
		public Point(int row, int col, int dir, int time) {
			this.row = row;
			this.col = col;
			this.dir = dir;
			this.time = time;
		}

		
	}

}
