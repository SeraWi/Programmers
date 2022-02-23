package codingTest0223;

public class Question2 {
	
	//로봇의 위치 저장
	int r ;
	int c;
	int answer;
	int[][] office;
	
	
	public void work(String currDir) {
		
		if(currDir.equals("north")) {
			answer += office[r-1][c];
			office[r-1][c] = 0;
			r = r-1;
		}else if(currDir.equals("south")) {
			answer += office[r+1][c];
			office[r+1][c]= 0;
			r= r+1;
		}else if(currDir.equals("east")) {
			
			answer +=office[r][c+1];
			office[r][c+1] = 0;
			c = c+1;
			
		}else if(currDir.equals("west")) {
			answer += office[r][c-1];
			office[r][c-1] =0;
			c= c-1;
		}
		
	}
	
	//앞으로 갈 수 있는지 체크
	boolean go (String way) {
		
		// r, c: 현재 위치
		if(way.equals("north")) {
			if(r-1 <0 || office[r-1][c] == -1) {
				//위쪽에 닿음
				return false;
			}else {
				return true;
			}
			
		}else if(way.equals("south")) {
			if(r+1 >= office.length || office[r+1][c] == -1) {
				//위쪽에 닿음
				return false;
			}else {
				return true;
			}
		}else if(way.equals("east")) {
			if(c+1 >= office.length|| office[r][c+1] == -1) {
				//오른쪽에 닿음
				return false;
			}else {
				return true;
			}
		}else if(way.equals("west")) {
			if(c-1 <0 || office[r][c-1] == -1) {
				//왼쪽에 닿거나 장애물
				return false;
			}else {
				return true;
			}
		}
		
		return false;
	}

	
	//오른쪽으로 회전
	public String directionRight(String currDir) {
		
		String newDir = "";
		if(currDir.equals("north")) {
			newDir= "east";
		}else if(currDir.equals("east")){
			newDir="south";
		}else if(currDir.equals("west")) {
			newDir= "north";
		}else if(currDir.equals("south")) {
			newDir= "west";
		}
		return newDir;
	}
	
	//왼쪽으로 회전
	public String directionLeft(String currDir) {
		
		String newDir = "";
		if(currDir.equals("north")) {
			newDir= "west";
		}else if(currDir.equals("east")){
			newDir="north";
		}else if(currDir.equals("west")) {
			newDir= "south";
		}else if(currDir.equals("south")) {
			newDir= "east";
		}
		return newDir;
	}
	
	public int solution(int[][] office, int r, int c, String[] move) {
		//청소한 먼지의양을 return 
		// 최초에 로봇이 놓이는 위치도 청소한다
		// left, right는 그자리에서 회전만 한다.
		// go해서 갈때만 청소한다.
		this.answer = 0;
		this.office= office;
		
		this.r = r ;
		this.c = c;
		
		// 처음 놓인 자리 청소하기
		answer += office[r][c];
		// 청소한뒤 0으로 만들기
		office[r][c] = 0;
		
		// 로봇이 바라 보고 있는 방향성
		String currDir ="north";
		
		for(String m : move) {
			
			if(m.equals("go")){
				if(go(currDir)) {
					//true 이면 움직인다.
					//움직여서 청소한다.
					// 청소한뒤 0으로 바꾼다.
					// 움직인 뒤의 위치를 저장한다.
					work(currDir);
				}
				
			}else if(m.equals("right")) {
				//로봇이 바라보는 방향만 바꾼다.
				currDir = directionRight(currDir);
				
			}else if(m.equals("left")) {
				currDir = directionLeft(currDir);
			}
			
		}
		
		return answer;
	}
	

	
	
	public static void main(String[] args) {
		int[][] office = {
				{5,-1,4},{6,3,-1},{2,-1,1}
		};
		int r = 1;
		int c = 0;
		String[] move = {"go","go","right","go","right","go","left","go"};
		//System.out.println(solution(office, r,c, move));
	}
}
