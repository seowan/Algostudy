import java.util.Scanner;

public class bj_10250_acmȣ�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TestCase = sc.nextInt();

		for (int i = 0; i < TestCase; i++) {
			int H = sc.nextInt();
			int W = sc.nextInt();
			int person = sc.nextInt();
			// ��+1�� ȣ�� �������� ����
			int floor = person % H;
			int room = (person / H) + 1;

			if (floor == 0) {
				room = person / H;
				floor = H;
			}
			System.out.println((floor * 100) + room);
		}
	}
}