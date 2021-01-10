import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_10026_적록색약 {
	static int N;
	static char map[][];
	static boolean visited[][];
	static int [][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws Exception{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			map[i] = temp.toCharArray();
		}
		int count=0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]==true) continue;
				count++;
				visited[i][j]=true;
				dfs(i,j,map[i][j]);
			}
			
		}
		
		int count2=0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j]==true) continue;
				count2++;
				visited[i][j]=true;
				dfs2(i,j,map[i][j]);
			}
			
		}
		System.out.println(count+" "+count2);
	}

	private static void dfs2(int i, int j, char c) {
		for (int k = 0; k < 4; k++) {
			int x = i+dir[k][0];
			int y = j+dir[k][1];
			
			if (x>=0 && y>=0 && x<N && y<N && !visited[x][y]) {
				if (c=='R' || c=='G') {
					if (map[x][y]=='R'|| map[x][y]=='G') {
						visited[x][y]=true;
						dfs2(x, y, c);
					}
					continue;
				}else if (c==map[x][y]) {
					visited[x][y]=true;
					dfs2(x, y, c);
				}
			}
		}
		
	}

	private static void dfs(int i, int j, char c) {
		for (int k = 0; k < 4; k++) {
			int x = i+dir[k][0];
			int y = j+dir[k][1];
			
			if (x<0 || y<0 || x>=N || y>=N || map[x][y]!=c || visited[x][y]) continue;
			visited[x][y]=true;
			dfs(x, y, c);
		}
	}
}