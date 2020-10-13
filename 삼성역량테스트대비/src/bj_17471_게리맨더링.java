import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_17471_게리맨더링 {
//20.10.13 1시간 5분소요
/*예전에 풀건데도 다시푸니까 잘안되서 시간이 좀 걸렸다
 * 처음에 시간이 짧길래 걱정많이했는데
 * 풀수록 자료구조 사용하는게 많아서....괜히 적게쓰려고 해보다가 실패하고 다시했다...
 * 앞으로는 자료구조를 많이쓰는것을 두려워하지말아야겠당!*/
	static int N,ingu[],answer = Integer.MAX_VALUE;
	static boolean selected[],arr[][];
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ingu = new int[N+1]; //인구수 저장
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			ingu[i] = Integer.parseInt(st.nextToken());
		} //인구정보 입력
		
		arr = new boolean[N+1][N+1]; //인접정보 
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < temp; j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][a] = true;
			}
		}//인접정보 입력
		selected = new boolean[N+1];
		subset(1); //서브셋으로 다양한 구들을 탐색
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else System.out.println(answer);
	}

private static void subset(int index) {
	
	if (index==N) {
		//선택한 부분집합을 기준으로 판단하기 => 연결되어있는지,연결되어있다면 인구자리가 최소인것 찾기
		if (connect()) {
			int suma=0;
			int sumb=0;
			for (int i = 1; i <= N; i++) {
				if (selected[i]) {
					suma+=ingu[i];
				}else {
					sumb+=ingu[i];
				}
			}
			answer = Math.min(answer, Math.abs(suma-sumb));
		}
		return;
	}

		selected[index] = true;
		subset(index+1);
		selected[index] = false;
		subset(index+1);

}

private static boolean connect() {
	List<Integer> aa = new ArrayList<Integer>();
	List<Integer> bb = new ArrayList<Integer>();
	for (int i = 1; i <= N; i++) {
		if (selected[i]) {
			aa.add(i);
		}else bb.add(i);
	}
	
	//참인구역
	boolean visitemp[] = new boolean[N+1];
	Queue<Integer> queue = new LinkedList<Integer>();
	if (aa.size()>0) {
		queue.add(aa.get(0));
		visitemp[aa.get(0)] = true;
		while (!queue.isEmpty()) {
			int point = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (selected[i]&&arr[point][i] && !visitemp[i]) {
					visitemp[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	//거짓인구역
	if (bb.size()>0) {
		queue.add(bb.get(0));
		visitemp[bb.get(0)] = true;
		while (!queue.isEmpty()) {
			int point = queue.poll();
			for (int i = 1; i <= N; i++) {
				if (!selected[i]&&arr[point][i] && !visitemp[i]) {
					visitemp[i] = true;
					queue.add(i);
				}
			}
		}
	}
	
	for (int i = 1; i <= N; i++) {//방문안한곳이 있다면 거리계산할 필요가없다!(이어져있지 않은것이므로)
		if (!visitemp[i]) {
			return false;
		}
	}
	return true;
}

}
