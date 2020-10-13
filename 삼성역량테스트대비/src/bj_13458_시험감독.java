import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_13458_시험감독 {
	//15분소요
	/*이문제는 정말 역테에 기출로 나왔었나...했지만
	 * 마지막 답을 보고 그럴만했다는 생각을했다.
	 * 로직은 쉬우나 최종답의 변수를 int가 아닌 long형으로 선언해야한다는 것이 매우 중요한 포인트였다
	 * 나도 숫자는 무조건 int로 선언하는 습관이있는데
	 * 이문제는 최악의 경우 감독관이 1,000,000 * 1,000,000명이 필요한 상황인데 이숫자는 int형에 담을수가없다
	 * 따라서 long형으로 선언하여 답을 리턴해야한다
	 * 디테일을 좀더 신경쓸수있는 문제인거같당*/

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int testroom[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			testroom[i] = Integer.parseInt(st.nextToken());
		}//반에 있는 학생수 입력
		
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); //총감독관
		int C = Integer.parseInt(st.nextToken()); //부감독관
		
		long answer=0;
		
		for (int i = 0; i < N; i++) { //반별로 카운팅한다
			int temp = testroom[i]; //그 반의 학생수를 임시로 저장
			temp-=B;
			answer++; //총감독관 한명배정
			
			if (temp<=0) {
				continue;
			}

			int num = temp/C;
			temp = temp-((num)*C);
			answer+=num;
			
			if (temp>0) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
