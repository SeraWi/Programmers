package Lv1;
import java.util.Arrays;


class MySolution_1027 {
	// 결과 3단계 실패
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //participant에는 있지만 completion에는 없는 사람을 return -> 단 한명 return 
        //오름차순 정렬시키기
        Arrays.sort(participant);//eden, leo, kiki
        Arrays.sort(completion); //eden, kiki
        
        
        //participant 수
        int pNum = participant.length;
        //completion수(PNum보다 하나작다)
        int cNum = completion.length;
        
        //participant[0] 과 completion[0] ~completion[cNum-1] 비교
        
        
        for(int i=0; i<pNum; i++){
            for(int j=0; j<cNum; j++){
                if(!participant[i].equals(completion[j])){
                   answer = participant[i];
                }else{
                    continue;
                }
            }//for끝
          
                        
        }//for 끝
        
        
        return answer;
    }
}