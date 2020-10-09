import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class bj_11650_좌표정렬하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[][] arr = new int[num][2];
		for (int i = 0; i < num; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		} // 좌표입력받음

		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] p1, int[] p2) {
				if (p1[0] == p2[0]) {
					return Integer.compare(p1[1], p2[1]);
				}

				else
					return Integer.compare(p1[0], p2[0]);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + " " + arr[i][1]);
		}

	}

}
