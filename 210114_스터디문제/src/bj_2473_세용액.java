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
			int start = i+1;//시작점
			int end = N-1;//끝점
			while (start<end) {//시작점이 끝점을 지나지않을때만 수행
				if (Math.abs(water[i]+water[start]+water[end])<min) {//세용액합이 min보다 작을경우
					min = Math.abs(water[i]+water[start]+water[end]);//min값 갱신
					answer[0] = water[i];
					answer[1] = water[start];
					answer[2] = water[end];
				}
				
				if (water[i]+water[start]+water[end]<0) {//세용액합이 0보다 작으면
					start++;//시작점을 다음으로 옮긴다
				}else end--;//그렇지 않으면 끝점을 하나당긴다
			}
		}
		
		System.out.println(answer[0] + " "+answer[1] + " "+answer[2]);
	}

}
