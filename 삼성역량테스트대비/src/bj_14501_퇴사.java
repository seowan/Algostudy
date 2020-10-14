import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14501_퇴사 {
//20.10.14 27분 소요
	/*dfs방식으로 하루고르고...그다음에 고를수있는거또 고르고...그다음에 고를수있는거 또고른다...
	 * 수업때는 dp로 한거같은데 dp보다 더 간단하게 할수있을거같아서 내방식대로 했당*/
	
	static int N,day[][],answer=Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		day = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			day[i][0] = Integer.parseInt(st.nextToken());
			day[i][1] = Integer.parseInt(st.nextToken());
		}//입력끝
		
		dayselect(0,0);//첫날부터 탐색
		System.out.println(answer);
	}
	private static void dayselect(int target, int temp) {
		if (target>=N) {
			//최종 정답구하기
				answer = Math.max(answer, temp);
				return;			
		}
		
		if (target+day[target][0]<=N) { //오늘날짜의 상담을 끝낸것이 퇴사날보다 앞이거나 같다면
			dayselect(target+day[target][0], temp+day[target][1]); 
		}else dayselect(target+day[target][0], temp); //오늘날짜의 상담을 끝낸것이 퇴사날보다 뒤라면 => 성립할수없다 => 리턴되서 내려와 이날짜를 선택하지 않는것으로 한다
		
		dayselect(target+1, temp);//이 날짜 상담은 건너뜀
	}

}
