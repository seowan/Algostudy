package workshop;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_2636_치즈 {

	static class point {
		int x, y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	static int dir[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }; // 상하좌우
	static int N, M, map[][];
	static int time=0,answer=0,count;
	static Queue<point> q = new LinkedList<point>();
	static Queue<point> cheeze = new LinkedList<point>();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 치즈값들 입력완료

		while (true) {
			count=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j]==1) {
						count++;
					}
				}
			}
			
			if (count==0) {
				break;
			}
			
			answer=count;
			
			q.offer(new point(0, 0));
			bfs();
			
			melt();
			time++;
		}
		
		System.out.println(time);
		System.out.println(answer);
		
	}

	private static void melt() {
		while (!cheeze.isEmpty()) {
			point p = cheeze.poll();
			map[p.x][p.y]=0;
		}
	}

	private static void bfs() {

		boolean visited[][] = new boolean[N][M];
		visited[q.peek().x][q.peek().y] = true;
		
		while (!q.isEmpty()) {
			point p = q.poll();
			for (int i = 0; i < 4; i++) {
				int tx = p.x+dir[i][0];
				int ty = p.y+dir[i][1];
				
				if (tx<0 || ty<0 || tx>=N || ty>=M) {
					continue;
				}
				
				if (map[tx][ty]==0&& !visited[tx][ty]) {
					visited[tx][ty] = true;
					q.offer(new point(tx, ty));
				}
				
				if (map[tx][ty]==1 && !visited[tx][ty]) {
					cheeze.offer(new point(tx, ty));
				}
			}
		}
	}


}
