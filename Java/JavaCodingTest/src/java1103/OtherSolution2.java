package java1103;

public class OtherSolution2 {
	// 특수문자를 10과 12로 생각
	int tempL = 10;
	int tempR = 12;
	String myhand;
	
	public String solution(int[] numbers, String hand) {
		myhand = ((hand.equals("right"))? "R": "L");
		String answer = "";
		for(int i=0 ; i< numbers.length ; i++) {
			switch(numbers[i]) {
			case 1: case 4: case 7:
				answer += "L";
				// 왼손의 위치 저장
				tempL = numbers[i];
				break;
			case 3: case 6: case 9:
				answer += "R";
				// 오른손 위치 저장
				tempR = numbers[i];
				break;
			default:
				// 2,5,8,0 의 경우
				String tempHand = checkHand(numbers[i]);
				if(tempHand.equals("R"))
					// 누른 손 저장하기 --> 0번 누르면 11로 대체 시키기
 					tempR = numbers[i] + ((numbers[i] == 0)? 11:0);
				else tempL = numbers[i] + ((numbers[i] == 0)? 11:0);
				answer += tempHand;
				break;
			}
		}
		return answer;
	}

	private String checkHand(int tempNum) {
		int leftDistance = 0;
		int rightDistance = 0;
		if(tempNum == 0) tempNum = 11; // 0을 11로 대체

		leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3) + Math.abs((tempNum-1)%3 - (tempL-1)%3);
		rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3) + Math.abs((tempNum-1)%3 - (tempR-1)%3);
		System.out.println(tempNum + ": " + leftDistance + ", " + rightDistance);
		// 				거리 같아 ?				나의 원래 손잡이 : 왼손 거리 크다?                            오른손쓰기 : 왼손쓰기
		return ((leftDistance == rightDistance)? myhand: (leftDistance > rightDistance)? "R": "L");

	}
}
