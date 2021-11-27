package LineTechChallenge;

import java.util.Arrays;

// 테스트 통과
public class Question2 {
	public static int solution(int[] arr) {
        int cnt = 0;
        // 3개 이상 arr.length 이하로 arr의 부분 배열 만들어서 저장하기
        
        for( int i= 3; i< arr.length+1 ; i++) {
        	for( int j =0; j <arr.length ; j++) {
        		if( j+i <=arr.length) { // 마지막 index 벗어나지 않도록
        			int [] newarr = Arrays.copyOfRange(arr, j, j+i);
        			if(AStructureChk(newarr)) {
        				//true 이면 cnt증가
        				cnt ++;
        			}
        		}
        	}
        }
        return cnt;
    }
	
	// a 모양인지 체크
	public static boolean AStructureChk(int[] arr) {
		boolean chk = false;
		
		for( int i = 0; i<= arr.length-2 ; i++) {
			// 최초에 한번은 적어도 증가해야
			if(arr[0] >= arr[1]) {
				chk = false;
				break;
			}
			
			if(arr[i]< arr[i+1] && i<arr.length-2) {
				// 증가하는 추세  ->적어도 마지막 하나 앞까지는 증가 가능
				//okay
				chk= true;
				
			}else if(arr[i] < arr[i+1] && i== arr.length-2){
				//마지막까지 증가한 경우
				chk = false;
				
			}else if(arr[i]> arr[i+1] && i == arr.length-2){
				// 마지막에 감소한 경우
				chk = true;
				
			}else if(arr[i]> arr[i+1] && i <arr.length-2  && i>=1){
				//중간에 감소 한 경우
				
				// 그시점 부터 자르기 끝까지 자르기
				int [] newarr2 = Arrays.copyOfRange(arr, i, arr.length);
				
				// 끝까지 감소하는지 확인
				if(decreaseChk(newarr2)) {
					chk = true;
				}else {
					chk = false;
					break;
				}
			}else {
				//그외에 모두 false처리 (숫자비교해서 같은경우 증가, 감소 모두 아님) 
				chk = false;
				break;
			}
		}
		
		return chk;
		
	}
	
	//끝까지 감소하는지 확인 메서드
	public static boolean decreaseChk(int[] newarr2) {
		boolean decChk = true;
		// {3,1,2,4}
		for( int i=0; i<=newarr2.length-2 ; i++) {
			// 중간에 단 한번이라도 증가 추세가 나오면 false 리턴
			if(newarr2[i] < newarr2[i+1]) {
				decChk = false;
				break;
			}
		}
		
		return decChk ;
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 2, 1, 4, 3, 2, 2, 1};
		System.out.println(solution(arr));
	}

}
