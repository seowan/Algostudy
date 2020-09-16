import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_7569_토마토 {
	static int dir[][] = { { -1, 0, 0 }, { 0, 1, 0 }, { 1, 0, 0 }, { 0, -1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static int map[][][], result[][][];

	static class Point {
		int x, y, z;

		public Point(int x, int y, int z) {
			super();
			this.x = x;
			this.y = y;
			this.z = z;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Point> queue = new LinkedList<Point>();

		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();

		map = new int[H][N][M];
		result = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < M; z++) {
					map[i][j][z] = sc.nextInt();
					if (map[i][j][z] == 1) {
						queue.add(new Point(i, j, z));
					}
				}
			}
		} // 입력끝
		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int x = p.x;
			int y = p.y;
			int z = p.z;

			for (int i = 0; i < 6; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];
				int nz = z + dir[i][2];

				if (0 <= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M) {
					if (map[nx][ny][nz] == 0 && result[nx][ny][nz] == 0) {
						queue.add(new Point(nx, ny, nz));
						result[nx][ny][nz] = result[x][y][z] + 1;
					}
				}

			}
		}

		int ans = 0;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < M; z++) {
					if (ans < result[i][j][z]) {
						ans = result[i][j][z];
					}
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int z = 0; z < M; z++) {
					if (map[i][j][z] == 0 && result[i][j][z] == 0) {
						ans = -1;
					}
				}
			}
		}

		System.out.println(ans);
		sc.close();
	}

}