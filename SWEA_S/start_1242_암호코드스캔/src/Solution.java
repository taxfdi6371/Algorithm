import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;

class Solution {
	public static char[] hexa = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
	public static String[] bin = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001",
			"1010", "1011", "1100", "1101", "1110", "1111" };
	public static int sum;
	public static ArrayList<String> dCheck = new ArrayList<>();

	public static String htob(String str, int width) { // 16진수 -> 2진수
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < width; i++) {
			char c = str.charAt(i);
			for (int j = 0; j < 16; j++) {
				if (c == hexa[j]) {
					sb.append(bin[j]);
					break;
				}
			}
		}
		return sb.toString();
	}

	// 암호코드 제일 뒤 숫자를 검사하여 배수를 조사
	public static int[] checkMultiple(String s, int idx) {
		int[] result = new int[2];

		for (int i = idx; i > -1; i--) { // 뒤 인덱스 에서부터 1이 시작하는 지점 찾기
			if (s.charAt(i) == '1') {
				idx = i;
				break;
			}
		}

		char curNum = '1';
		int changeCnt = 0;
		int[] r = new int[4];
		int rIdx = 3;
		int cnt = 0; // 암호코드 한 숫자의 크기

		for (int i = idx; i > -1; i--) {
			char c = s.charAt(i);
			if (c != curNum) { // 숫자가 바뀐다면 e.g) 1이 나오다가 0이 나왔을 때
				curNum = c; // 현재 숫자 변경
				changeCnt++;
				rIdx--;
			}
			if (changeCnt >= 4) {
				break;
			}
			r[rIdx]++;
			cnt++;
		}

		result[0] = idx; // 검사 시작 위치
		result[1] = cnt / 7; // 암호코드 배수

		return result;
	}

	public static int check(String s, int idx, int m) {
		int changeIdx = 8 * 7 * m;
		int[] code = new int[8]; // 암호코드 저장할 곳
		int codeIdx = 7;
		String temp = s.substring(idx - (8 * 7 * m) + 1, idx + 1);
		if (dCheck.contains(temp)) { // 이미 확인한 암호라면
			return 8 * 7 * m;
		}

		for (int i = 8; i > 0; i--) {
			int[] r = new int[4];
			int rIdx = 3;
			char curNum = '1';

			for (int j = 7 * m; j > 0; j--) {
				char c = s.charAt(idx--); // 숫자를 가져온다.
				if (c != curNum) {
					curNum = c;
					rIdx--;
				}
				if(rIdx >= 0) {					
					r[rIdx]++;
				}
			}
			code[codeIdx--] = changeNum(r, m);
		}

		if (decode(code)) { // 결과가 정답이라면
			changeIdx = 8 * 7 * m; // 인덱스 이동
			if (!dCheck.contains(temp)) { // 리스트에 등록되어있지 않다면
				dCheck.add(temp); // 암호코드 저장
			}

		}

		return changeIdx;
	}

	public static int changeNum(int[] num, int m) {
		int result = -1;

		if (num[0] == 3 * m && num[1] == 2 * m && num[2] == 1 * m && num[3] == 1 * m) {
			result = 0;
		} else if (num[0] == 2 * m && num[1] == 2 * m && num[2] == 2 * m && num[3] == 1 * m) {
			result = 1;
		} else if (num[0] == 2 * m && num[1] == 1 * m && num[2] == 2 * m && num[3] == 2 * m) {
			result = 2;
		} else if (num[0] == 1 * m && num[1] == 4 * m && num[2] == 1 * m && num[3] == 1 * m) {
			result = 3;
		} else if (num[0] == 1 * m && num[1] == 1 * m && num[2] == 3 * m && num[3] == 2 * m) {
			result = 4;
		} else if (num[0] == 1 * m && num[1] == 2 * m && num[2] == 3 * m && num[3] == 1 * m) {
			result = 5;
		} else if (num[0] == 1 * m && num[1] == 1 * m && num[2] == 1 * m && num[3] == 4 * m) {
			result = 6;
		} else if (num[0] == 1 * m && num[1] == 3 * m && num[2] == 1 * m && num[3] == 2 * m) {
			result = 7;
		} else if (num[0] == 1 * m && num[1] == 2 * m && num[2] == 1 * m && num[3] == 3 * m) {
			result = 8;
		} else if (num[0] == 3 * m && num[1] == 1 * m && num[2] == 1 * m && num[3] == 2 * m) {
			result = 9;
		}
		return result;
	}

	public static boolean decode(int[] code) {
		boolean result = false;

		if ((((code[0] + code[2] + code[4] + code[6]) * 3 + code[1] + code[3] + code[5] + code[7]) % 10) == 0) {
			sum += code[0] + code[1] + code[2] + code[3] + code[4] + code[5] + code[6] + code[7];
			result = true;
		}

		return result;
	}

	public static void main(String args[]) throws Exception {
		// 파일 입력 주석
		System.setIn(new FileInputStream("res/input.txt"));

		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			System.out.print("#" + test_case + " ");
			StringTokenizer st = new StringTokenizer(sc.nextLine());

			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());

			sum = 0;
			for (int i = 0; i < height; i++) {
				String str = sc.nextLine(); // 한줄 씩 처리
				String s = htob(str, width); // 한 줄을 2진수로 변환
				
				for (int j = width * 4 - 1; j > -1; j--) { // 뒤에서 부터 하나씩 읽음
					if (s.charAt(j) == '1') { // 1이 나온다면 그 줄을 2진수로 변환 후 검사
						int[] temp = checkMultiple(s, j); // 암호 코드의 배수 조사
						if (temp[1] > 0) {
							int jump = check(s, temp[0], temp[1]);
							j -= jump;
						}
					}
				}

			}
			System.out.println(sum);

		}
	}

}