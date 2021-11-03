package java1103;

import java.awt.print.Printable;

public class MySolution {
	public static String solution() {
		//numbers : 순서대로 누를 번호가 담긴 배열
		//hand : right or left
		
		//현재 왼손의 위치, 오른손의 위치를 알아야
		// 고정된 숫자 -> 고정된 손
		// 2,5,8,0 이 문제임
		
		
		int[]numbers= {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand ="right";
		
		String answer = "";
		int lefthand = 10; // 왼손위치 *
		int righthand = 12; //오른손 위치 #
		
		int 거리 = Math.abs(lefthand -numbers[0])%3 + Math.abs(lefthand-numbers[0])/3;
		
		
		for(int i=0; i<numbers.length; i++) {
			if(numbers[i]==1 || numbers[i]== 4 || numbers[i]== 7) {
				answer +="L";
				lefthand = numbers[i];
			}else if(numbers[i]==3 || numbers[i]== 6 || numbers[i]== 9) {
				answer += "R";
				righthand = numbers[i];
			}else if(numbers[i]==2 || numbers[i]== 5 || numbers[i]== 8 || numbers[i] ==0) {
				// 이전 손의 위치에 따라 달라짐
				//이부분 해결이 안됨
				if(Math.abs(numbers[i]-lefthand) > Math.abs(numbers[i]-righthand)) {
					answer +="R";
					righthand = numbers[i];
				} else if(Math.abs(numbers[i]-lefthand) < Math.abs(numbers[i]-righthand)) {
					answer +="L";
					lefthand = numbers[i];
				}else {
					if(hand.equals("left")) {
						answer +="L";
						lefthand = numbers[i];
					}else {
						answer +="R";
						righthand = numbers[i];
					}
				}
			}
		}

		
		return answer;
	}
	
	public static void main(String[] args) {
		
		System.out.println(solution());
	}
}
