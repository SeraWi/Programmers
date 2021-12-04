package DevMatching2021_2;

public class Question1 {
	static String [][]table ;
	public static int solution(String[] drum) {

		// drum의 원소 갯수는 구슬을 굴릴 수 있는 개수 -> 반복문써서 돌리기
		// 좌표를 바꿔준다
		// drum ->으로 2차원 배열로 만들기
		// 그 다음 기호에 따라 좌표를 움직여 주기

		table = new String [drum.length][drum.length];

		for( int i =0; i< drum.length ; i++) {
			for( int j =0; j<drum.length; j++) {
				String el = drum[i].substring(j,j+1);

				table[i][j] = el;
			}
		}

		//		for( int i=0; i<table.length; i++) {
		//			for( int j=0; j<table.length ; j++) {
		//				System.out.print(table[i][j]+" ");
		//			}
		//			System.out.println();
		//		}

		// 구슬의 위치를 (0,0) ~(0, table.length-1)까지 넘겨주면
		// 결과를 x와 y 좌표로 반환하기
		int result = 0;
		for( int i=0; i<table.length; i++) {
			if( move(0, i) >=table.length) {
				result ++;
			}
		}
		return result;
	}

	public static int move(int x, int y) {
		
		//reusltY 가 6을 넘으면 구슬이 바닥에 떨어진거임

		//처음 위치
		int xx = x;
		int yy = y;
		System.out.println(xx+ " :" + yy);
		
		int starCnt =0;

		while(xx<table.length && starCnt !=2) {
			String position = table[xx][yy];
			
			System.out.println(position);
			if(position.equals("#")) {
				//아래쪽으로 내려오기
				xx +=1;
			} else if(position.equals(">")){
				//오른쪽으로 움직이기
				yy+=1;
				
			}else if(position.equals("<")){
				//왼쪽으로 움직이기
				yy-=1;
				
			}else if(position.equals("*")){
				if(starCnt <2) {
					xx+=1;
					//아래로 내려가기
					starCnt++;
					
				}else {
					// 별 두번만나면  멈추기
					break;
				}
			}
		}
		//마지막 최종 y의 위치를 넘겨
		System.out.println(xx+ " :" + yy);
		System.out.println("------------------------");
		int resultX =xx;
		return resultX;
	}

	public static void main(String[] args) {
		String[]drum={"######",">#*###","####*#","#<#>>#",">#*#*<","######"};
		System.out.println(solution(drum));
	}
}
