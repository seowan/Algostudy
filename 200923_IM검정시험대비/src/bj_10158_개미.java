import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_10158_개미 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int time = Integer.parseInt(br.readLine());
		
		int a = (p+time)%(2*x);
		int b = (q+time)%(2*y);
		
		System.out.println((x-Math.abs(x-a)) + " "+ (y-Math.abs(y-b)));
	}

}
