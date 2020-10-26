import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj_4485_녹색옷입은애가젤다지 {
	static class point{
		int x,y;

		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
	static int map[][],N,result[][],answer=1;
	static boolean visited[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
	//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st ;
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			N = sc.nextInt();
			//N = Integer.parseInt(br.readLine());
			
			if (N==0) {
				break;
			}
			
			map = new int[N][N];
			result = new int[N][N];
			visited = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				//st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					//map[i][j] = Integer.parseInt(st.nextToken());
					map[i][j] = sc.nextInt();
					result[i][j] = min;
				}
			}//입력 끝
			
			int x=0;
			int y=0;
			visited[x][y] = true;
			//알고리즘 구현
			bfs(0,0);
			System.out.println("Problem "+answer+": "+result[N-1][N-1]);
			answer++;
		}
	}
	private static void bfs(int x, int y) {
		Queue<point> q =  new LinkedList<point>();
		q.add(new point(x, y));
		result[x][y] = map[x][y];
		visited[x][y] = true;
		while (!q.isEmpty()) {
			point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int tx = p.x+dir[i][0];
				int ty = p.y+dir[i][1];
				if (tx>=0 && ty>=0 && tx<N &&ty<N && result[tx][ty]>result[p.x][p.y]+map[tx][ty]) {
					result[tx][ty]= Math.min(result[tx][ty], result[p.x][p.y]+map[tx][ty]);
					visited[tx][ty] = true;
					q.add(new point(tx, ty));
				}
			}
		}
	}

}