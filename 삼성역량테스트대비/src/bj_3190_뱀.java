import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_3190_뱀 {
//20.10.10 오후 8시 35분부터 2시간소요
/*이번 문제는 생각보다 알고리즘은 빨리구현됬지만
 * 초반에 사과위치를 입력받는 과정에서 실수가있어서 디버깅을 한시간넘게했다....
 * 시뮬레이션 문제는 문제를 꼼꼼히봐서 놓치는 부분이 없도록하쟈...ㅠ*/
	static class move { //방향바꾸는거 저장
		int c;
		char changedir;

		public move(int c, char changedir) { 
			super();
			this.c = c;
			this.changedir = changedir;
		}
	}
	
	static class point{ //뱀 포인트 저장
		int tailx,taily;

		public point(int tailx, int taily) {
			super();
			this.tailx = tailx;
			this.taily = taily;
		}
		
		
	}

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 상우하좌
	static Queue<move> q = new LinkedList<move>(); //방향바꾸는거 저장해서 앞에서부터 뺴면서 사용
	static Deque<point> snake = new LinkedList<point>(); //뱀을 앞뒤로 넣고뺄수있게 덱으로 선언
	static int answer = 0; //정답 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine()); // 보드크기
		int K = Integer.parseInt(br.readLine()); // 사과개수

		int map[][] = new int[N][N];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = 1;
		} // 사과를 맵에 저장

		map[0][0] = 2; // 처음 뱀의 위치저장
		snake.offerFirst(new point(0, 0));

		int L = Integer.parseInt(br.readLine()); // 방향변환횟수
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			char b = st.nextToken().charAt(0);
			q.offer(new move(a, b));
		} // 이동정보를 스택에 저장

		// 뱀이동
		int curr = 1;// 처음에는 오른쪽으로 이동한다
		while (true) {
			answer++; //시간+1
			
			int tx = snake.peekFirst().tailx+dir[curr][0]; //머리부분 좌표조정
			int ty = snake.peekFirst().taily+dir[curr][1];
			
			//뱀이 범위를 벗어나면
			if (tx<0 || ty<0 || tx>=N || ty>=N|| map[tx][ty]==2) {
				break;
			}
			
			if (map[tx][ty]==1) { //사과를 만나면
				map[tx][ty]=2; //사과를 먹는당
				snake.offerFirst(new point(tx, ty)); //머리좌표를 덱 앞부분에 넣어줌
			}else { //사과가 아니면 꼬리자르고 머리더하기
				map[snake.peekLast().tailx][snake.peekLast().taily]=0; //꼬리부분 0으로 바꿔줌
				snake.pollLast(); //꼬리빼기
				map[tx][ty]=2; //머리를 지정해줌
				snake.offerFirst(new point(tx, ty)); //머리좌표를 덱 앞부분에 넣어줌
			}
			
			if (!q.isEmpty() && q.peek().c == answer) { // 방향바꿀타이밍이면
				if (q.poll().changedir == 'L') { // 왼쪽으로 바꾼다면
					curr = (curr + 3) % 4;
				} else { // 오른쪽으로 바꾼다면
					curr = (curr + 1) % 4;
				}
			}
		}
		System.out.println(answer);
	}

}
