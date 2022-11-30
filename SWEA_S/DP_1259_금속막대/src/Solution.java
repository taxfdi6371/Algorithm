import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();

			int[][] arr = new int[N][2];

			for (int i = 0; i < N; i++) {
				arr[i][0] = sc.nextInt(); // 수나사
				arr[i][1] = sc.nextInt(); // 암나사
			}

			// 시작 지점 찾기
			int start = 0;
			for (start = 0; start < N; start++) {
				int i = 0;
				for (i = 0; i < N; i++) {
					// 수나사와 맞는 암나사가 있으면 break
					if (arr[start][0] == arr[i][1]) {
						break;
					}
				}
				// 수나사가 맞는 암나사를 못찾는다면 break;
				// start가 시작지점이 있는 인덱스가 됨
				if (i == N) {
					break;
				}
			}

			StringBuilder sb = new StringBuilder();
			// 시작 지점 추가
			sb.append(arr[start][0]).append(" ").append(arr[start][1]).append(" ");

			int f = arr[start][1];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 암나사와 수나사의 크기가 일치하는 것을 찾으면
					if (f == arr[j][0]) {
						sb.append(arr[j][0]).append(" ").append(arr[j][1]).append(" ");
						f = arr[j][1];
						break;
					}
				}
			}			
			System.out.println("#" + test_case + " " + sb);
		}
	}

}