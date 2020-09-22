import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2563_������ {

	public static int board[][] = new int[100][100]; // ��ȭ��ũ��

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int paper = Integer.parseInt(br.readLine());

		for (int i = 0; i < paper; i++) { // ������ ���̱� ����
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			for (int a = x; a < x + 10; a++) { // �Է¹��� �������κ��� ������ũ�⸸ŭ
				for (int b = y; b < y + 10; b++) {
					if (board[b][a] == 0) { // �����̰� �پ������ʴٸ�
						board[b][a] = 1; // ������ ���̱�
					}
				}
			}
		} // �����̸� ���δ� ����

		int count = 0; // ������ ���ο��� ��������
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (board[i][j] == 1) {
					count++; // �����̰� �پ��ִٸ� ����ī��Ʈ
				}
			}
		}
		System.out.println(count);
	}

}
