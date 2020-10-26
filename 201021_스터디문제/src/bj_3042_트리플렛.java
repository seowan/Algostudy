import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class bj_3042_트리플렛 {

	static int dir[][] = {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};//8방탐색
	static int answer=0,N,result=0;
	static char map[][];
	static boolean check[] = new boolean[26];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}//입력 종료
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]!='.') {
					check[map[i][j]-65]=true;
					for (int z = 0; z < 8; z++) {
						int x = i+dir[z][0];
						int y = j+dir[z][1];
						
						if (x<0 || y<0|| x>=N|| y>=N||map[x][y]=='.') {
							continue;
						}
						
						check[map[x][y]-65]=true;
						dfs(x,y,z,2);
					}
				}
			}
		}
		
		for (int i = 0; i < 26; i++) {
			if (check[i]) {
				result++;
			}
		}
		System.out.println(result);
		//System.out.println(answer);
		
	}

	private static void dfs(int x, int y, int dirr, int count) {
		if (count>=3) {
			//answer++;
			return;
		}
		int tx = x+dir[dirr][0];
		int ty = y+dir[dirr][1];
		
		if (tx<0 || ty<0 ||tx>=N|| ty>=N ||map[tx][ty]=='.') {
			return;
		}
		
		check[map[tx][ty]-65]=true;
		dfs(tx, ty, dirr, count+1);
		
	}

}