import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeSet;
//shift부분만 달라짐 
public class swea_5658_보물상자비밀번호_태희쌤_02 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // N : 8 - 28
			int C = N / 4; // 한변의 길이 : 2 - 7 ==> 회전 횟수를 결정
			int K = Integer.parseInt(st.nextToken());
			String nums = br.readLine();
			nums = nums.concat(nums);//자기자신을 한번더 붙여준다 => shift 처리하지않기 위해서

			TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return o2.compareTo(o1); // 정수일때 : o2-o1
				}
			});

			int c = 0,begin=0;
			while (c++ < C) { // 회전관련 처리 C번
				// 현상태에서 각 변의 길이만큼의 문자열비밀번호 추출하여 set에 넣기
				for (int i = begin,j=0; j<4; i+=C,++j) {
					set.add(nums.substring(i, i+C));
				}
				++begin;
			}
			
			int k=0,ans=0;
			for (String s : set) {
				if (++k==K) {
					ans=Integer.parseInt(s,16);
					break;
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}

}
