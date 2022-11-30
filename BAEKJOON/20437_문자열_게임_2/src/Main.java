import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
		
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int sNum = 10001; // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
			int lNum = 0; // 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열의 길이
			String W = br.readLine(); // 알파벳 소문자로 이루어진 문자열 W
			int K = Integer.parseInt(br.readLine()); // 양의 정수 K
			
			ArrayList<Integer>[] al = new ArrayList[26]; // a-z 출현한 index를 저장할 ArrayList 배열
			
			// ArrayList 배열 초기화
			for (int i = 0; i < al.length; i++) {
				al[i] = new ArrayList<>();
			}
			
			// 문자 c의 출현 index 추가
			for (int i = 0; i < W.length(); i++) {
				char c = W.charAt(i);
				
				al[c - 'a'].add(i);
			}
			
			// a-z 모두 검사
			for (int i = 0; i < al.length; i++) {
				// 특정 문자가 K보다 적게 출현 했다면 검사하지 않는다.
				if(al[i].size() >= K) {
					for (int j = 0; j < al[i].size() - (K-1); j++) {
						// 문자 K개를 포함한 시작  index 부터 마지막 index 
						int start = al[i].get(j);
						int last = al[i].get(j + (K - 1));
						
						sNum = Math.min(sNum, last - start + 1);
						lNum = Math.max(lNum, last - start + 1);
					}
				}
			}
			
			// 
			if(sNum == 10001) {
				System.out.println(-1);
			} else {
				System.out.println(sNum + " " + lNum);
			}
		}
		
		br.close();
	}

}
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
//public class Main {
//	static int K;
//	static String W;
//	static int sNum;
//	static int lNum;
//	
//	static int check(int idx, char c) {
//		int count = 0;
//		for (int i = idx; i < W.length(); i++) {
//			if(c == W.charAt(i)) {
//				count++;
//			}
//		}
//		
//		return count;
//	}
//	
//	public static void main(String[] args) throws Exception {
//		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
//		
//		int T = Integer.parseInt(br.readLine());
//
//		for (int tc = 0; tc < T; tc++) {
//			W = br.readLine();
//			K = Integer.parseInt(br.readLine());
//			sNum = 10001;
//			lNum = 0;
//			
//			for (int i = 0; i < W.length(); i++) {
//				
//			}
//			
//		}
//		
//		br.close();
//	}
//
//}