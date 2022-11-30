import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// Sort, 2 pointer
public class Main {

	static int N;
	static int[] arr;
	
	static boolean check(int i) {
		int s = 0;
		int e = N -1;
		
		while(s < e){
			if(s == i) s++;
			if(e == i) e--;
			if(s == e) break;
			
			int sum = arr[s] + arr[e];
			
			if(sum == arr[i])
				return true;
			else if(sum < arr[i])
				s++;
			else if(sum > arr[i])
				e--;
			
		}
		
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);

		int result = 0;
		
		for (int i = 0; i < N; i++) {
			if(check(i))
				result++;
		}
		
		System.out.print(result);

		br.close();
	}

}
/*// HashMap
public class Main {
	
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Map<Integer, Boolean> dMap = new HashMap<>();
		boolean flag = false;
		
		Map<Integer, Boolean> map = new HashMap<>();
		
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			if (arr[i] == 0)
				flag = true;
			
			if(flag) {
				if (!dMap.containsKey(arr[i]))
					dMap.put(arr[i], true);	
				else {
					map.put(arr[i], true);
				}
			}
		}
		
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j || arr[i] == 0 || arr[j] == 0)
					continue;
				
				int k = arr[i] + arr[j];
				map.put(k, true);
			}
		}
		
		int result = 0;
		
		for (int i = 0; i < n; i++) {
			if (map.containsKey(arr[i]))
				result++;
		}
		
		System.out.print(result);
		
		br.close();
	}
	
}*/