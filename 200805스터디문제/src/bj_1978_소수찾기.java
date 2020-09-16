import java.util.Scanner;

public class bj_1978_소수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int count = 0;
		for (int i = 0; i < num; i++) {
			int num2 = sc.nextInt();
			int tempcount = 0;
			for (int j = 1; j <= num2; j++) {
				if (num2 % j == 0) {
					tempcount++;
				}
			}
			if (tempcount == 2) {
				count++;
			}
		}
		System.out.println(count);
	}
}