import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1244_����ġ�Ѱ���� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int swinum = Integer.parseInt(br.readLine()); //��ü����ġ ����
		int num[] = new int[swinum+1]; //����ġ ���¸� �����ϱ����� �迭
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= swinum; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		} //����ġ ���� �Է� ����
		
		int person = Integer.parseInt(br.readLine()); //�л��� �Է� ����
		for (int i = 0; i < person; i++) { //�л����� ����ġ �Ѱ���� ����
			st = new StringTokenizer(br.readLine());
			int kind = Integer.parseInt(st.nextToken()); //��,�� ����
			int given = Integer.parseInt(st.nextToken()); //����ġ��ȣ
			int index; 			
			switch (kind) { //���л�,���л��� ���� �ٸ��� ����ġ����
			case 1: //���л��� ���
				index=1;
				while (true) {
					if (index*given<=swinum) { //�ο����� ��ȣ�ǹ���� ����ġ�ȿ�������
						if (num[index*given]==0) { 
							num[index*given]=1;
						}else num[index*given]=0;
					index++; //����ġ�� �����ϰ� �ε��� 1����
					}else break; //����ġ���� ���̸� ����
				}
				break; //�ش� �л��� ����ġ ���� ����

			case 2: //���л��� ���
				index=1;
				if (num[given]==0) { //�ϴ� �ο����� ��ȣ�� ����ġ�� ����
					num[given]=1;
				}else num[given]=0;
				
				while (true) {
					if ((given-index)>0 && (given+index)<=swinum && //�ֺ� ����ġ�� �����ȿ��ְ�
							num[given-index]==num[given+index]) { //����ġ���°� ���ٸ�
						if (num[given-index]==0) {
							num[given-index]=num[given+index]=1;
						}else num[given-index]=num[given+index]=0;
					index++; //����ġ������ �ε��� ����
					}else break; //�׷��������� ����
				}
				break; //�ش� �л��� ����ġ ���� ����
			}
		}
		
		for (int i = 1; i <= swinum; i++) {
			sb.append(num[i]+" ");
			if (i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
