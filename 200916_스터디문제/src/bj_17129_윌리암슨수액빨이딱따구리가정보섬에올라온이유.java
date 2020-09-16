import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17129_Àª¸®¾Ï½¼¼ö¾×»¡ÀÌµüµû±¸¸®°¡Á¤º¸¼¶¿¡¿Ã¶ó¿ÂÀÌÀ¯ {

	static class point {
		int x, y, count;

		public point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

	}

	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int n, m, map[][], answer = Integer.MAX_VALUE;
	static boolean[][] visited;
	static Queue<point> queue = new LinkedList<point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j) - '0';
				if (map[i][j] == 2) {
					queue.offer(new point(i, j, 0));
					visited[i][j] = true;
				}
			}
		}

		bfs();
		if (answer == Integer.MAX_VALUE) {
			System.out.println("NIE");
		} else {
			System.out.println("TAK");
			System.out.println(answer);
		}
	}

	private static void bfs() {
		while (!queue.isEmpty()) {
			point p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int tcount = p.count;
				int tx = p.x + dir[i][0];
				int ty = p.y + dir[i][1];

				if (tx < 0 || ty < 0 || tx >= n || ty >= m || map[tx][ty] == 1 || visited[tx][ty])
					continue;

				if (map[tx][ty] == 0) {
					tcount++;
					visited[tx][ty] = true;
					queue.offer(new point(tx, ty, tcount));
				}

				if (map[tx][ty] == 3 || map[tx][ty] == 4 || map[tx][ty] == 5) {
					tcount++;
					answer = Math.min(answer, tcount);
				}
			}
		}
	}

}