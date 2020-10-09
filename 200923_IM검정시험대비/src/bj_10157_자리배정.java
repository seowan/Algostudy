import java.util.Scanner;

public class bj_10157_자리배정 {
	static int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int K = sc.nextInt();
		
		
		if (K>C*R) System.out.println(0); //번호표를 줄수없는경우
		else {
			int [][] map = new int[R+1][C+1];
			int d = 0;
			int r=1,c=1; //1,1부터 시작
			
			for (int i = 1; i <= K; i++) {
				map[r][c]=i;
				if (i==K) break;
				
				int tr=r+dir[d][0];
				int tc=c+dir[d][1];
				
				if (0<tr && 0<tc && tr<=R && tc<=C && map[tr][tc]==0) {
					r=tr;
					c=tc;
				}else { //방향전환
					d=(d+1)%4;
					r+=dir[d][0];
					c+=dir[d][1];
				}
			}
			System.out.println(r+" "+c);
		}
		sc.close();
	}
}
