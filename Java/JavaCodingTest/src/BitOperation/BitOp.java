package BitOperation;

public class BitOp {
	//and : 두개다 1일 경우 1 , 하나라도 다르면 0
	//1001 <<2    --> 100100  
	//1001 >>2    -->10
	// XOR :서로 달라야 1, 같으면 0
	
	//num에 i번째 인덱스가 1인지 0인지 boolean반환 메서드
	//1이면 true
	//0이면 false
	static boolean getBit(int num, int i) {
		//and연산으로 현재 숫자와 
		//1을 i만큼 왼쪽으로 쉬프트한 숫자를 연산하기
		//i가3이면 1은 -> 1000이 되고
		//num이 9면  -> 1001이 니까
		// 1001 & 1000 을 연산하면 1000 이된다 -> 0이 아니기 때문에 true반환
		//num이 5면 -> 0101이니까
		// 0101 &1000을 연산하면 0000이 되고 ->0이기 때문에 false반환
		
		return (num &(1<<i)) !=0;
	}
	
	//해당 인덱스를 1로 세팅한 값을 반환
	// or연산으로 기존에 1이면 1로, 0이면 1로 바꾼다
	// 0101 | 1000 -> 1101반환
	static int setBit(int num , int i) {
		return num | (1<<i);
	}
	
	//해당 인덱스를 0으로 세팅하기
	// num =9
	// 1001 & 0111 -> 0001 즉 인덱스 3이 0으로 바뀐다
	static int clearBit(int num, int i) {
		// ~ 연산은 비트로 반대로 바꾼다. 1000 -> 0111
		return num & ~(1<<i);
	}
	
	//해당 index 기준으로 왼쪽 비트 전부 0으로 세팅하기
	// 1000 = 1<<3
	// 1000 -1 = 0111
	static int clearLeftBit(int num, int i) {
		return num &((1<<i)-1);
	}
	
	//해당 index부터 오른쪽 비트 전부 0으로 세팅하기
	// 1111.......11111 = -1
	// 111...0000= -1 <<(인덱스3+1) 인덱스 포함해서 오른쪽으로 0만들기 위해 밀기 
	
	static int clearRightBit(int num, int i) {
		return num &((-1 << (i+1)));
	}
	
	public static void main(String[] args) {

		//해당 인덱스가 0인지 1인지 확인하기

		System.out.println(getBit(9,3));// 1001  true

		System.out.println(getBit(5,3));//0101 false
		
		System.out.println(setBit(5,3)); //0101 -> 1101 ->13
		
		System.out.println(clearBit(9,3)); //1001 ->0001 ->1
		
		//169 = 10101001 을 왼쪽부터 3번째 인덱스까지 다 0으로 세팅하기
		System.out.println(clearLeftBit(169,3));//00000001
		System.out.println(clearRightBit(169,3));//10100000
	}
}
