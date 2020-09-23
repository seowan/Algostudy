import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2491_���� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine()); //�� ���ڰ���
		int[] map =  new int[length]; //���� ������ �迭
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < length; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		} //���� �Է�
		
		int answer = 1; //���ӵǴ°��� ������ 1��ȯ
		int count=1; //ù��°���ں��� ī����
		for (int i = 0; i < length-1; i++) {
			if (map[i]<=map[i+1]) count++;
			else count=1;
			if (count>answer) answer=count;
		} //��� Ŀ���� ���
		
		count=1;
		for (int i = 0; i < length-1; i++) {
			if (map[i]>=map[i+1]) count++;
			else count=1;
			if (count>answer) answer=count;
		} //��� �۾����� ���
		
		System.out.println(answer);
	}

}
