package Kakao2021Recruit;

import java.util.ArrayList;
import java.util.List;


// 정확성 테스트 모두 통과, 효율성 테스트 시간초과
public class QuerySearch {
	//각 문의조건에 해당하는 사람들의 숫자를 순서대로 배열에 담아 return
	// info: java backend junior pizza 150 , python frontend senior chicken 150
	// query : 검색할 키워드 java and backend and junior and pizza 100
	// python and frontend and - and chicken 200
	
	// class 정의해서, 사용자 정보를 객체로 저장, index 같이 저장
	// query 검색할 때, query 검색용 arraylist만들기 -> 계속 for문 돌려가면서 검사?
	//사용자 정보 담은 list
    static List<Candi> candiInfo = new ArrayList<>();

    
	
	
    public static List<Integer> solution(String[] info, String[] query) {
        List<Integer> answer = new ArrayList<>();
        
        
        for(String infos : info) {
        	String[] infosplits = infos.split(" "); //공백으로 나누기
        	// 정보 네개 쪼개서 넣기
        	candiInfo.add(new Candi(infosplits[0],infosplits[1],infosplits[2],infosplits[3],Integer.parseInt(infosplits[4])));
        }
        
        
        //해당 Query를 만족하는지 check하기
        
        
        for(String querys : query) {
        	String[] qsplit = querys.split(" ");
        	//java and backend and junior and pizza 100
        	// 0   1   2        3   4      5  6     7
        	// 0,2,4,6,7
          	
        	int qreturn = queryCheck(candiInfo, qsplit[0],qsplit[2],qsplit[4],qsplit[6],Integer.parseInt(qsplit[7]));
        	answer.add(qreturn);
        	
        }
        System.out.println(answer.toString());
        
        
        return answer;
    }
    
    public static int queryCheck(List<Candi>candiInfo,
    		String lang, String job, String career, String food, int score
    		) {
    	int sum =0;
    	
    	//candiInfo를 받아서 query 문의 조건을 비교하여 해당하는 지원자 수 return
    	// - 인지 확인
    	// 효율성 고려..
    	
    	
    	for(int i =0; i<candiInfo.size(); i++) {
    		
    		if(candiInfo.get(i).lang.equals(lang) || lang.equals("-")) {
    			
    			if(candiInfo.get(i).job.equals(job) || job.equals("-")) {
    				
    				if(candiInfo.get(i).career.equals(career) || career.equals("-")) {
    					
    					if(candiInfo.get(i).food.equals(food) || food.equals("-")) {
    						
    						if(candiInfo.get(i).score >= score) {
    							sum += 1;
    						}
    					}
    				}
    				
    			}
    		}
    		
    		
    		
    	}
    	
    	
    	
    	
    	return sum;
    }
    //query check 메서드
    
    
    public static void main(String[] args) {
		String[] info = {"java backend junior pizza 150",
				"python frontend senior chicken 210",
				"python frontend senior chicken 150",
				"cpp backend senior pizza 260",
				"java backend junior chicken 80",
				"python backend senior chicken 50"};
		
		String [] query = {"java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200",
				"cpp and - and senior and pizza 250",
				"- and backend and senior and - 150",
				"- and - and - and chicken 100",
				"- and - and - and - 150"};
		
		
		solution(info, query);
	}
    
    
    
    
}

class Candi{
	
	String lang;
	String job;
	String career;
	String food;
	int score;
	
	public Candi(String lang, String job, String career,String food, int score) {
		this.lang = lang;
		this.job = job;
		this.career  = career;
		this.food= food;
		this.score = score;
	}
}