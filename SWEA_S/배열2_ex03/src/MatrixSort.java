
public class MatrixSort {

	public static int func(int[][] arr) {
		int min = 25;
		int minYIdx = -1;
		int minXIdx = -1;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if ((arr[i][j] != -1) && (arr[i][j] < min)) {
					min = arr[i][j];
					minYIdx = i;
					minXIdx = j;
				}
			}
		}
		arr[minYIdx][minXIdx] = -1; // 사용한 값은 -1로 변경
		return min;
	}

	public static void main(String[] args) {

		int[][] arr = new int[5][5];
		int[] count = new int[25];

		int[][] result = new int[5][5];
		int[] dy = { 0, 1, 0, -1 };
		int[] dx = { 1, 0, -1, 0 };

		System.out.println("-------초기 배열------");
		for (int i = 0; i < 5; i++) { // 배열 초기화
			for (int j = 0; j < 5; j++) {
				int n = (int) (Math.random() * 25);
				if (count[n] == 0) {
					arr[i][j] = n;
					count[n]++;
					System.out.printf("%3d ", arr[i][j]);
				} else if (count[n] == 1) {
					j--;
				}
			}
			System.out.println();
		}

		int ryIdx = 0; // 결과 배열 y좌표
		int rxIdx = 0; // 결과 배열 x좌표

		int dir = 0; // 진행 방향

		int repeat = 5; // 한줄 반복 횟수
		int decrease = 1; // repeat 감소 조건

		for (int i = 0; i < 25; i++) {
			if (decrease == 2) { // 두번 째마다 한칸씩 감소
				decrease = 0;
				repeat--;
			}
			for (int j = 0; j < repeat; j++) {
				result[ryIdx][rxIdx] = func(arr); // 순서대로 값 받아옴
				if (j == repeat - 1) { // 마지막 칸까지 입력을 마치면
					break; // 좌표를 이동하지 않음
				}
				ryIdx += dy[dir];
				rxIdx += dx[dir];
			}
			decrease++;
			dir = (dir + 1) % 4; // 방향 변경

			ryIdx += dy[dir]; // 다음 좌표로 이동
			rxIdx += dx[dir];
		}

		System.out.println("-------결과 배열------");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%3d ", result[i][j]);
			}
			System.out.println();
		}
	}

}
