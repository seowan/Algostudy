import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2491_수열 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine()); //총 숫자개수
		int[] map =  new int[length]; //숫자 저장할 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		} //수열 입력
		
		int answer = 1; //연속되는것이 없으면 1반환
		int count=1; //첫번째숫자부터 카운팅
		for (int i = 0; i < length-1; i++) {
			if (map[i]<=map[i+1]) count++;
			else count=1;
			if (count>answer) answer=count;
		} //계속 커지는 경우
		
		count=1;
		for (int i = 0; i < length-1; i++) {
			if (map[i]>=map[i+1]) count++;
			else count=1;
			if (count>answer) answer=count;
		} //계속 작아지는 경우
		
		System.out.println(answer);
	}

}
