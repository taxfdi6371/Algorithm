import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken()); // 가로
		int h = Integer.parseInt(st.nextToken()); // 세로

		st = new StringTokenizer(br.readLine());

		int p = Integer.parseInt(st.nextToken()); // 초기 x
		int q = Integer.parseInt(st.nextToken()); // 초기 y

		int N = Integer.parseInt(br.readLine()); // 시행횟수

		int x = p;
		int y = q;

		int n = N % (w * 2);
		int up1 = w - p;
		int down = up1 + w;
		int up2 = w * 2;

		if (n <= up1) {
			x = p + n;
		} else if (n <= down) {
			x = w - (n - up1);
		} else if (n <= up2) {
			x = n - down;
		}

		n = N % (h * 2);
		up1 = h - q;
		down = up1 + h;
		up2 = h * 2;

		if (n <= up1) {
			y = q + n;
		} else if (n <= down) {
			y = h - (n - up1);
		} else if (n <= up2) {
			y = n - down;
		}

		System.out.println(x + " " + y);

		br.close();
	}

}
