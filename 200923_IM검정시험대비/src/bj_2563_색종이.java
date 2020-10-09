import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2563_색종이 {

	public static int board[][] = new int[100][100]; // 도화지크기

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paper = Integer.parseInt(br.readLine());

		for (int i = 0; i < paper; i++) { // 색종이 붙이기 시작
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a = x; a < x + 10; a++) { // 입력받은 지점으로부터 색종이크기만큼
				for (int b = y; b < y + 10; b++) {
					if (board[b][a] == 0) { // 색종이가 붙어있지않다면
						board[b][a] = 1; // 색종이 붙이기
					}
				}
			}
		} // 색종이를 전부다 붙임

		int count = 0; // 색종이 붙인영역 갯수세기
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] == 1) {
					count++; // 색종이가 붙어있다면 영역카운트
				}
			}
		}
		System.out.println(count);
	}

}
