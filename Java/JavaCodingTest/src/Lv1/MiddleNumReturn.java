package Lv1;

public class MiddleNumReturn {
	public String solution(String s) {
        String answer = "";
        //0,1,2,3,4,5,6 7/2 
        if(s.length() %2 == 1) {
        	//홀수 
        	// char -> String 으로 바꾸기 : String.valueOf()
        	answer = String.valueOf(s.charAt(s.length()/2));
        }else{
        	//짝수
        	answer = String.valueOf(s.charAt((s.length()/2)-1))+String.valueOf(s.charAt(s.length()/2));
        }
        
        return answer;
    }
	
	public String getMiddle(String s) {
		// 		 자르기		begin idx			end idx
		return s.substring((s.length()-1)/2, s.length()/2+1);
	}
}
