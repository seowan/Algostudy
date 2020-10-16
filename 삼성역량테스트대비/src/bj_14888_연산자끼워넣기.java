import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14888_연산자끼워넣기 {
//41분소요
	/*연산자 우선순위과 관계없이 순서대로 진행*/
	/*약간 순열 조합 구현하듯이 연산자를 넣다뺏다하면서 완탐하는 방식으로 구현하였다
	 * 이제는 한번에 완벽하게 푸는 연습을 위해서 테케 만드는 연습을 해봐야겠당*/
	
	static int op[] = new int[4]; //(+ - * /)
	static int max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
	static int N,list[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		list = new int[N]; //숫자를 목록
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}//숫자입력
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}//연산자 갯수 입력
		
		//알고리즘 구현
		algo(1,list[0]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void algo(int count,int temp) { //숫자인덱스,연산결과 저장
		if (count==N) {
			min = Math.min(min, temp);
			max = Math.max(max, temp);
			return;
		}
		
		//연산자 넣기
		for (int i = 0; i < 4; i++) {
			if (op[i]>0) {
				op[i]--;
				int result=0;
				switch (i) {
				case 0:
					result = temp+list[count];
					algo(count+1,result);
					op[0]++;
					break;
				case 1:
					result = temp-list[count];
					algo(count+1,result);
					op[1]++;
					break;
				case 2:
					result = temp*list[count];
					algo(count+1,result);
					op[2]++;
					break;
				case 3:
					result = temp/list[count];
					algo(count+1,result);
					op[3]++;
					break;
				}
			}
		}
	}

}
