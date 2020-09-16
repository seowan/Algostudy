import java.util.Scanner;

public class bj_15649_n°úm_1 {

	static int N, M, answer[];
	static boolean selected[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		answer = new int[M];
		selected = new boolean[N + 1];

		perm(0);
	}

	static void perm(int count) {

		if (count == M) {
			for (int i = 0; i < answer.length; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(answer));
			return;
		}
		for (int i = 1; i <= N; i++) {
			if (selected[i]) {
				continue;
			}
			answer[count] = i;
			selected[i] = true;
			perm(count + 1);
			selected[i] = false;
		}
	}

}