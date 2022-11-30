import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static int[] dx = { 0, 0, 1, 0, -1 };
	public static int[] dy = { 0, -1, 0, 1, 0 };

	public static int M; // 이동 시간
	public static int[] MA; // A의 이동 정보
	public static int[] MB; // B의 이동 정보
	public static int[] posA; // A의 좌표
	public static int[] posB; // B의 좌표
	public static int sumA;
	public static int sumB;

	public static int BCSize; // BC의 개수
	public static int[][] BC; // BC의 정보
	public static int[] onBC; // BC의 정보

	public static void func() {

	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {

			M = sc.nextInt();
			MA = new int[M];
			MB = new int[M];
			posA = new int[2];
			posB = new int[2];

			BCSize = sc.nextInt();
			BC = new int[BCSize][5];

			for (int i = 0; i < M; i++) {
				MA[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				MB[i] = sc.nextInt();
			}

			posA[0] = 1;
			posA[1] = 1;
			posB[0] = 10;
			posB[1] = 10;
			sumA = 0;
			sumB = 0;

			for (int i = 0; i < BCSize; i++) {
				BC[i][0] = sc.nextInt(); // 위치 X
				BC[i][1] = sc.nextInt(); // 위치 Y
				BC[i][2] = sc.nextInt(); // 충전 범위 C
				BC[i][3] = sc.nextInt(); // 성능 P
				// BC[i][4] : 접속중인 사람. 0: 없음, 1:A, 2:B, 3:둘 다
			}

			for (int i = 0; i < M + 1; i++) {
				// 초기화
				for (int j = 0; j < BCSize; j++) {
					BC[j][4] = 0;
				}

				// 1. A, B가 접속중인지 확인
				for (int j = 0; j < BCSize; j++) {
					int DA = Math.abs(posA[0] - BC[j][0]) + Math.abs(posA[1] - BC[j][1]);
					// A가 BC에 접속할 수 있는 거리라면
					if (DA <= BC[j][2]) {
						BC[j][4] = 1;
					}
					int DB = Math.abs(posB[0] - BC[j][0]) + Math.abs(posB[1] - BC[j][1]);
					// B가 BC에 접속할 수 있는 거리라면
					if (DB <= BC[j][2]) {
						if (BC[j][4] == 0) {
							BC[j][4] = 2;
						} else if (BC[j][4] == 1) {
							BC[j][4] = 3;
						}
					}
				}

				// 2. 충전할 수 있는 최대값 분배
				int PA = 0;
				int PB = 0;
				// 한명만 접속 중인 BC의 경우 최대값 배정
				for (int j = 0; j < BCSize; j++) {
					if (BC[j][4] == 1) {
						PA = Math.max(PA, BC[j][3]);
					} else if (BC[j][4] == 2) {
						PB = Math.max(PB, BC[j][3]);
					}
				}
				for (int j = 0; j < BCSize; j++) {
					if (BC[j][4] == 3) {
						// 두 명 모두 밟은 BC가 나오면
						if (PA < BC[j][3] && PA < PB) {
							PA = BC[j][3];
						} else if (PB < BC[j][3] && PA >= PB) {
							PB = BC[j][3];
						}
					}
				}

				sumA += PA;
				sumB += PB;

				// 다음 좌표로 이동
				if (i != M) {
					posA[0] += dx[MA[i]];
					posA[1] += dy[MA[i]];
					posB[0] += dx[MB[i]];
					posB[1] += dy[MB[i]];
				}
			}

			System.out.println("#" + test_case + " " + (sumA + sumB));
		}
	}

}