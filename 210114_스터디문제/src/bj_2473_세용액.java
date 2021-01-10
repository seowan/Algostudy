import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2473_세용액 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long water[] = new long[N];
		long min = Long.MAX_VALUE;
		long answer[] = new long[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			water[i] = Long.parseLong(st.nextToken());
		}//용액 정보 입력 끝
		
		Arrays.sort(water);//정렬
		
		for (int i = 0; i < N; i++) { //이게 용액 기준점으로 연산
			int start = i+1;
			int end = N-1;
			while (start<end) {
				if (Math.abs(water[i]+water[start]+water[end])<min) {
					min = Math.abs(water[i]+water[start]+water[end]);
					answer[0] = water[i];
					answer[1] = water[start];
					answer[2] = water[end];
				}
				
				if (water[i]+water[start]+water[end]<0) {
					start++;
				}else end--;
			}
		}
		
		System.out.println(answer[0] + " "+answer[1] + " "+answer[2]);
	}

}
