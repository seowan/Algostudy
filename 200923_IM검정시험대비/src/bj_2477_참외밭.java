import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2477_���ܹ� {

	//ū �簢������ ��κ��� ���¹��
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int dir[] = new int[6];
		int length[] = new int[6];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
		} //6�� �����Է� ��
		
		int area=0,point=0;
		for (int i = 0; i < 6; i++) {
			if (area<length[i]*length[(i+1)%6]) {
				area=length[i]*length[(i+1)%6]; //����ū �簢������
				point=i; //����ū �簢���� �������� ����
			}
		}
		
		int subarea=0;
		//�� �簢���� ��ǥ�� �׻� ����ū �簢���� ����Ʈ�� +3,+4��°�����´�
		//���ܹ��� �׻� 6�����̱� ������)
		subarea=length[(point+3)%6]*length[(point+4)%6];
		//���ܰ� �ڶ����ִ� ���� ���� ũ����
		area = area-subarea;
		
		System.out.println(area*num);		
	}
}
