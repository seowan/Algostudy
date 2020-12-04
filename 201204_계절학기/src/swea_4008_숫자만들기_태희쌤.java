import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4008_숫자만들기_태희쌤 {

	static int ops[], opsCnt[], numbers[], max, min, N;// 연산자순열, 연산자갯수,숫자배열,최대값,최소값,숫자개수

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st = null;
		opsCnt = new int[4];

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			numbers = new int[N];
			ops = new int[N - 1];

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < 4; i++) {
				opsCnt[i] = Integer.parseInt(st.nextToken());
			} // 연산자 개수 저장

			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			} // 숫자 저장

			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;

			permutation(0);
			System.out.println("#" + t + " " + (max - min));
		}
	}

	// +:0 -:1 *:2 /:3
	private static void permutation(int cnt) { // 연산자의 순열 생성

		if (cnt == N - 1) {// 연산자 순열 완성
			calc();
			return;
		}

		// 모든 연산자를 다 시도해봄
		for (int i = 0; i < 4; i++) { // i:연산자 => +:0 -:1 *:2 /:3
			if (opsCnt[i] == 0) {
				continue;
			}
			ops[cnt] = i;
			opsCnt[i]--;
			permutation(cnt + 1);
			opsCnt[i]++;
		}
	}

	private static void calc() { // 연산자의 순열의 상태를 이용하여 수식계산

		int result = numbers[0];
		for (int i = 1; i < N; i++) {
			int currNumber = numbers[i];
			switch (ops[i - 1]) {
			case 0:
				result += currNumber;
				break;
			case 1:
				result -= currNumber;
				break;
			case 2:
				result *= currNumber;
				break;
			case 3:
				result /= currNumber;
				break;
			}
		}
		max = Math.max(max, result);
		min = Math.min(min, result);
	}

}
