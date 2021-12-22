package DFSandBFS;

import java.util.Iterator;
import java.util.LinkedList;

//DFS : 깊이 우선 탐색, Depth first search
//현재 정점에서 갈 수 있는 점들까지 들어가면서 탐색
// 스택 또는 재귀함수로 구현
//그래프의 모든 정점을 방문하는 것이 중요한 문제 -> 두가지 모두 가능
// 경로의 특징을 저장해둬야 하는 문제 ->DFS사용
// 최단거리를 구해야 하는 문제 -> BFS가 유리함

class Queue<T>{
	
}
class Graph{
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;	
		
		Node(int data){
			this.data = data;
			this.marked = false;
			adjacent = new LinkedList<Node>();
		}
	}
	
	Node[]nodes;
	Graph(int size){
		nodes= new Node[size];
		for ( int =0; i<size; i++) {
			nodes[i] = new Node(i);
		}
	}
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
	}
}
public class DFS {
	
	public static void main(String[] args) {
		
	}
}
