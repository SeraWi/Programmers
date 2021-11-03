package java1103;

public class javaArray {
	static int[][] numpadPos = {
			{3,1}, //0 [0][0] [0][1]
			{0,0}, //1 [1][0] [1][1]
			{0,1}, //2 [2][0] [2][1]
			{0,2}, //3
			{1,0}, //4
			{1,1}, //5
			{1,2}, //6
			{2,0}, //7
			{2,1}, //8
			{2,2}  //9 [9][0]
	};
	
	public static void main(String[] args) {
		int [] arr = numpadPos[7]; //2차원 배열에서 1차열 배열 뽑기
		System.out.println(arr[0]);
		System.out.println(arr[1]);
	}
}
