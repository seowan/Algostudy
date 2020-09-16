import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_19637_IF문좀대신써줘 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int namenum = Integer.parseInt(st.nextToken());
		int charnum = Integer.parseInt(st.nextToken());

		String[] name = new String[namenum];
		int[] name_num = new int[namenum];

		for (int i = 0; i < namenum; i++) {
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			name_num[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < charnum; i++) {
			int num = Integer.parseInt(br.readLine());
			for (int j = 0; j < namenum; j++) {
				if (num <= name_num[j]) {
					System.out.println(name[j]);
					break;
				}
			}
		}
	}

}