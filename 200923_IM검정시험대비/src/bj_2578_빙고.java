import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2578_빙고 {
	public static int map[][] = new int[5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 빙고판 입력완료

		int num, count = 0;//count:사회자가 부른 숫자개수
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				count++;
				num = Integer.parseInt(st.nextToken());
				if (linesearch(num) >= 3) { //빙고라인수가 3개이상이면
					System.out.println(count); //갯수출력
					return; //종료
				}
			}
		}
	}

	private static int linesearch(int num) {//라인갯수 탐색
		int line = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == num) {
					map[i][j] = 0; //방금부른숫자를 처리
					j = 5;
					i = 5;
				}
			}
		}

		// 가로탐색
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] > 0) {
					break;
				}
				if (j == 4) {
					line++;
				}
			}

		}

		// 세로탐색
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i] > 0) {
					break;
				}
				if (j == 4) {
					line++;
				}
			}

		}

		// 대각선 탐색
		for (int i = 0; i < 5; i++) {
			if (map[i][i] > 0) {
				break;
			}
			if (i == 4) {
				line++;
			}
		}

		for (int i = 4; i >= 0; i--) {
			if (map[4-i][i] > 0) {
				break;
			}
			if (i == 0) {
				line++;
			}
		}
		return line; //총 빙고라인수를 리턴
	}

}
