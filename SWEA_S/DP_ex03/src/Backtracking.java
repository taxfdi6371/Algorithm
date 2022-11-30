import java.util.ArrayList;

public class Backtracking {
	public static int[] money = { 16, 10, 5, 1 };
	public static int min = Integer.MAX_VALUE;
	public static ArrayList<Integer> result = new ArrayList<>();
	public static int count = 0;

	public static void func(int sum, int cnt, int change, ArrayList<Integer> al) {
		count++;
		if (sum == change && cnt < min) {
			result = new ArrayList<>();
			for (int j = 0; j < al.size(); j++) {
				result.add(al.get(j));
			}
			min = cnt;
		} else if (sum > change || cnt > min) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			ArrayList<Integer> al1 = new ArrayList<>();
			for (int j = 0; j < al.size(); j++) {
				al1.add(al.get(j));
			}
			al1.add(money[i]);
			func(sum + money[i], cnt + 1, change, al1);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		func(0, 0, 20, al);
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + " ");
		}
		System.out.println("\n개수 : " + min);
		System.out.println("반복 횟수 : " + count);
	}
}
