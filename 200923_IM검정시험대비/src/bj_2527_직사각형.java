import java.util.Scanner;

public class bj_2527_���簢�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < 4; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();
			//��ǥ�Է� ��
			
			if ((x>p2 || x2>p) || (y>q2 || y2>q)) {
				//�� �簢���� �������ִ°��
				System.out.println("d");
			}
			else if ((x==p2 || x2==p) && (y==q2 || y2==q)) {
				//�ϳ��������� ��������
				System.out.println("c");
			}
			else if ((x==p2 || x2==p) || (y==q2 || y2==q)) {
				//������ ��ġ�Ҷ�
				System.out.println("b");
			}else System.out.println("a"); //�簢���� �������� ���
		}
		sc.close();
	}
}
