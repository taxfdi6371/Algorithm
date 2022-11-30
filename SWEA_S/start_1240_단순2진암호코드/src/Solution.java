import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			System.out.print("#" + test_case + " ");

			int height = sc.nextInt();
			int width = sc.nextInt();
			sc.nextLine();

			int[][] arr = new int[height][width];
			int[][] code = { { 0, 0, 0, 1, 1, 0, 1 }, { 0, 0, 1, 1, 0, 0, 1 }, { 0, 0, 1, 0, 0, 1, 1 },
					{ 0, 1, 1, 1, 1, 0, 1 }, { 0, 1, 0, 0, 0, 1, 1 }, { 0, 1, 1, 0, 0, 0, 1 }, { 0, 1, 0, 1, 1, 1, 1 },
					{ 0, 1, 1, 1, 0, 1, 1 }, { 0, 1, 1, 0, 1, 1, 1 }, { 0, 0, 0, 1, 0, 1, 1 } };
			int[] result = new int[8];
			int rCount = 0;
			int rIdx = 0;

			for (int i = 0; i < height; i++) {
				String s = sc.nextLine();
				for (int j = 0; j < width; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}

			boolean flag = false;
			int tempIdx = -1;
			int cCount = 0;

			for (int i = 0; i < height; i++) {
				for (int j = 0; j < width - 7; j++) {
					if (arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i][j + 3] == 0) { // 0이 연속으로 4번 나오는 경우는 암호코드에 없다
						continue;
					}
					cCount = rCount; // 지금까지 찾은 개수를 저장
					for (int k = 0; k < 10; k++) { // 암호코드 0 ~ 9
						int count = 0;
						int idx = j;
						for (int l = 0; l < 7; l++) { // 비트 자릿수 검사
							if (arr[i][idx] == code[k][l]) {
								count++;
								idx++;
							} else {
								break;
							}
						}
						if (count == 7) { // 암호코드 하나를 찾으면
							if (rCount == 0) {
								tempIdx = j + 1;
							}
							result[rIdx++] = k; // 암호코드 숫자 저장
							rCount++; // 갯수 증가
							j += 6; // 다음 검사 지점을 알림
							break;
						}
					}
					if (cCount > 0 && cCount == rCount) { // 중간에 검색에 실패하는 경우
						rCount = 0;
						rIdx = 0;
						j = tempIdx;
						tempIdx = -1;
					}
					if (rCount == 8) { // 암호코드를 모두 찾으면
						flag = true; // 종료
						break;
					}
				}
				if (flag) {
					break;
				}
			}

			int check = ((result[0] + result[2] + result[4] + result[6]) * 3) + (result[1] + result[3] + result[5])
					+ result[7];
			if (check % 10 == 0) { // 정상결과
				int sum = 0;
				for (int i : result) {
					sum += i;
				}
				System.out.println(sum);
			} else {
				System.out.println(0);
			}
		}
	}

}