package ASCII;

public class StringCnt {

	// 영어소문자, 영어대문자, 숫자 , 공백이 몇개씩 존재하는지 갯수반환

	public static void solution(String S) {
		int lower = 0;
		int upper = 0;
		int num = 0;
		int blank = 0;


		for( int i= 0; i<S.length(); i++) {
			char c = S.charAt(i);

			if(c>= 97 && c <=122) {
				lower++;
			}else if(c>=65 && c <=90) {
				upper++;
			}else if(c>=48 && c<=57) {
				num++;
			}else {
				blank++;
			}
		}
		System.out.println("lower : " + lower);
		System.out.println("upper : "+ upper);
		System.out.println("number : " + num);
		System.out.println("blank : " + blank);

	}

	public static void main(String[] args) {
		solution("This is String and 1");
	}
}