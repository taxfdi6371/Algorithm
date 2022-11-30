package 큐_ex02;

import java.util.Scanner;

public class Mychew {
	public static int[] q = new int[100];
	public static int front = -1;
	public static int rear = -1;

	public static int[] p = new int[20];
	public static int pn = 0;

	public static int mychew = 20;
	public static int x = -1;

	public static void print(Scanner sc) {
		sc.nextLine();
		System.out.printf("----------------\n큐에 있는 사람 : %d명\n[", rear - front);
		for (int i = front + 1; i < rear + 1; i++) {
			System.out.print(q[i] + " ");
		}
		System.out.printf("]\n남은 사탕 : %d\n----------------\n", mychew);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (mychew > 0) {
			q[++rear] = ++pn; // 줄을 선다.
			System.out.println(pn + "이 줄을 선다");
			p[q[++front]] += 1; // 마이쮸를 받는다
			mychew--;
			System.out.print(q[front] + "이 1개 받는다.");
			print(sc);

			q[++rear] = q[front]; // 마이쮸를 받으면 바로 줄을 선다
			System.out.println(q[front] + "이 줄을 선다.");
			q[++rear] = ++pn; // 새로 다음 번호가 줄을 선다
			System.out.print(pn + "이 줄을 선다.");
			print(sc);

			p[q[++front]] += (++x % 2) + 2; // 마이쮸를 받는다.
			System.out.println(q[front] + "이 " + (x % 2 + 2) + "개 받는다.");
			q[++rear] = q[front]; // 마이쮸를 받으면 바로 줄을 선다
			System.out.print(q[front] + "이 줄을 선다.");
			mychew -= x % 2 + 2;
			print(sc);
		}
	}
}
