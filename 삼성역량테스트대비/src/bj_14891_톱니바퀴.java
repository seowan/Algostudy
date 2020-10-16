import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14891_톱니바퀴 {
	//1시간 12분
	/*톱니회전부분을 이해하는게 조금 오래걸렸지만
	 * 한번이해하고나니 구현은 어렵지않았당 ㅎㅎ
	 * 톱니를 회전할때 인덱스 쓰는 부분에서 조금 헷갈렸지만..ㅠ
	 * */

	static int circle[][] = new int[5][8];
	//바퀴인덱스가 0이 12시방향, 2는 동쪽, 6은 서쪽
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int i = 1; i < 5; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				circle[i][j] = temp.charAt(j)-'0';
			}
		}//톱니바퀴 정보입력
		
		int K = Integer.parseInt(br.readLine());//톱니바퀴 회전수
		for (int i = 0; i < K; i++) {//회전시작
			st = new StringTokenizer(br.readLine());
			int target = Integer.parseInt(st.nextToken());//회전할 톱니바퀴
			int dirnum = Integer.parseInt(st.nextToken());//회전방향 1은 시계방향,-1은 반시계방향
			left(target,dirnum); //해당 톱니의 왼쪽톱니회전유무 탐색
			right(target,dirnum); //해당 톱니의 오른쪽톱니회전유무 탐색
			turn(target, dirnum); //해당 톱니 회전
		}
		
		int answer=0;
		//점수계산
		for (int i = 1; i <= 4; i++) {
			if (circle[i][0]==1) {
				answer+=Math.pow(2, i-1);
			}
		}
		System.out.println(answer);
	}

	private static void left(int target, int dirnum) { //왼쪽으로 회전가능한지 따지기
		if (target>1) {
			if (circle[target][6]!=circle[target-1][2]) {//회전이 일어나면
				left(target-1, dirnum*-1); //그것의 왼쪽도 회전하는지 따져보고
				turn(target-1,dirnum*-1); //회전을 가장 넓은 범위부터 한다
			}
		}
		
	}


	private static void right(int target, int dirnum) { //오른쪽으로 회전가능한지 따지기
		if (target<4) {
			if (circle[target][2]!=circle[target+1][6]) {//회전이 일어나면
				right(target+1, dirnum*-1);//그것의 오른쪽도 회전하는지 따져보고
				turn(target+1, dirnum*-1);//회전을 가장 넓은 범위부터 한다
			}
		}
	}
	
	private static void turn(int target,int dirnum) { //톱니 회전시키기
		int temp;
		switch (dirnum) {
		case 1: //시계방향			
			temp = circle[target][7];
			for (int i = 6; i >= 0 ; i--) {
				circle[target][i+1] = circle[target][i];
			}
			circle[target][0] = temp;
			break;
		case -1://반시계방향
			temp = circle[target][0];
			for (int i = 1; i <= 7; i++) {
				circle[target][i-1] = circle[target][i];
			}
			circle[target][7] = temp;
			break;
		}
	}

}
