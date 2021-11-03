package java1103;

public class OtherSolution2 {
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
				tempL = numbers[i];
				break;
			case 3: case 6: case 9:
				answer += "R";
				tempR = numbers[i];
				break;
			default:
				String tempHand = checkHand(numbers[i]);
				if(tempHand.equals("R"))
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
		if(tempNum == 0) tempNum = 11;

		leftDistance = Math.abs((tempNum-1)/3 - (tempL-1)/3) + Math.abs((tempNum-1)%3 - (tempL-1)%3);
		rightDistance = Math.abs((tempNum-1)/3 - (tempR-1)/3) + Math.abs((tempNum-1)%3 - (tempR-1)%3);
		System.out.println(tempNum + ": " + leftDistance + ", " + rightDistance);
		return ((leftDistance == rightDistance)? myhand: (leftDistance > rightDistance)? "R": "L");

	}
}
