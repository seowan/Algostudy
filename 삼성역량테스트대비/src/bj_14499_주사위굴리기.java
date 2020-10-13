import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14499_주사위굴리기 {
	//소요시간 30분
	/*이건 단순 구현이라 빠르게 풀었다
	 * 다행히 한번에 맞춰서 시간절약이 많이되었다
	 * 실제시험에도 이런게 나왔으면.....ㅎ*/
	static int dir[][] = {{},{0,1},{0,-1},{-1,0},{1,0}};//동서북남
	static int dice[] = {0,0,0,0,0,0};
					  //북,서,위,동,남,바닥
					  //0,1 ,2,3, 4,5
	

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int map[][] = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//지도 정보 입력받음
		
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < K; i++) {//방향에따라서 주사위 이동
			int temp = Integer.parseInt(st.nextToken());
			int tx = x+dir[temp][0];
			int ty = y+dir[temp][1];
			if (tx<0 || ty<0 || tx>=N||ty>=M) { //범위를 벗어나면 굴리지 않고 패스
				continue;
			}
			int num;
			switch (temp) {
			case 1://동쪽으로 굴리기
				num = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[3];
				dice[3] = dice[2];
				dice[2] = num;
				break;
			case 2://서쪽으로 굴리기
				num = dice[1];
				dice[1] = dice[2];
				dice[2] = dice[3];
				dice[3] = dice[5];
				dice[5] = num;
				break;
			case 3://북쪽으로 굴리기
				num = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[0];
				dice[0] = dice[2];
				dice[2] = num;
				break;
			case 4: //남쪽으로 굴리기
				num = dice[4];
				dice[4] = dice[2];
				dice[2] = dice[0];
				dice[0] = dice[5];
				dice[5] = num;
				break;
			}
			//다굴렸으면 바닥면 숫자바꿔준다 => 바닥면 인덱스는 항상 5
			if (map[tx][ty]==0) {
				map[tx][ty] = dice[5];
			}else {
				dice[5] = map[tx][ty];
				map[tx][ty]=0;
			}
			
			//주사위 윗면 출력 => 윗면 인덱스는 항상 2
			System.out.println(dice[2]);
			x = tx;
			y = ty;
		}

	}

}
