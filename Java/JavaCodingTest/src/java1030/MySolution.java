package java1030;

public class MySolution {
	
	
	// 체육복 
	// 전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
	// 여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
	// 체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
	public static int solution() {
		// 전체 학생수
		int n= 5;
		int [] lost = {2,4};
		int [] reserve = {1,3,5};
		
	
		int answer = 5;
				
		// lost == 2,4 // reserve 1,3,5// n= 5
		for(int i=0; i<lost.length ; i++){
			for(int j=0; j<reserve.length; j++){
				// 빌릴 수 있는 사람이 없다
				// lost[0]-1 = 1 or 3
				// 1 != 1 
				if( lost[i]-1 == reserve[j] || lost[i]+1 == reserve[j]){
					System.out.println("빌릴 수 있음");
					break;
				}else {
					System.out.println("빌릴 수 없음");
					
				}
			}
		}
		
		//여분의 체육복이 있는 학생이 도난당함


		return answer;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(solution());
		
	}
}
