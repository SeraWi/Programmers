package Study;

public class Ex {
	public static void main(String[] args) {
		// random() 메소드는 0.0 이상 1.0 미만의 범위에서 임의의 double형 값을 하나 생성하여 반환합니다.
//		
//		for( int i= 0 ; i< 50 ; i++) {
//			float rate = (float) ((Math.random()*10)+ 0.1);
//			
//			rate = Math.min(rate,10);
//			
//			rate = (float)Math.round(rate *10)/10;
//			
//			System.out.println(rate);
//			}
		
		for( int i= 0; i<100; i++) {
		int accountNum = (int) ((Math.random()*100000000)+ 1); 
		System.out.println(accountNum);	
			
		}
	}
}
