import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_11048_이동하기2 {

	static int dir[][] = {{1,0},{0,1},{1,1}};
	static int N,M,map[][],calc[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		calc = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st =new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				calc[i][j] = Integer.MIN_VALUE;
			}
		}//입력완료
		calc[0][0] = map[0][0];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int z = 0; z < 3; z++) {
					if (i+dir[z][0]<0 || i+dir[z][0]>=N|| j+dir[z][1]<0 || j+dir[z][1]>=M) { //범위 벗어나면 아웃
						continue;
					}
					//이동한 곳까지 먹은 사탕갯수 업데이트
					//이미 있는 값과 새로 이동한 위치까지 계산해서 더 많이 먹어진 경우로 업데이트한당
					
					calc[i+dir[z][0]][j+dir[z][1]] = Math.max(calc[i+dir[z][0]][j+dir[z][1]], calc[i][j]+map[i+dir[z][0]][j+dir[z][1]]);
				}
			}
		}
		
		//최종적으로 마지막 위치에 있는 값이 최대로 먹을수있는 사탕 갯수가 된당
		System.out.println(calc[N-1][M-1]);
	}

}
