package java1027;

class Solution {
	// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	// 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //participant에는 있지만 completetion에는 없는 사람을 return -> 단한명 return 
        
        //participant 수
        int pNum = participant.length;
        //completion수
        int cNum = completion.length;
        
        //participant[0] 과 completion[0] ~completion[cNum-1] 비교
        
        for(int i=0; i<pNum; i++){
            for(int j=0; j<cNum; j++){
                if(!participant[i].equals(completion[j])){
                          answer = participant[i];             
                            break;
                }
            }//for끝
          
            
            
        }//for 끝
        
        
        return answer;
    }
}