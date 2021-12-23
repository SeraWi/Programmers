package DFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//DFS : 깊이 우선 탐색, Depth first search
//BFS: 너비 우선 탐색, Breadth first search - Queue 사용
// 시간복잡도 O(V+E)

public class BFS {
// 루트 노드나 임의의 노드에서 시작하여 인접한 노드를 먼저 모두 확인한 후 다음 DEPTH를 탐색
// queue를 사용하여 데이터를 탐색
// FIFO 구조
	
	
	public static boolean[] visited = new boolean[9];
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	//BFS함수 정의
	public static void bfs(int start) {
		Queue<Integer> q= new LinkedList<>();	
		q.offer(start);
		//현재 노드를 방문 처리
		visited[start] = true;
		//큐가 빌때까지 반복
		while(!q.isEmpty()) {
			int x= q.poll();
			for( int i=0;i<graph.get(x).size(); i++) {
				int y = graph.get(x).get(i);
				if(!visited[y]) {
					q.offer(y);
					visited[y] = true;
				}
			}
		}
			
		
		
	}
	public static void main(String[] args) {
		
	}
}
