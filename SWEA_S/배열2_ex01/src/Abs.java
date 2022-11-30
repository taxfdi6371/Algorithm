
public class Abs {

	public static void main(String[] args) {

		int[][] arr = new int[5][5];
		int[] count = new int[25];
		// int[][] abs = new int[5][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				int n = (int) (Math.random() * 25);
				if (count[n] == 0) {
					arr[i][j] = n;
					count[n]++;
					// System.out.printf("%3d|", arr[i][j]);
				} else if (count[n] == 1) {
					j--;
				}
			}
			// System.out.println();
		}
		// System.out.println();
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
//				int sum = 0;
				if (i != 0) {
					sum += Math.abs(arr[i - 1][j] - arr[i][j]); // 좌
				}
				if (i != 4) {
					sum += Math.abs(arr[i + 1][j] - arr[i][j]); // 우
				}
				if (j != 0) {
					sum += Math.abs(arr[i][j - 1] - arr[i][j]); // 상
				}
				if (j != 4) {
					sum += Math.abs(arr[i][j + 1] - arr[i][j]); // 하
				}
				// abs[i][j] = sum;
				// System.out.printf("%3d|", abs[i][j]);
			}
			// System.out.println();
		}
		System.out.println(sum);

	}

}
