import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int getGCD(int a, int b) {
		if (a < b) {
			int temp = a;
			a = b;
			b = temp;
			
		}

		while (b != 0) {
			int n = a % b;
			a = b;
			b = n;
		}

		return a;
	}

	static double getDistance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	public static void main(String[] args) throws Exception {
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("res/input.txt"));

		StringTokenizer st = new StringTokenizer(br.readLine());

		// 정류장 좌표
		int Xs = Integer.parseInt(st.nextToken());
		int Ys = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		// 현재 열차 위치
		int Xe = Integer.parseInt(st.nextToken());
		int Ye = Integer.parseInt(st.nextToken());

		// 좌표 증가량
		int dX = Integer.parseInt(st.nextToken());
		int dY = Integer.parseInt(st.nextToken());

		// 최대 공약수
		int gcd = getGCD(Math.abs(dX), Math.abs(dY));

		dX = dX / gcd;
		dY = dY / gcd;
		
		int Xp = Xe;
		int Yp = Ye;
		
		Xe += dX;
		Ye += dY;

		double Dp = getDistance(Xs, Ys, Xp, Yp); // 이동 전 좌표의 거리
		double De = getDistance(Xs, Ys, Xe, Ye); // 현재 좌표의 거리

		while (De < Dp) {
			Xp = Xe;
			Yp = Ye;
			
			Xe += dX;
			Ye += dY;
			
			Dp = getDistance(Xs, Ys, Xp, Yp); // 이동 전 좌표의 거리
			De = getDistance(Xs, Ys, Xe, Ye); // 현재 좌표의 거리

			// 현재 좌표의 거리가 이전 좌표의 거리보다 길어지게 된다면
			if (De > Dp) {
				break;
			}
		}

		System.out.println(Xp + " " + Yp);

		br.close();
	}

}
