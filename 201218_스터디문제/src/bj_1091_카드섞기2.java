import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1091_카드섞기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int P[] = new int[N];//최종 답안 배열 => 인덱스 넘버가 카드이다
		int S[] = new int[N];//카드섞는 방법 배열
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}//입력끝
		
		int answer[] = new int[N]; //카드섞일때마다 바뀌는 배열
		int temp[] = new int[N];
		int count=0;
		
		for (int i = 0; i < N; i++) {
			answer[i] = i%3;
			temp[i] = i%3;
		}//초기값설정
		
		while (true) {
			boolean check = true;
			//같은지 다른지 비교
			for (int i = 0; i < N; i++) {
				if (answer[i]!=P[i]) {
					check=false;
					break;
				}
			}
			
			if (!check) {//다르면 카드섞기
				count++;
				for (int i = 0; i < N; i++) {
					temp[i] = answer[i];
				}//배열값 복사하기
				
				for (int i = 0; i < N; i++) {
					answer[i] = temp[S[i]];
				}//카드섞기
				
			}else {//같으면 답내주기
				System.out.println(count);
				break;
			}
			/*처음 주어진것과 같으면 계속 반복되므로 아무리 섞어도 답이 나올수없당*/
			/*vvvvvv반복되는지 아닌지 체킹하는 부분vvvvvv*/
			check = true;
			for (int i = 0; i < N; i++) {
				if (answer[i]!=i%3) {
					check=false;
					break;
				}
			}
			
			if (check) {
				System.out.println(-1);
				break;
			}
			/*^^^^^^반복되는지 아닌지 체킹하는 부분^^^^^^*/
		}
		
	}

}
