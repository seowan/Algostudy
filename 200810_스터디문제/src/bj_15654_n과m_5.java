import java.util.Arrays;
import java.util.Scanner;

public class bj_15654_n°úm_5 {
	static int N, M, answer[], number[];
	static boolean selected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		answer = new int[M];
		selected = new boolean[N + 1];
		number = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			number[i] = sc.nextInt();
		}
		Arrays.sort(number);

		perm(0);
	}

	static void perm(int count) {

		if (count == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				continue;
			}
			answer[count] = number[i];
			selected[i] = true;
			perm(count + 1);
			selected[i] = false;
		}
	}
}
