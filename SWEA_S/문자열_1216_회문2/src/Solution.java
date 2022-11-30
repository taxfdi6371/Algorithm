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

			char[][] arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int length = 1;

			// 가로 검사
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 99; k > 0; k--) {
						// 나올 수 있는 길이가 기존 length보다 길고 양 끝의 문자가 일치하다면
						if ((k - j + 1 > length) && (arr[i][j] == arr[i][k])) {
							int temp = k - j + 1; // 임시 길이
							int sIdx = j + 1;
							int eIdx = k - 1;
							while (arr[i][sIdx] == arr[i][eIdx]) {
								if (sIdx < eIdx) {
									sIdx++;
									eIdx--;
									// 양 끝 인덱스가 서로 일치(홀수)하거나 범위를 벗어나면(짝수)
								} else if (sIdx >= eIdx) {
									if (length < temp) {
										length = temp;
									}
									break;
								}
							}
						}
					}

				}
			}
			// 세로 검사
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 99; k > 0; k--) {
						if ((k - j + 1 > length) && (arr[j][i] == arr[k][i])) {
							int temp = k - j + 1; // 임시 길이
							int sIdx = j + 1;
							int eIdx = k - 1;
							while (arr[sIdx][i] == arr[eIdx][i]) {
								if (sIdx < eIdx) {
									sIdx++;
									eIdx--;
								} else if (sIdx >= eIdx) {
									if (length < temp) {
										length = temp;
									}
									break;
								}
							}
						}
					}

				}
			}

			System.out.println(length);
		}
	}
}