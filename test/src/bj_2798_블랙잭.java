import java.util.Scanner;

public class bj_2798_∫Ì∑¢¿Ë {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int CardNum = sc.nextInt();
		int sum = sc.nextInt();
		int card [] = new int[CardNum];
		int temp=0,max=0;
		
		for (int i = 0; i < CardNum; i++) {
			card[i] = sc.nextInt();
		}
		
		for (int i = 0; i < CardNum; i++) {
			for (int j = i+1; j < CardNum; j++) {
				for (int k = j+1; k < CardNum; k++) {
					temp = card[i]+card[j]+card[k];
					if (temp<=sum && temp>max) {
						max=temp;
					}
				}
			}
		}
		
		System.out.println(max);
	}
}
