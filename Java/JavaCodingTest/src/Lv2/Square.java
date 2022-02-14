package Lv2;

/*
 * 멀쩡한 사각형 
 * 가로의 길이 W와 세로의 길이 H가 주어질 때,
 * 사용할 수 있는 정사각형의 개수를 구하는 solution 함수를 완성해 주세요.*/
public class Square {
	public static long solution(int w, int h) {
		// W : 가로  h : 세로
		// 유클리드 호제법??

		long min = Math.min(w, h);
		long max =Math.max(w, h);
		long remain =1;
		while(remain>0) {
			remain = max %min;
			max = min;
			min = remain;
		}
		// max : 최대 공약수임
		long answer = (long)w * (long) h - max*(w/max + h/max-1);

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(solution(8,12));
	}
}
