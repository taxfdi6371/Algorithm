import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	static char[][] map;
	static ArrayList<Pos> posList;
	static int resultMoveCnt;
	static int resultPinCnt;

	static class Pos {
		int y;
		int x;
		boolean state;

		public Pos(int y, int x) {
			this.y = y;
			this.x = x;
			state = true;
		}
	}

	static void init(BufferedReader br) throws Exception {
		map = new char[9][9];
		posList = new ArrayList<>();
		resultMoveCnt = Integer.MAX_VALUE;
		resultPinCnt = 0;

		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				char c = s.charAt(j);
				map[i][j] = c;

				if (c == 'o') {
					posList.add(new Pos(i, j));
					map[i][j] = Integer.toString(resultPinCnt).charAt(0);
					resultPinCnt++;
				}
			}
		}

	}

	static void func(int pinCnt, int moveCnt) {
		if (pinCnt <= resultPinCnt) {
			resultPinCnt = pinCnt;
			resultMoveCnt = moveCnt;
		}
		if (pinCnt == 1) {
			return;
		}
		for (int i = 0; i < posList.size(); i++) {
			// 자리에 남아 있다면
			if (posList.get(i).state) {
				for (int j = 0; j < 4; j++) {
					int cY = posList.get(i).y; // 움직일 핀
					int cX = posList.get(i).x;

					int nY = cY + dy[j]; // 움직일 핀 인근 좌표
					int nX = cX + dx[j];

					int mY = nY + dy[j]; // 인근 좌표 건너
					int mX = nX + dx[j];
					// 인접한 곳에 핀이 있고, 인접한 핀 건너 빈 공간이 있다면
					if (checkIdx(nY, nX) && (map[nY][nX] >= '0' && map[nY][nX] <= '8') && checkIdx(mY, mX)
							&& map[mY][mX] == '.') {
						int nPos = map[nY][nX] - '0'; // 사라지는 위치 임시 저장

						posList.get(i).y = mY;
						posList.get(i).x = mX;
						posList.get(nPos).state = false; // 삭제된 위치로 변경
						map[cY][cX] = '.';
						map[nY][nX] = '.'; // 원래 핀 빈공간으로 표시
						map[mY][mX] = Integer.toString(i).charAt(0); // 핀 이동

						func(pinCnt - 1, moveCnt + 1);

						map[mY][mX] = '.';
						map[nY][nX] = Integer.toString(nPos).charAt(0);
						map[cY][cX] = Integer.toString(i).charAt(0);
						posList.get(map[nY][nX] - '0').state = true; // 다시 되돌리기
						posList.get(i).y = cY;
						posList.get(i).x = cX;
					}
				}
			}
		}
	}

	static boolean checkIdx(int y, int x) {
		if (y >= 0 && y < 5 && x >= 0 && x < 9) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			init(br); // 맵 초기화

			func(posList.size(), 0);

			System.out.println(resultPinCnt + " " + resultMoveCnt);

			if (tc != T - 1) {
				br.readLine();
			}
		}
		br.close();
	}

}
