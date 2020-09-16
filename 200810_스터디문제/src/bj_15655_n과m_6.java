import java.util.Arrays;
import java.util.Scanner;

public class bj_15655_n°úm_6 {
	static int N, M, answer[], number[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		answer = new int[M];
		number = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			number[i] = sc.nextInt();
		}
		Arrays.sort(number);

		comb(0, 1);
	}

	static void comb(int count, int start) {
		if (count == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i <= N; i++) {
			answer[count] = number[i];
			comb(count + 1, i + 1);
		}
	}
}