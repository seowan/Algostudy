package 삼성역량테스트대비_2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//21.01.13 9:10 ~ 9:37
public class bj_13460_구슬탈출2 {
	static class point{
		int bluex,bluey;
		int redx,redy;
		int count;
		public point(int bluex, int bluey, int redx, int redy, int count) {
			super();
			this.bluex = bluex;
			this.bluey = bluey;
			this.redx = redx;
			this.redy = redy;
			this.count = count;
		}
		
		
	}

	static char map[][];
	static int holex,holey;
	static Queue<point> q = new LinkedList<point>();
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
	static boolean visited[][][][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M][N][M];
		
		int bx=0,by=0,rx=0,ry=0;
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] =='B') {
					bx=i;
					by=j;
				}
				if (map[i][j]=='R') {
					rx=i;
					ry=j;
				}
				if (map[i][j]=='O') {
					holex=i;
					holey=j;
				}
			}
		}//입력완료
		
		
		//알고리즘 시작
		point p = new point(bx, by, rx, ry, 0);
		q.offer(p);
		bfs();
	}

	private static void bfs() {
		while (!q.isEmpty()) {
			point p = q.poll();
			visited[p.bluex][p.bluey][p.redx][p.redy] = true;
			
			if (p.count>9) {
				System.out.println(-1);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int tempbx = p.bluex;
				int tempby = p.bluey;
				int tempbc = 0;
				
				while (map[tempbx+dir[i][0]][tempby+dir[i][1]]!='#') {
					tempbx+=dir[i][0];
					tempby+=dir[i][1];
					tempbc++;
					if (map[tempbx][tempby]=='O') {
						break;
					}
				}
				
				int temprx = p.redx;
				int tempry = p.redy;
				int temprc = 0;
				
				while (map[temprx+dir[i][0]][tempry+dir[i][1]]!='#') {
					temprx+=dir[i][0];
					tempry+=dir[i][1];
					temprc++;
					if (map[temprx][tempry]=='O') {
						break;
					}
				}//빨간공과 파란공 이동완료
				
				//이동이없으면 끝
				if (tempbc==0 && temprc==0) {
					continue;
				}
				
				//파란공이 구멍에 들어갔으면 실패
				if (tempbx==holex && tempby==holey) {
					continue;
				}
				
				//파란공이 구멍에 들어가지않았는데 빨간공이 들어갔으면 성공
				if (temprx==holex && tempry==holey) {
					System.out.println(p.count+1);
					return;
				}
				
				//두공의 위치가 같으면
				if (tempbx==temprx && tempby==tempry) {
					if (temprc>tempbc) {//더많이 움직인것이 한칸뒤로 가야한다
						temprx-=dir[i][0];
						tempry-=dir[i][1];
					}else {
						tempbx-=dir[i][0];
						tempby-=dir[i][1];
					}
				}
				
				//공이들어가지않았다면 현재위치를 큐에넣고 다음이동 수행
				if (!visited[tempbx][tempby][temprx][tempry]) {
					q.offer(new point(tempbx, tempby, temprx, tempry, p.count+1));
				}
			}
		}
		System.out.println(-1);
	}
}
