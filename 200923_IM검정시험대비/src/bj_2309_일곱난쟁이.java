import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2309_�ϰ������� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int person[] = new int[9]; //������ Ű �Է¹��� �迭
		int sum=0; //������ Ű ���� ������ �迭
		
		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
			sum+=person[i];
		} //������ Ű�Է� ����
		
		Arrays.sort(person);
		
		for (int i = 8; i >= 0 ; i--) {
			for (int j = i-1; j >= 0; j--) { //Ű�� ū������ ������ �θ��� �̾Ƽ�
				if (sum-person[i]-person[j]==100) { //���� 100�̵Ǹ�
					for (int z = 0; z < 9; z++) { //������ Ű ���
						if (z!=i && z!=j) {
							System.out.println(person[z]);
						}
					}
					j=-1;
					i=-1;
				}
			}
		}
	}

}
