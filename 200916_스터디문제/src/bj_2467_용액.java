import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_용액 {
	static int answer[] = new int[2];
	static int list[], N, min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		list = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(list);

		int start = 0;
		int end = N - 1;

		while (start < end) {
			if (Math.abs(list[start] + list[end]) < min) {
				min = Math.abs(list[start] + list[end]);
				answer[0] = list[start];
				answer[1] = list[end];
			}
			if (list[start] + list[end] < 0)
				start++;
			else
				end--;
		}
		System.out.println(answer[0] + " " + answer[1]);
	}

}
