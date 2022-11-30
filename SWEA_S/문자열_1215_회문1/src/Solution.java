import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			System.out.print("#" + test_case + " ");

			int size = sc.nextInt();

			char[][] arr = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int count = 0;
			// 가로 검사
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - size + 1; j++) {
					if (arr[i][j] == arr[i][j + size - 1]) { // 문자의 양끝이 같으면
						int sIdx = j + 1;
						int eIdx = j + size - 2;
						while (arr[i][sIdx] == arr[i][eIdx]) {
							if (eIdx - sIdx <= 0) {
								count++;
								break;
							}
							if (eIdx - sIdx > 0) {
								sIdx++;
								eIdx--;
							}

						}
					}
				}
			}
			// 세로 검사
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - size + 1; j++) {
					if (arr[j][i] == arr[j + size - 1][i]) { // 문자의 양끝이 같으면
						int sIdx = j + 1;
						int eIdx = j + size - 2;
						while (arr[sIdx][i] == arr[eIdx][i]) {
							if (eIdx - sIdx <= 0) {
								count++;
								break;
							}
							if (eIdx - sIdx > 0) {
								sIdx++;
								eIdx--;
							}
						}
					}
				}
			}
			System.out.println(count);

		}
	}
}