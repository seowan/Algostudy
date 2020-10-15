import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14503_로봇청소기 {
	/* 1시간 40분 소요 */
	/* 순차적으로 풀어나가되 마지막조건에 리턴 
	 * 이 문제는 조건이 까다로워서 조건을 읽으면서 어떤순서로 로직을 구성하는게 좋을지 생각하는게 오래걸렸다
	 * 처음에는 문제에 주어진 순서대로 하는게 나을거같았지만 그방법이 더 복잡해졌다
	 * 문제에서 주어진대로 하면 될거같아서 금방할줄알았지만 청소 과정이 은근이 복잡해서 로직을 생각해내는 연습을 더해야겠다!*/

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 북동남서
	static int N, M, map[][], answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M]; // 지도

		st = new StringTokenizer(br.readLine());
		int robotx = Integer.parseInt(st.nextToken());
		int roboty = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 정보입력 끝

		// 알고리즘 구현
		init(robotx, roboty, d);
		System.out.println(answer);
	}

	private static void init(int robotx, int roboty, int d) { //해당위치를 청소 => 1번
		if (map[robotx][roboty] == 0) {
			map[robotx][roboty] = 2;
			answer++;
		}

		clean(robotx, roboty, d, 0);
	}

		
	private static void clean(int robotx, int roboty, int d, int count) { //2번
		// 탐색진행

		int tx = robotx + dir[(d + 3) % 4][0]; //방향을 왼쪽으로
		int ty = roboty + dir[(d + 3) % 4][1];
		if (map[tx][ty] == 0) {// 2-1
			d = (d + 3) % 4;
			init(tx, ty, d);
			return;
		} else {
			if (count == 4) {// 2-4
				int x = robotx + dir[(d + 2) % 4][0]; //뒤로이동
				int y = roboty + dir[(d + 2) % 4][1];
				if (map[x][y] == 1) {
					return;
				} else {// 2-3
					clean(x, y, d, 0);
				}

			} else {// 2-2
				d = (d + 3) % 4;
				clean(robotx, roboty, d, count + 1);
			}
		}

	}
}
