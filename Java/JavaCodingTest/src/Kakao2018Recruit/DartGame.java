package Kakao2018Recruit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// 정규식 사용 풀이
public class DartGame {
	//갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다. 
	//다트 게임의 점수 계산 로직은 아래와 같다.
	//옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 
	//아차상(#) 당첨 시 해당 점수는 마이너스된다.	
	//스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)


	static int[] sum = new int[3];

	static int solution(String msg){
        String reg = "([0-9]{1,2}[S|T|D][*|#]{0,1})";
        Pattern p = Pattern.compile(reg+reg+reg);
        Matcher m = p.matcher(msg);
        m.find();
        for(int i=1; i<=m.groupCount(); i++){
            Pattern p1 = Pattern.compile("([0-9]{1,2})([S|T|D])([*|#]{0,1})");
            Matcher m1 = p1.matcher(m.group(i));
            m1.find();
            sum[i-1] = (int)Math.pow(Integer.parseInt(m1.group(1)), getpow(m1.group(2)));
            setting(i,m1.group(3));
        }
        return(sum[0]+ sum[1]+ sum[2]);
    }
	
	// 보너스 점수 계산 메서드
	static void setting(int idx, String msg) {
		if (msg.equals("*")) {
			sum[idx-1] *=2;
			// 두번째 기회에 *이 나오면 앞에 점수도 2배 시키기
			if(idx >1) {
				sum[idx-2] *=2;
			}
		}else if(msg.equals("#")){
			sum[idx-1] *=-1;
		}
	}
	
	// SDT에 따른 지수 반환 메서드
	static int getpow(String mag) {
		if(mag.equals("S")) {
			return 1;
		}else if(mag.equals("D")) {
			return 2;
		}else {
			return 3;
		}
		
		
	}

	public static void main(String[] args) {
		String dartResult ="1D2S#10S";
		System.out.println(solution(dartResult));
	}
}
