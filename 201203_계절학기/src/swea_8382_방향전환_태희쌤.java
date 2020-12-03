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
public class swea_8382_방향전환_태희쌤 {

	static int x1, y1, x2, y2;
	static final int HOR = 0, VER = 1;

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

			if (cur.d == HOR) {
				// 세로이동 처리

				// 위로 이동
				nx = cur.x;
				ny = cur.y - 1;
				if (ny >= 0 && !visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true;
					queue.offer(new point(nx, ny, VER, cur.cnt + 1));
				}

				// 아래로 이동
				ny = cur.y + 1;
				if (ny <= 200 && !visited[VER][nx][ny]) {
					visited[VER][nx][ny] = true;
					queue.offer(new point(nx, ny, VER, cur.cnt + 1));
				}
			} else {
				// 가로이동 처리

				// 왼쪽으로 이동
				nx = cur.x - 1;
				ny = cur.y;
				if (nx >= 0 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true;
					queue.offer(new point(nx, ny, HOR, cur.cnt + 1));
				}

				// 오른쪽으로 이동
				nx = cur.x + 1;
				if (nx <= 200 && !visited[HOR][nx][ny]) {
					visited[HOR][nx][ny] = true;
					queue.offer(new point(nx, ny, HOR, cur.cnt + 1));
				}
			}

		}
		return 0;
	}

}