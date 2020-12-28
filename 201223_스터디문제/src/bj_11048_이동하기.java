import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11048_이동하기 {
	//bfs로 탐색하장
	static class point{
		int x,y,count;

		public point(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}

		
	}

	static int dir[][] = {{1,0},{0,1},{1,1}};
	static int N,M,map[][],answer = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//입력완료
		
		//알고리즘 시작
		bfs();
		System.out.println(answer);
	}

	private static void bfs() {
		Queue<point> q = new LinkedList<point>();
		q.offer(new point(0, 0,map[0][0]));
		
		while (!q.isEmpty()) {
			point p = q.poll();
			
			
			for (int i = 0; i < 3; i++) {
				int tx = p.x+dir[i][0];
				int ty = p.y+dir[i][1];
				
				if (tx<0 || tx>=N || ty<0 || ty>=M) {
					continue;
				}
				
				if (tx==N-1 && ty==M-1) {
					answer=Math.max(answer, p.count+map[tx][ty]);
					continue;
				}
				q.offer(new point(tx, ty, p.count+map[tx][ty]));
				
			}
		}
	}

}
