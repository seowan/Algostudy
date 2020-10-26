import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2293_동전1 {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int num[] = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}//동전가치 입력끝
		
		int result[] = new int[k+1];
		result[0]=1;
		
		for (int i = 0; i < n; i++) {
			for (int j = num[i]; j <= k; j++) {
				result[j]+=result[j-num[i]];
			}
		}
		
		System.out.println(result[k]);
	}

}
