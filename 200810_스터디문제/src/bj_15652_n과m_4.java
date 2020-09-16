import java.util.Scanner;

public class bj_15652_n°úm_4 {
	static int N, M, answer[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		answer = new int[M];

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
			answer[count] = i;
			comb(count + 1, i);
		}
	}
}