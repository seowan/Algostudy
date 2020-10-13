import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17144_미세먼지안녕 {
//20.10.12 50분소요
	static class point{
		int x,y,data;

		public point(int x, int y, int data) {
			super();
			this.x = x;
			this.y = y;
			this.data = data;
		}

	
		
	}
	static int air;
	static int dir[][] = {{-1,0},{0,1},{1,0},{0,-1}}; //상우하좌
	static Queue<point> q = new LinkedList<point>(); //미세먼지있는칸 저장할 큐
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken()); //가로
		int C = Integer.parseInt(st.nextToken()); //세로
		int T = Integer.parseInt(st.nextToken()); //시간
		
		int map[][] = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j]>0) {
					q.offer(new point(i, j,map[i][j]));
				}else if (map[i][j]==-1) {
					air = i-1;
				}
			}
		}//입력끝
		
		//매초마다 연산하기
		for (int i = 0; i < T; i++) {
			//미세먼지 퍼지기
			while (!q.isEmpty()) {
				point p = q.poll();
				int mun = p.data/5;
				if (mun>0) {
					for (int j = 0; j < 4; j++) {
						int tx = p.x+dir[j][0];
						int ty = p.y+dir[j][1];
						if (tx<0 ||ty<0||tx>=R||ty>=C||(tx==air&&ty==0) || (tx==air+1&&ty==0)) {
							continue;
						}else {
							map[tx][ty]+=mun;
							map[p.x][p.y]-=mun;
						}
					}
				}
				
			}
			
			//공기청정기 가동
			//위의 공기청정기
			for (int j = air; j >0; j--) {
				if (j==air) {
					map[j-1][0]=0;
				}
				map[j][0] = map[j-1][0];
			}
			
			for (int j = 0; j < C-1; j++) {
				map[0][j] = map[0][j+1];
			}
			
			for (int j = 0; j < air; j++) {
				map[j][C-1] = map[j+1][C-1];
			}
			
			for (int j = C-1; j >0; j--) {
				map[air][j] = map[air][j-1];
			}
			
			//아래 공기청정기
			for (int j = air+1; j < R-1; j++) {
				if (j==air+1) {
					map[j+1][0]=0;
				}
				map[j][0] = map[j+1][0];
			}
			
			for (int j = 0; j < C-1; j++) {
				map[R-1][j] = map[R-1][j+1];
			}
			
			for (int j = R-1; j >= air+1; j--) {
				map[j][C-1] = map[j-1][C-1];
			}
			
			for (int j = C-1; j > 0; j--) {
				map[air+1][j] = map[air+1][j-1];
			}
			
			for (int j = 0; j < R; j++) {
				for (int z = 0; z < C; z++) {
					if (map[j][z]>0) {
						q.offer(new point(j, z, map[j][z]));
					}
				}
			}
		}
		
		int answer=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				answer+=map[i][j];
			}
		}
		
		System.out.println(answer);
	}

}
