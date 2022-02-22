package kakao2020;

// 가사 검색
// Trie 자료 구조 이용
public class SearchTrie {
	
	class Trie{
		Trie[]child = new Trie[26]; //알파벳 갯수만큼
		int count; //노드의 카운트
		int aletter = Character.getNumericValue('a'); //a에 해당하는 아스키 값
		
		// 노드 추가하기
		void insert(String str) {
			Trie curr =this;
			for (char ch : str.toCharArray()) {
				// 링크 타고 내려가기 전에 카운트 증가
				curr.count ++;
				// a = 0, b= 1 ....이런식으로 idx 계산
				int idx = Character.getNumericValue(ch)-aletter;
				
				// idx해당하는 노드가 존재하는지 확인
				if(curr.child[idx] == null) {
					// 없으면 생성
					curr.child[idx] = new Trie();
				}
				curr = curr.child[idx];
			}
			// 마지막 노드도 count 증가시키기
			curr.count++;
		}
		//cnt 반환
		int search(String str) {
			Trie curr = this;
			for( char ch : str.toCharArray()) {
				if(ch == '?') {
					// 현재 위치 카운트 반환
					// 문제 조건상 항상 ?으로 끝나기 때문에, 반드시 return 한다.
					return curr.count;
				}
				curr = curr.child[Character.getNumericValue(ch) - aletter];
				if(curr == null) {
					// 키워드에 해당하는 단어 없음
					return 0;
				}
			}
			// 문제 조건 상 여기까지 내려오는 경우는 없다.
			return curr.count;
		}
	}
	
	Trie[] TrieRoot = new Trie[10000]; // 정방향 트라이
	Trie[] ReTrieRoot = new Trie[10000]; // 역방향 트라이
			
    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length]; 
        
        int ansIdx = 0;
        
        //insert하기
        for( String str : words) {
        	int idx = str.length()-1;
        	//최초의 경우 insert
        	if( TrieRoot[idx] == null) {
        		TrieRoot[idx] = new Trie(); // 정방향
        		ReTrieRoot[idx] = new Trie(); // 역방향
        	}
        	// 정방향
        	TrieRoot[idx].insert(str);
        	// 역방향
        	str = new StringBuilder(str).reverse().toString();
        	ReTrieRoot[idx].insert(str);
        	
        }
        
        // 쿼리문 검색
        for( String str: queries) {
        	int idx = str.length()-1;
        	if(TrieRoot[idx] == null) {
        		answer[ansIdx++] =0;
        		continue;
        	}
        	
        	if(str.charAt(0)!='?') {
        		//쿼리 시작 ?아니라면 정방향 서치
        		answer[ansIdx ++] = TrieRoot[idx].search(str);
        	}else {
        		//쿼리 시작이 ?이라면 역방향 서치
        		str = new StringBuilder(str).reverse().toString();
        		answer[ansIdx++]=ReTrieRoot[idx].search(str);
        	}
        }
        
        
        return answer;
    }

}
