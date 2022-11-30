// 치킨집을 폐업 시키는 경우 
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N; // 행, 열 수
	static int M; // 폐업시키지 않을 치킨집

	static ArrayList<Pos> cPos; // 치킨집 좌표
	static ArrayList<Pos> hPos; // 집 좌표

	static boolean[] isClosed; // 폐업 배열

	static int result;

	static class Pos {
		int y;
		int x;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

	static void func(int idx, int cnt) {
		// cnt : 폐업 시킨 수, cPos.size() - M : 전체 치킨집에서 폐업시키지 않을 치킨집을 뺌
		if (cnt == cPos.size() - M) {
			int[] d = new int[hPos.size()]; // 가장 가까운 치킨집 거리를 저장할 배열
			Arrays.fill(d, Integer.MAX_VALUE);

			for (int i = 0; i < cPos.size(); i++) {
				if (!isClosed[i]) { // 폐업하지 않은 치킨집이라면,
					Pos pos = cPos.get(i);
					int y = pos.y;
					int x = pos.x;

					for (int j = 0; j < hPos.size(); j++) {
						Pos pos2 = hPos.get(j);
						int hY = pos2.y;
						int hX = pos2.x;

						d[j] = Math.min(d[j], getDistance(y, x, hY, hX));
					}
				}
			}

			// 각 집에서 치킨집까지 거리의 최소값을 저장한 d배열의 합을 구한다.
			int sum = 0;
			for (int i = 0; i < hPos.size(); i++) {
				sum += d[i];
			}
			result = Math.min(result, sum);
		} else if (cnt > cPos.size() - M) {
			return;
		} else {
			for (int i = idx; i < cPos.size(); i++) {
				if (!isClosed[i]) {
					isClosed[i] = true;
					func(i + 1, cnt + 1);
					isClosed[i] = false;
				}
			}
		}
	}

	static int getDistance(int y1, int x1, int y2, int x2) {
		return Math.abs(y1 - y2) + Math.abs(x1 - x2);
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cPos = new ArrayList<Pos>(); // 치킨집 좌표 리스트
		hPos = new ArrayList<Pos>(); // 집 좌표 리스트

		result = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) { // 집
					hPos.add(new Pos(i, j));
				} else if (n == 2) {
					cPos.add(new Pos(i, j));
				}
			}
		}

		isClosed = new boolean[cPos.size()]; // 폐업 시킨 치킨집 배열, true : 폐업됨

		func(0, 0);

		System.out.print(result);

		br.close();
	}

}