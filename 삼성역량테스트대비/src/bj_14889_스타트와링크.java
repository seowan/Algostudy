import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14889_스타트와링크 {
	//45분소요
	
	/*조합으로 N/2 만큼 뽑아서 구성한당 그리고 나서 완탐
	 * 조합으로 2팀을 구성 N/2명씩 뽑아서
	 * 각 팀의 능력치를 구해서 차이를 구한다
	 * 다행히 한번에 짠 대로 맞아서 시간이 많이절약되었다
	 * 테케를 찾지는 못했지만 디버깅을 통해 검증하고 제출하였당*/

	static int answer=Integer.MAX_VALUE;
	static int N,num[][];
	static boolean person[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N+1][N+1]; //사람번호를 그냥 인덱스로 쓴다
		person = new boolean[N+1]; //팀구성을 위한 배열 //true와 false가 각각팀이다
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
			}
		}//능력치 입력완료
		
		teamcom(1,0); 
		System.out.println(answer);
	}

	private static void teamcom(int start, int count) {
		if (count==(N/2)) {
			answer = Math.min(answer, value()); //팀구성 다했으면 차이값을 구한당
			return;
		}
		
		for (int i = start; i <= N; i++) {
			person[i] = true;
			teamcom(i+1, count+1);
			person[i] = false;
		}
	}

	private static int value() {
		int teama=0;
		int teamb=0;
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (person[i] && person[j]) {
					teama+=num[i][j];
				}
				
				if (!person[i] && !person[j]) {
					teamb+=num[i][j];
				}
			}
		}
		
		return Math.abs(teama-teamb);
	}
}