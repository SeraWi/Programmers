package kakao2019;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

//sublist : list일정부분만 자르기
// sublist(fromIdx, toIdx) : fromIdx 포함하고 toIdx 앞까지(포함하지 않음)list 만듬

/*
Food 타입의 list를 만들고 , 시간이 짧은 순서대로 정렬 시킨다.
for 문을 돌면서, 1초씩 도는 방식이 아니라 한번에 음식 갯수만큼을 제거하는 식으로 효율성을 높인다.
가장 짧은 시간이 걸리는 음식  * 음식 갯수
그 다음 짧은 시간이 걸리는 음식 * 남은 음식 갯수
k 초 가 넘어가는 순간 , idx순서로 다시 list를 정렬한다.
나머지 연산으로 몇번째 부터 먹게 되는지 return 한다.
4초가 남았고 음식 3개라면  4%3= 1이다. 그렇다면 idx=2인 음식부터 먹으면 된다. 
*/


public class MukbangLive {
    public int solution(int[] food_times, long k) {
        List<Food> foods = new LinkedList<Food>();
        int n= food_times.length;
        
        for( int i =0;i<n ; i++) {
        	//					시간,			idx 1부터 시작
        	foods.add(new Food(food_times[i], i+1));
        }
        // 먹는 시간 짧은 순서대로 정렬(오름차순 정렬)
        foods.sort(CompTime);
        
        int pretime = 0;
        int i = 0;
        
        for(Food f : foods) {
        	long diff = f.time - pretime;
        	if (diff != 0) {
        		// 차이 * 음식 갯수
        		long spend = diff * n;
        		if(spend <= k) {
        			k -= spend;
        			pretime = f.time;
        		}else {
        			k %=n;
        			// 남아 있는 음식을 순서대로 다시 정렬
        			foods.subList(i, food_times.length).sort(CompIdx);
        			return foods.get(i +(int) k).idx;
        		}
        	}
        	++i;//index 증가( food 한턴 돌면 idx 증가한다)
        	--n;// 남아있는 음식 줄이기
        	
        }
        
        
        return -1;
    }
    
    class Food{
    	int time;
    	int idx;
    	
    	Food(int t, int i){
    		time = t;
    		idx = i;
    	}
    }
    
    Comparator<Food> CompTime = new Comparator<Food>() {
    	public int compare(Food a, Food b) {
    		return a.time- b.time;
    	}
    };
    
    Comparator<Food> CompIdx = new Comparator<Food>() {
    	public int compare(Food a, Food b) {
    		return a.idx- b.idx;
    	}
    };
    
    public static void main(String[] args) {
		
	}
    

}
