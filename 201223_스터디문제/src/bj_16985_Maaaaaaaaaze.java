import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;
//미완성
public class bj_16985_Maaaaaaaaaze {
	static int map[][][][], answer = Integer.MAX_VALUE;
	static int rotate[] = new int[5], order[] = new int[5];
	static boolean visited[] = new boolean[5];
	static int dx[] = { 0, 0, -1, 1, 0, 0 };
	static int dy[] = { -1, 1, 0, 0, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][4][5][5];// [처음입력받은 판의층][회전한 판 정보저장][][]

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				st = new StringTokenizer(br.readLine());
				for (int z = 0; z < 5; z++) {
					map[i][0][j][z] = Integer.parseInt(st.nextToken());
				}
			}
			rotatemap(i); // 각 판의 회전한 판의 정보를 저장한다 => 맨끝의 인덱스가 각 회전방향마다의 판정보

		} // 각 판의 모든 정보 입력완료
			// https://herong.tistory.com/entry/BOJ-16985-Maaaaaaaaaze-GraphBFBFS

		selectRotate(0); // 회전 방향 선택

		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	private static void selectRotate(int i) {
		if (i == 5) {
			selectOrder(0);// 방향을 모두 정하면 판을 어떻게 쌓을지 결정
			return;
		}
		for (int j = 0; j < 4; j++) {
			rotate[i] = j;
			selectRotate(i + 1);
		}
	}

	private static void selectOrder(int i) {
		if (i == 5) {
			search();// 판 회전과 판쌓기를 모두 완료했다면 탐색으로 이동
			return;
		}
		for (int j = 0; j < 5; j++) {
			if (!visited[j]) {
				visited[j] = true;
				order[i] = j;
				selectOrder(i + 1);
				visited[j] = false;
			}
		}
	}

	private static void search() {// 이제 탐색
		int tempmap[][][] = new int[5][5][5];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				for (int z = 0; z < 5; z++) {
					tempmap[i][j][z] = map[order[i]][rotate[i]][j][z];
				}
			}
		} // 임시로 탐색할 배열 저장

		if (tempmap[0][0][0] != 1 && tempmap[4][4][4] != 1) {//입,출구가 없다면 종료
			return;
		}

		//bfs로 탐색
		Queue<int[]> q = new LinkedList<>();
		boolean tempvisited[][][] = new boolean[5][5][5];
		q.offer(new int[] { 0, 0, 0, 0 });
		tempvisited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] curr = q.poll();

			// 최저값보다 커지면 끝
			if (curr[3] >= answer) {
				return;
			}

			// 도착하면 끝
			if (curr[0] == 4 && curr[1] == 4 && curr[2] == 4) {
				if (answer > curr[3]) {
					answer = curr[3];
				}
				return;
			}

			for (int dir = 0; dir < 6; dir++) {
				int tz = curr[0] + dz[dir];
				int ty = curr[1] + dy[dir];
				int tx = curr[2] + dx[dir];
				if (0 <= tz && tz < 5 && 0 <= ty && ty < 5 && 0 <= tx && tx < 5 && !tempvisited[tz][ty][tx]
						&& tempmap[tz][ty][tx] == 1) {
					q.offer(new int[] { tz, ty, tx, curr[3] + 1 });
					tempvisited[tz][ty][tx] = true;
				}
			}
		}
	}

	private static void rotatemap(int i) {
		for (int j = 1; j < 4; j++) {
			for (int a = 0; a < 5; a++) {
				for (int b = 0; b < 5; b++) {
					map[i][j][b][4 - a] = map[i][j - 1][a][b];
				}
			}
		}
	}

}
