import java.util.Scanner;

public class bj_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//입력이 1부터 100까지 이므로 배열크기를 101,101로 지정
		boolean map[][] = new boolean[101][101];
		
		//직사각형 4개입력
		for (int rec = 0; rec < 4; rec++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//직사각형의 범위를 true로 바꿔준다
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
		//직사각형이 있는 범위갯수 카운팅변수선언
		int count=0;		
		//전체를 탐색하여 map의 값이 true이면 카운트추가
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
