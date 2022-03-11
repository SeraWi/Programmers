package CodingTest;

public class Question2 {
	// 숫자 N을 뒤집어서 출력한다.
	// 처음 나오는 zero는 표기되지 않도록 한다.
	// 최대 3줄 을 고칠 수 있다.
	public static void solution(int N) {
		 //10의 배수인지 체크
		int enable_print = N % 10;
		while (N > 0) {    
			
			// 1. 가장 뒷자리가 0인 경우는 패스 된다.
			// 2. 중간에 0인 경우는 if 에서 걸린다.
			// 3. 가장 뒷자리가 아닌 경우는 else if에서 걸린다.
			
			
			// 0을출력할 수 있는 경우 : 10의배수 아니고 애초에 제일 뒷자리도 0이 아님
		    if (enable_print != 0 && N % 10 == 0) { //여기 고치고
		        System.out.print(0); //여기 고치고
		    } // 10의 배수도 아니거나 print가능
		    // 다른 값들 출력 : 10의 배수 아니거나, 애초에 제일 뒷자리 0이 아님
		    else if (enable_print == 1 || N %10 !=0 ) { //여기고치고
		        System.out.print(N % 10);
		    }
		    // 제일 뒷자리가 0인경우는 계속 패스된다.
		    
		    N = N / 10;  
		   
		}
		 System.out.println();
	}
	
	public static void main(String[] args) {
		solution(2002);
		solution(1000);
		solution(2000);
		solution(1);
		solution(12345);
	}

}


