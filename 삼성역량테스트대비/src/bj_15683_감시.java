import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_15683_감시 {
//20.10.14 7:10시작 8:25끝 =>1시간 15분 소요
	/* cctv 하나 설치하고 또 하나 설치하고 또하나설치하고...해야하므로 dfs방식을 이용하여 구현 
	 * 시간단축을 위해 직관적으로 코드를 짜다보니 코드도 길어지고 깔끔하게 된건아니지만
	 * 문제를 맞추기위해서는 이방법이 최선인거같당!*/

	static class point { //카메라의 위치정보와 종류정보 저장
		int x, y, cc;

		public point(int x, int y, int cc) {
			super();
			this.x = x;
			this.y = y;
			this.cc = cc;
		}

	}

	static int dir[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상우하좌
	static int N, M, map[][], answer = Integer.MAX_VALUE;
	static ArrayList<point> cctv = new ArrayList<point>(); // cctv목록들 저장(좌표,종류)

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0 && map[i][j] < 6) {
					cctv.add(new point(i, j, map[i][j]));
				}
			}
		} // 정보입력 끝

		setting(0, map); // cctv설치하는 함수
		System.out.println(answer);
	}

	//cctv방향 세팅
	private static void setting(int count, int tempmap[][]) {
		if (count == cctv.size()) { //다 설치 했다면
			// 최소값찾기
			int non = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tempmap[i][j] == 0) {
						non++;
					}
				}
			}
			answer = Math.min(answer, non);
			return;
		}

		// 감시카메라 모두를 설치하지 않았다면
		point p = cctv.get(count);
		int tx = p.x;
		int ty = p.y;
		int temp = p.cc;

		switch (temp) {
		case 1:
			for (int i = 0; i < 4; i++) { // 방향4개
				watch(tx, ty, i);
				setting(count + 1, tempmap);
				back(tx, ty, i);
			}
			break;
		case 2:
			for (int i = 0; i < 2; i++) { //위아래 이므로 두개만 하면된당
				watch(tx, ty, i);
				watch(tx, ty, i+2);
				setting(count+1, tempmap);
				back(tx, ty, i+2);
				back(tx, ty, i);
			}
			break;
		case 3:
			for (int i = 0; i < 4; i++) {
				watch(tx, ty, i);
				watch(tx, ty, (i+1)%4);
				setting(count+1, tempmap);
				back(tx, ty, (i+1)%4);
				back(tx, ty, i);
			}

			break;
		case 4:
			for (int i = 0; i < 4; i++) {
				watch(tx, ty, i);
				watch(tx, ty, (i+3)%4);
				watch(tx, ty, (i+1)%4);
				setting(count+1, tempmap);
				back(tx, ty, (i+1)%4);
				back(tx, ty, (i+3)%4);
				back(tx, ty, i);
			}
			break;
		case 5:
			watch(tx, ty, 0);
			watch(tx, ty, 1);
			watch(tx, ty, 2);
			watch(tx, ty, 3);
			setting(count+1, tempmap);
			back(tx, ty, 3);
			back(tx, ty, 2);
			back(tx, ty, 1);
			back(tx, ty, 0);
			break;
		}
	}

	//카메라가 바라보는 방향의 값을 바꿔준다 (일괄적으로 +10)
	private static void watch(int tx, int ty, int dirnum) {

		while (true) {
			tx += dir[dirnum][0];
			ty += dir[dirnum][1];
			if (tx < 0 || ty < 0 || tx >= N || ty >= M || map[tx][ty] == 6) {
				break;
			} else {
				map[tx][ty] += 10;
			}
		}

	}

	//카메라의 방향이 바뀔것이므로 이전에 설정한 값들을 회수한다(일괄적으로 -10)
	private static void back(int tx, int ty, int dirnum) {
		while (true) {
			tx += dir[dirnum][0];
			ty += dir[dirnum][1];
			if (tx < 0 || ty < 0 || tx >= N || ty >= M || map[tx][ty] == 6) {
				break;
			} else {
				map[tx][ty] -= 10;
			}
		}

	}
}