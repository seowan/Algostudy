import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_10814_나이순정렬{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		String[][] person = new String[num][2];
		for (int i = 0; i < num; i++) {
			person[i][0] = sc.next();
			person[i][1] = sc.next();
		}

		Arrays.sort(person, new Comparator<String[]>() {
			public int compare(String[] p1, String[] p2) {
				return Integer.compare(Integer.parseInt(p1[0]), Integer.parseInt(p2[0]));
			}
		});

		for (int i = 0; i < person.length; i++) {
			System.out.println(person[i][0] + " " + person[i][1]);
		}

	}

}
