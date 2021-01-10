import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_9466_팀프로젝트 {

	static int student[],count;
	static boolean visited[],revisited[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			student = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				student[i] = Integer.parseInt(st.nextToken());
			}//입력완료
			
			count=0;
			visited = new boolean[n+1];
			revisited = new boolean[n+1];
			for (int i = 1; i <= n; i++) {//알고리즘 시작
				if (!visited[i]) {
					counting(i);
				}
			}
			System.out.println(n-count);
		}
	}

	private static void counting(int index) {
		visited[index]=true;
		int num = student[index];
		if (!visited[num]) {
			counting(num);
		}else if(!revisited[num]) {
			for (int i = num; i != index; i=student[i]) {
				count++;
			}
			count++;
		}
		revisited[index]= true;
	}

}
