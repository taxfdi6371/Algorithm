import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution {

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = Integer.parseInt(sc.nextLine());

			int result = 1;

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine());

				st.nextToken(); // 정점 번호 제거

				char c = st.nextToken().charAt(0); // 데이터

				if (st.hasMoreTokens()) { // 단말 노드가 아닐때
					if (c >= '0' && c <= '9') { // 숫자가 온다면 0
						result = 0;
					}
				} else { // 단말 노드일 때
					if (c < '0' || c > '9') { // 연산자가 온다면 0
						result = 0;
					}
				}
			}

			System.out.println(result);
		}
	}

}