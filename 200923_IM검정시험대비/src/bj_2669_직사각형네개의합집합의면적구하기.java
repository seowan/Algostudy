import java.util.Scanner;

public class bj_2669_���簢���װ����������Ǹ������ϱ� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//�Է��� 1���� 100���� �̹Ƿ� �迭ũ�⸦ 101,101�� ����
		boolean map[][] = new boolean[101][101];
		
		//���簢�� 4���Է�
		for (int rec = 0; rec < 4; rec++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			//���簢���� ������ true�� �ٲ��ش�
			for (int i = x1; i < x2; i++) {
				for (int j = y1; j < y2; j++) {
					map[i][j] = true;
				}
			}
		}
		//���簢���� �ִ� �������� ī���ú�������
		int count=0;		
		//��ü�� Ž���Ͽ� map�� ���� true�̸� ī��Ʈ�߰�
		for (int i = 1; i < 101; i++) {
			for (int j = 1; j < 101; j++) {
				if (map[i][j]) {
					count++;
				}
			}
		}
		System.out.println(count);
		sc.close();
	}

}
