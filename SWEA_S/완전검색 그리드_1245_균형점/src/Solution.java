import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

	public static double calc(int x, int m, double p) {
		return m / ((p - x) * (p - x));
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		for (int test_case = 1; test_case <= t; test_case++) {
			System.out.print("#" + test_case + " ");

			int n = sc.nextInt(); // 좌표 개수
			int[][] arr = new int[n][2]; // 좌표, 질량를 순서 대로 저장할 배열

			for (int i = 0; i < n; i++) {
				arr[i][0] = sc.nextInt(); // x좌표
			}
			for (int i = 0; i < n; i++) {
				arr[i][1] = sc.nextInt(); // 질량
			}

			for (int i = 0; i < n - 1; i++) {
				double leftX = arr[i][0]; // 초기 왼쪽 좌표
				double rightX = arr[i + 1][0]; // 초기 오른쪽 좌표
				double p = 0;
				int count = 0;

				while (count <= 100) {
					double leftF = 0;
					double rightF = 0;

					p = (leftX + rightX) / 2.0; // 중점

					// 중점을 기준으로 왼쪽, 오른쪽 힘 구하기
					for (int j = 0; j < n; j++) {
						if (p > arr[j][0]) {
							leftF += calc(arr[j][0], arr[j][1], p);
						} else {
							rightF += calc(arr[j][0], arr[j][1], p);
						}
					}
					if (leftF > rightF) { // 왼쪽으로 작용하는 힘이 더 크다면
						leftX = p; //
					} else if (leftF < rightF) { // 오른쪽으로 작욯하는 힘이 더 크다면
						rightX = p;
					}
					count++;
				}
				System.out.printf("%.10f ", p);
			}
			System.out.println();

		}
	}

}