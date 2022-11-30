
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	// 스위치문의 케이스는 상태 번호를 의미한다. q0, q1...
	// 인식 가능한 스트링이 있다면 다음 상태로 전이, 없으면 트랩 상태인 -1을 반환한다.
	public static int func(int q, String s) {
		int nextQ = -1;
		switch (q) {
		case 0:
			if (s.equals("100")) nextQ = 1;
			if (s.equals("01")) nextQ = 3;
			break;
		case 1:
			if (s.equals("0")) nextQ = 1;
			if (s.equals("1")) nextQ = 2;
			break;
		case 2:
			if (s.equals("100")) nextQ = 1;
			if (s.equals("1")) nextQ = 2;
			if (s.equals("01")) nextQ = 3;
			break;
		case 3:
			if (s.equals("100")) nextQ = 1;
			if (s.equals("01")) nextQ = 3;
			break;
		}
		return nextQ;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			String s = br.readLine();
			
			Stack<Integer> stack = new Stack<>();
			stack.push(0); // 초기 상태인 q0 삽입
			
			for (int i = 0; i < s.length(); i++) {
				// 정규표현식에 위배된다면 종료, 트랩 상태
				if(stack.peek() == -1) {
					break;
				}
				int nextQ = -1;
				if(i + 2 < s.length() && (stack.peek() == 0 || stack.peek() == 2 || stack.peek() == 3) && s.substring(i, i+3).equals("100")) {
					nextQ = func(stack.peek(), s.substring(i, i+3));
					i += 2; // 한번에 스트링을 3개 읽었으니 인덱스 점프
				} else if(i + 1 < s.length() && (stack.peek() == 0 || stack.peek() == 2 || stack.peek() == 3) && s.substring(i, i+2).equals("01")) {
					nextQ = func(stack.peek(), s.substring(i, i+2));
					i += 1; // 한번에 스트링을 2개 읽었으니 인덱스 점프
				} else {
					nextQ = func(stack.peek(), s.substring(i, i+1));					
				}
				
				stack.push(nextQ);
			}
			
			// 승인 상태에서 종료되었다면, YES 출력
			if(stack.peek() == 2 || stack.peek() == 3) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		
		br.close();
	}

}

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Stack;
//
//public class Main {
//
//	// dfa 그래프 인접행렬
//	// 상태 수 : 9개 (q0 ~ q8)
//	// 최대 간선 수 : 2개 (0, 1)
//	public static int[][] dfa = { { 7, 1 }, { 2, -1 }, { 3, -1 }, { 3, 4 }, { 7, 5 }, { 6, 5 }, { 3, 8 }, { -1, 8 }, { 7, 1 } };
//
//	public static void main(String[] args) throws Exception {
//		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));
//
//		int T = Integer.parseInt(br.readLine());
//
//		for (int tc = 0; tc < T; tc++) {
//			String s = br.readLine();
//
//			Stack<Integer> stack = new Stack<>();
//			stack.push(0); // 초기 상태인 0 삽입
//
//			for (int i = 0; i < s.length(); i++) {
//				// 정규표현식에 위배된다면 종료, 트랩 상태
//				if (stack.peek() == -1) {
//					break;
//				}
//
//				// dfa[현재 상태][입력 스트링]
//				int nextQ = dfa[stack.peek()][s.charAt(i) - '0'];
//				// 다음 상태를 스택에 담아준다.
//				stack.push(nextQ);
//			}
//
//			// 승인 상태에서 종료되었다면, YES 출력
//			if (stack.peek() == 4 || stack.peek() == 5 || stack.peek() == 8) {
//				System.out.println("YES");
//			} else {
//				System.out.println("NO");
//			}
//		}
//		br.close();
//	}
//}
