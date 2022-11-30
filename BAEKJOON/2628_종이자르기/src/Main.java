import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(br.readLine()); // 자르는 횟수

		int[] wArr = new int[n + 2];
		int[] hArr = new int[n + 2];
		int[] wArr2 = new int[n + 2];
		int[] hArr2 = new int[n + 2];
		int wIdx = 1;
		int hIdx = 1;

		wArr[n + 1] = width;
		hArr[n + 1] = height;

		for (int i = 0; i < n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			if (st2.nextToken().equals("0")) { // 가로로 자름
				hArr[hIdx++] = Integer.parseInt(st2.nextToken());
			} else {
				wArr[wIdx++] = Integer.parseInt(st2.nextToken());
			}
		}
		Arrays.sort(wArr);
		Arrays.sort(hArr);

		for (int i = 1; i < n + 2; i++) {
			wArr2[i] = wArr[i] - wArr[i - 1];
			hArr2[i] = hArr[i] - hArr[i - 1];
		}
		Arrays.sort(wArr2);
		Arrays.sort(hArr2);

		int wMax = 0;
		int hMax = 0;

		for (int i = 1; i < n + 2; i++) {
			if (wArr2[i] > wMax) {
				wMax = wArr2[i];
			}
			if (hArr2[i] > hMax) {
				hMax = hArr2[i];
			}
		}

		System.out.println(wMax * hMax);

		br.close();
	}

}
