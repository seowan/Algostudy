import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_17182_우주탐사선 {
	static int N,map[][];
	static int answer=Integer.MAX_VALUE;
	static boolean visited[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		visited[K] = true;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 정보입력 끝

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < N; z++) {
					map[j][z] = Math.min(map[j][z], map[j][i]+map[i][z]);//플로이드워샬로 최소거리 구해내기
				}
			}
		}//거리계산 끝
		
		dfs(K,0,1);
		System.out.println(answer);
	}

	private static void dfs(int start, int sum, int count) {
		//모두방문시 끝내기
		if (count==N) {
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, sum+map[start][i], count+1);
				visited[i] = false;
			}
		}
	}
}