import java.util.Scanner;

public class bj_2527_직사각형 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			//좌표입력 끝
			
			if ((x>p2 || x2>p) || (y>q2 || y2>q)) {
				//두 사각형이 떨어져있는경우
				System.out.println("d");
			}
			else if ((x==p2 || x2==p) && (y==q2 || y2==q)) {
				//하나의점에서 만났을때
				System.out.println("c");
			}
			else if ((x==p2 || x2==p) || (y==q2 || y2==q)) {
				//선분이 일치할때
				System.out.println("b");
			}else System.out.println("a"); //사각형이 겹쳐지는 경우
		}
		sc.close();
	}
}
