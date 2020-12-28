import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj_4386_별자리만들기 {
	static class Edge implements Comparable<Edge>{
		int from,to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}
	
	static ArrayList<Edge> edgeList;
	static int parents[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		parents= new int[n];
		double stars[][] = new double[n][2];
		
		for (int i = 0; i < n; i++) {
			parents[i] = i;
		}
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				stars[i][j] = Double.parseDouble(st.nextToken());
			}
		}//입력완료
		
		//별들사이의 간선정보를 저장
		edgeList = new ArrayList<Edge>();
		for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				double distance = Math.sqrt(Math.pow(stars[i][0]-stars[j][0], 2)+Math.pow(stars[i][1]-stars[j][1], 2));
				
				edgeList.add(new Edge(i, j, distance));
			}
		}
		
		Collections.sort(edgeList); //거리정보를 기준으로 오름차순정렬
		
		//알고리즘 시작
		double answer=0;
		
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			
			if (find(edge.from)!=find(edge.to)) {
				answer+=edge.weight;
				union(edge.from,edge.to);
			}
		}
		
		System.out.println(Math.round(answer*100)/100.0);
	}

	private static int find(int from) {
		if (from ==parents[from]) {
			return from;
		}
		return parents[from]=find(parents[from]);
	}

	private static void union(int from, int to) {
		from = find(from);
		to = find(to);
		
		if(from!=to) {
			parents[to]=from;
		}
	}

}
