import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Main {
	
	static int N;
	static int[] arr;

	static boolean func(int idx) {
		// 반복을 검사할 Set
		Set<Integer> set = new HashSet<>();
		
		// 첫번째 정수 삽입
		set.add(idx);
		
		// 집합에 들어간 마지막 정수
		int lastNumber = idx;
		
		while(true){
			// 다음 집합에 넣을 후보 숫자
			int candidate = arr[lastNumber];
			
			// 다음 숫자가 들어있지 않다면 삽입
			if(!set.contains(candidate)) {
				set.add(candidate);
				lastNumber = candidate;
				// 다음 숫자가 set에 포함되어있고, 제일 처음 들어온 정수(idx)와 같다면 
			} else if(candidate == idx) {
				return true;
				// 다음 숫자가 set에 포함되어있고, 제일 처음 들어온 정수(idx)와 같지 않다면 
			} else {
				return false;
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		arr = new int[N + 1];

		// 둘째 줄 숫자 집합
		Set<Integer> secondNumberSet = new HashSet<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			secondNumberSet.add(arr[i]);
		}
		
		// 정답 정수 리스트
		ArrayList<Integer> resultNumberList = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			// 둘째 줄 숫자 집합에서 나오지 않은 수는 정답이 될 수 없다.
			if(secondNumberSet.contains(i) && func(i)) {
				resultNumberList.add(i);
			}
		}
		
		// 결과 출력
		System.out.println(resultNumberList.size());
		for (int i = 0; i < resultNumberList.size(); i++) {
			System.out.println(resultNumberList.get(i));
		}
		
		br.close();
	}

}
