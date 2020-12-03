import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//bfs로 풀이
/*
//첫시작이 가로인경우 세로인경우를 동시에 체킹하기위해서 방문처리 배열을 3차원으로 선언해준다
//[2][201][201]
 */
public class swea_8382_방향전환_태희쌤_02 {

	static int x1, y1, x2, y2;
	static final int HOR = 0, VER = 1; // 배타적논리합을 이용하여 방향전환을 해준당
	/*
	 * 000000 0^1 000001 1^1 000001 000001 000001 000000
	 */

	static int [][][] dir= {
			{{-1,0},{1,0}}, //hor : 0
			{{0,-1},{0,1}} //ver : 1
	};

	static class point {
		int x, y, d, cnt; // x좌표, y좌표, 이동방향,이동횟수

		public point(int x, int y, int d, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			// 좌표에 100씩 더해 음수좌표 보정
			x1 = Integer.parseInt(st.nextToken()) + 100;
			y1 = Integer.parseInt(st.nextToken()) + 100;
			x2 = Integer.parseInt(st.nextToken()) + 100;
			y2 = Integer.parseInt(st.nextToken()) + 100;

			System.out.println("#" + t + " " + bfs());
		}
	}

	private static int bfs() {
		Queue<point> queue = new LinkedList<point>();
		boolean[][][] visited = new boolean[2][201][201];

		visited[HOR][x1][y1] = true;
		queue.offer(new point(x1, y1, HOR, 0));
		visited[VER][x1][y1] = true;
		queue.offer(new point(x1, y1, VER, 0));

		point cur;
		int nx, ny;

		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.x == x2 && cur.y == y2) {
				return cur.cnt;
			}

			int[][] d = dir[cur.d ^ 1]; // 현재좌표 방향의 반대에 해당하는 델타값
			for (int i = 0; i < d.length; i++) {
				nx = cur.x + d[i][0];
				ny = cur.y + d[i][1];
				if (nx >= 0 && nx <= 200 && ny >= 0 && ny <= 200 && !visited[cur.d ^ 1][nx][ny]) {
					visited[cur.d ^ 1][nx][ny] = true;
					queue.offer(new point(nx, ny, cur.d ^ 1, cur.cnt + 1));
				}
			}

		}
		return 0;
	}

}