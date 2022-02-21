package kakao2019;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MukbangLive2 {
	public int solution(int[] food_times, long k) {
		List<Food> foods = new LinkedList<Food>();
		
		int n = food_times.length;
		
		
		for( int i= 0; i<n;i++) {
			foods.add(new Food(food_times[i], i+1));
		}
		
		foods.sort(CompTime);
		
		int pretime = 0;
		int i= 0;
		
		for( Food f  : foods) {
			long diff = f.time- pretime;
			
			if(diff != 0) {
				long spend = diff * n;
				if(spend <= k) {
					k -= spend;
					pretime = f.time;
				}else {
					 k%=n;
					 
					 foods.subList(i, food_times.length).sort(CompIdx);
					 return foods.get(i+(int)k).idx;
				}
				
			}
			++i;
			--n;
		}
		return -1;
	}
	class Food{
		int time;
		int idx;
		
		Food(int time, int idx){
			this.time = time;
			this.idx= idx;
		}
	}
	
	Comparator<Food> CompTime = new Comparator<Food>() {

		@Override
		public int compare(Food a, Food b) {
			// TODO Auto-generated method stub
			return a.time - b.time;
		}
		
	};
	
	Comparator<Food> CompIdx =new Comparator<Food>() {
		public int compare(Food a, Food b) {
			return a.idx- b.idx;
		}
	};
	
}
