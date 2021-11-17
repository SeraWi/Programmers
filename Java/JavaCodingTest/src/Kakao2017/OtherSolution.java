package Kakao2017;

public class OtherSolution {
	static String[] arr = {"A","C","F","J","M","N","R","T"};
	static String [] result = new String[8];
	static boolean[]used = new boolean[8];
	static int answer;
	public static int solution(int n, String [] data) {

		//  n : 조건의 갯수
		// data : 조건들
		answer = 0;

		perm(0,data);

		return answer;
	}
	static void perm(int cnt, String[] data){
		if(cnt==8){
			String s = "";
			for(int i=0; i<arr.length; i++){
				s+=result[i];
			}
			for(int i=0; i<data.length; i++){
				int start = s.indexOf(data[i].charAt(0));//조건의 첫번쨰 글자를 해당하는 정렬에서 찾기
				int end = s.indexOf(data[i].charAt(2));
				//									 거리계산
				if(data[i].charAt(3)=='=' && Math.abs(start-end)-1!=data[i].charAt(4)-'0'){
					//여기에 해당하면 조건 불만족임, for문 중지
					return;
				}else if(data[i].charAt(3)=='<' && Math.abs(start-end)-1>=data[i].charAt(4)-'0'){
					return;
				}else if(data[i].charAt(3)=='>' && Math.abs(start-end)-1<=data[i].charAt(4)-'0'){
					return;
				}
			}// for end
			answer++;
			return;
		}// if end
		
		for(int i=0; i<arr.length; i++){
			if(!used[i]){
				used[i] = true;
				result[cnt] = arr[i];
				perm(cnt+1, data);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		int n = 2;
		String [] data = {"N~F=0","R~T>2"};
		System.out.println(solution(n,data));
	}


}
