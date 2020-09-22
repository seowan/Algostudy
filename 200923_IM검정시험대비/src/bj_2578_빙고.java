import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2578_���� {
	public static int map[][] = new int[5][5];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // ������ �Է¿Ϸ�

		int num, count = 0;//count:��ȸ�ڰ� �θ� ���ڰ���
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				count++;
				num = Integer.parseInt(st.nextToken());
				if (linesearch(num) >= 3) { //������μ��� 3���̻��̸�
					System.out.println(count); //�������
					return; //����
				}
			}
		}
	}

	private static int linesearch(int num) {//���ΰ��� Ž��
		int line = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] == num) {
					map[i][j] = 0; //��ݺθ����ڸ� ó��
					j = 5;
					i = 5;
				}
			}
		}

		// ����Ž��
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[i][j] > 0) {
					break;
				}
				if (j == 4) {
					line++;
				}
			}

		}

		// ����Ž��
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (map[j][i] > 0) {
					break;
				}
				if (j == 4) {
					line++;
				}
			}

		}

		// �밢�� Ž��
		for (int i = 0; i < 5; i++) {
			if (map[i][i] > 0) {
				break;
			}
			if (i == 4) {
				line++;
			}
		}

		for (int i = 4; i >= 0; i--) {
			if (map[4-i][i] > 0) {
				break;
			}
			if (i == 0) {
				line++;
			}
		}
		return line; //�� ������μ��� ����
	}

}
