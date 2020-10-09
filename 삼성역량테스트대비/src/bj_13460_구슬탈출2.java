import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_13460_구슬탈출2 {
//20.10.09 오후 2시30분부터 풀이  오후 4시 40분 제출 => 2시간 10분소요
/*하나의 상태에서 사방으로 움직인다음 그 결과를 토대로 또 사방탐색 이므로 bfs로 풀이*/
/*파란공과 빨간공이 동시에 이동하므로 하나의 방향으로 이동할때 같이 이동하게해준다
 *이동을 전부 마친후에 예외조건들을 적용해서 답을 도출해준다
 *1. 이동이 없는경우
 *2. 파란공이 들어가는 경우를 먼저 생각해주면 파란공만들어가는경우와 빨간공과 동시에 들어가는 경우를 모두 체크해줄수있다
 *3. 빨간공이 들어가는 경우 동작횟수를 출력하여 연산종료(큐를 이용했으므로 현재 빨간공이 들어가는 경우가 가장 최소가 된당
 *4. 구슬은 들어가지 않았지만 두공의 위치가 같은경우 해당위치까지 갈때 이동횟수를 비교하여 공의 위치를 조정해준다
 *위의 조건에 모두 걸리지 않는다면 해당위치값을 큐에넣어 해당위치에서 또 사방탐색을 할수있게 해준다
 *
 *이문제를 풀면서 가장힘들고 시간이 많이 소요된것은 방문처리이다.
 *방문처리를 연산시간을 줄이기위해(서로다른 방향으로 이동횟수가 10이상이 될때까지 계속 왔다왔다 하는경우) 꼭 필요한데,
 *처음에는 파란공,빨간공 각각을 선언하고 하니 파란공의 위치에따른 빨간공의 위치를 카운팅하지못하는 경우가생겼다....
 *엄청난 디버깅 시간을 소요한후에
 *4차 배열로 선언해서 파란공의 위치에따른 빨간공의 위치를 방문처리하는것으로 바꾸었다.
 *예시 => 파란공이(1,2)에있을때 빨간공이(3,4),(5,6)에 있는경우와
 *      파란공이(3,7)에있을때 빨간공이(3,4),(5,6)에 있는경우는 다른경우이다 => 근데 이것을 2차원배열 두개로 점검하면 같은것으로 본다*/
	
	static class point{ //파란공,빨간공,몇번 동작했는지 세기위한 변수를 클래스로 선언
		int bx,by,rx,ry,count;

		public point(int bx, int by, int rx, int ry, int count) {
			super();
			this.bx = bx;
			this.by = by;
			this.rx = rx;
			this.ry = ry;
			this.count = count;
		}
		
	}
	static int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}}; //사방탐색
	static int hx,hy; //구멍의 위치는 변하지않으므로 static으로 선언
	static char board[][]; //보드판 상태 저장할 배열
	static Queue<point> queue = new LinkedList<point>();
	//static boolean visitedb[][],visitedr[][];
	static boolean visited[][][][]; //하나의 공의 상태에따라 다른공의 위치를 방문표시하기위해 4차원으로 선언 // 여기서 시간소요 너무많이했당...ㅠㅠ


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //가로
		int M = Integer.parseInt(st.nextToken()); //세로
		
		int bx=0,by=0,rx=0,ry=0; //bx,by는 파란공의 위치좌표, rx,ry는 빨간공의 위치좌표
		
		board = new char[N][M]; //보드판 정의
		//visitedb = new boolean[N][M];
		//visitedr = new boolean[N][M];
		visited = new boolean[N][M][N][M]; //방문표시할 배열크기 정의
		
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);
				if (board[i][j]=='B') {bx = i; by = j;} //파란공이 입력되면 해당 좌표값저장
				if(board[i][j]=='R') {rx=i; ry=j;} //빨간공이 입력되면 해당 좌표값 저장
				if(board[i][j]=='O') { hx=i; hy=j;} //구멍이 입력되면 해당 좌표값 저장
			}
		}//저장끝
		
		point p = new point(bx, by, rx, ry, 0); 
		queue.offer(p); //처음 파란공,빨간공,동작횟수를 큐에저장
		//탐색시작
		bfs();
	}

	private static void bfs() {
		while (!queue.isEmpty()) { //큐가 빌때까지 반복
			point p = queue.poll(); //큐에서 하나 꺼낸다
		//	visitedb[p.bx][p.by] = true;
		//	visitedr[p.rx][p.ry] = true;
			visited[p.bx][p.by][p.rx][p.ry]=true; //파란공의 상태에 따른 빨간공의 상태를 방문처리
			
			if (p.count>9) { //10이상 동작하면 안댐
				System.out.println(-1); //10번이상 동작하면 실패처리
				return;
			}
			
			//사방으로 동작하기
			for (int i = 0; i < 4; i++) {
				//파란색 먼저
				int tbx = p.bx;
				int tby = p.by;
				int tbc=0; //파란공이 몇칸움직였는지 세기위한 변수
				
				while (board[tbx+dir[i][0]][tby+dir[i][1]] !='#') { //벽을 만날때까지 계속해서 반복
					tbx = tbx+dir[i][0]; //한칸씩이동
					tby = tby+dir[i][1];
					tbc++; 
					if (board[tbx][tby]=='O') { //만약 이동중에도 파란공이 구멍이 빠진다면   //이부분도 생각하느라 쪼금 시간을 소모했다
 						break; //일단 이동 정지
					}
				}
				
				//빨간색
				int trx = p.rx;
				int trry = p.ry;
				int trc=0; ////빨간공이 몇칸움직였는지 세기위한 변수
				
				while (board[trx+dir[i][0]][trry+dir[i][1]] !='#') {
					trx = trx+dir[i][0];
					trry = trry+dir[i][1];
					trc++;
					if (board[trx][trry]=='O') {
						break;
					}
				}

				
				if (tbc==0 && trc==0) { //만약 빨간공과 파란공이 모두 움직이지 않았다면
					continue; //큐에넣지않고 다른 방향탐색실행
				}
				
				//파란구슬이 들어가면 실패
				if (board[tbx][tby] =='O') {
					continue; //다른 방향탐색  //처음에는 여기서 출력을 하고 리턴을했다 => 그렇게하니까 다른경우를 생각하지못하므로 continue가 적절
				}
				
				//빨간구슬이 들어가면 성공 => 횟수출력
				if (board[trx][trry]=='O') {
					System.out.println(p.count+1); //현재 값이 동작을 가장 최소로 한 결과이므로 그냥 출력하고 끝내도된당
					return;
				}
				
				//구슬이 들어가지 않았는데 위치가 똑같다면 좌표변경
				if (tbx==trx && tby==trry) {
					if (tbc<trc) { //빨간공이 더많이 움직였다면
						trx = trx-dir[i][0]; //파란공보다 한칸덜 이동하게 위치조정
						trry = trry-dir[i][1];
					}else { //파란공이 더많이 움직였다면
						tbx = tbx-dir[i][0]; //빨간공보다 한칸덜 이동하게 위치조정
						tby = tby-dir[i][1];
					}
				}
				
				
				//큐에넣기
				//if (!visitedb[tbx][tby] || !visitedr[trx][trry]) {
				if(!visited[tbx][tby][trx][trry]) { //만약 방문한적없는 좌표라면
					queue.offer(new point(tbx, tby, trx, trry, p.count+1)); //큐에넣어준당
				}
			}
		}
		System.out.println(-1); //더이상 연산할수없는 경우 종료
		
	}

}