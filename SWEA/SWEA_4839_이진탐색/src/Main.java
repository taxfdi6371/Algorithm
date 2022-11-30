import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input.txt"));

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			System.out.print("#" + test_case + " ");

			// 여기서부터 알고리즘 작성하세요.
			StringTokenizer st = new StringTokenizer(in.readLine());
			int P = Integer.parseInt(st.nextToken().toString()); // 전체 쪽 수

			// 0: 검색 구간 왼쪽, 1: 검색 구간 오른쪽, 2: 중간 페이지, 3: 찾을 쪽번호
			int[][] arr = new int[2][4];
			for (int i = 0; i < 2; i++) { // 초기화
				arr[i][0] = 1;
				arr[i][1] = P;
				arr[i][2] = P / 2;
				arr[i][3] = Integer.parseInt(st.nextToken().toString());
			}

			while (true) {
				if ((arr[0][2] == arr[0][3]) && (arr[1][2] == arr[1][3])) { // 무승부 조건
					System.out.println(0);
					break;
				} else if ((arr[0][2] == arr[0][3]) && (arr[1][2] != arr[1][3])) { // A승리 조건
					System.out.println("A");
					break;
				} else if ((arr[1][2] == arr[1][3]) && (arr[0][2] != arr[0][3])) { // B승리 조건
					System.out.println("B");
					break;
				}

				for (int i = 0; i < 2; i++) {
					if (arr[i][2] > arr[i][3]) {// 중간 페이지가 찾을 쪽 번호보다 큰 경우
						// 왼쪽은 그대로
						arr[i][1] = arr[i][2]; // 오른쪽을 중간페이지
						arr[i][2] = (arr[i][0] + arr[i][1]) / 2; // 중간 페이지
					} else if (arr[i][2] < arr[i][3]) {// 중간 페이지가 찾을 쪽 번호보다 작은 경우
						arr[i][0] = arr[i][2]; // 오른쪽을 중간페이지
						// 오른쪽은 그대로
						arr[i][2] = (arr[i][0] + arr[i][1]) / 2; // 중간 페이지
					}
				}
			}
		}
	}
}
