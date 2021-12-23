package DFSandBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//DFS : 깊이 우선 탐색, Depth first search
//BFS: 너비 우선 탐색, Breadth first search
//현재 정점에서 갈 수 있는 점들까지 들어가면서 탐색
// 스택 또는 재귀함수로 구현
//그래프의 모든 정점을 방문하는 것이 중요한 문제 -> 두가지 모두 가능
// 경로의 특징을 저장해둬야 하는 문제 ->DFS사용
// 최단거리를 구해야 하는 문제 -> BFS가 유리함

// 시간 복잡도 O(V+E)



public class BFS {
	
	
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
