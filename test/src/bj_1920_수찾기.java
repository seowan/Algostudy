import java.util.Arrays;
import java.util.Scanner;

public class bj_1920_¼öÃ£±â {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int numarr[] = new int[num1];
		int j;
		
		for (int i = 0; i < num1; i++) {
			numarr[i] = sc.nextInt();
		}
		
		Arrays.sort(numarr);
		
		int num2 = sc.nextInt();
		for (int i = 0; i < num2; i++) {
			int temp = sc.nextInt();
			for (j = 0; j < num1; j++) {
					if (temp==numarr[j]) {
						System.out.println(1);
						break;
					}	
			}
			if (j==num1) {
				System.out.println(0);
			}
			
		}
	}
}