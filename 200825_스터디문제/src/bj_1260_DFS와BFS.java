import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_1260_DFS와BFS {
	static int map[][];
	static boolean visited[];
	static boolean visited2[];
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		visited2 = new boolean[N + 1];
		int temp = M;
		while (temp > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = map[y][x] = 1;
			temp--;
		} // 간선 정보 입력완료

		dfs(V);

		System.out.println();
		bfs(V);
	}

	static void dfs(int v) {
		if (visited[v]) {
			return;
		}

		visited[v] = true;
		System.out.print(v + " ");

		for (int i = 1; i <= N; i++) {
			if (map[v][i] == 1) {
				dfs(i);
			}
		}
	}

	static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.offer(v);
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			visited2[temp] = true;
			System.out.print(temp + " ");
			for (int i = 1; i <= N; i++) {
				if (map[temp][i] == 1 && visited2[i] == false) {
					queue.offer(i);
					visited2[i] = true;
				}
			}
		}
	}
}