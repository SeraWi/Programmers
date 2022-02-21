package kakao2019;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
	
	
	static Comparator<Food> CompTime = new Comparator<Food>() {

		@Override
		public int compare(Food a, Food b) {
			// 시간 순으로 오름차순
			return a.time - b.time;
		}
		
	};
	
	
	static Comparator<Food> CompIdx = new Comparator<Food>() {

		@Override
		public int compare(Food a, Food b) {
			//idx 로 오름차순
			return a.idx - b.idx;
		}
		
	};
	
	public static void main(String[] args) {
		List<Food>foods = new ArrayList<>();
		foods.add(new Food(4, 3));
		foods.add(new Food(100, 1));
		foods.add(new Food(10, 2));
		
		foods.sort(CompTime); //time 으로 정렬
		
		for( Food food : foods) {
			System.out.println(food.idx +"," + food.time);
		}
		
		System.out.println("------------------------");
		foods.sort(CompIdx); //idx로 정렬
		
		for( Food food : foods) {
			System.out.println(food.idx +"," + food.time);
		}
		
		
	}
}

class Food{
	int time;
	int idx;
	
	Food(int t , int i){
		time = t;
		idx = i;
	}
}
