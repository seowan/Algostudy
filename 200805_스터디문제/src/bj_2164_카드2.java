import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_2164_카드2 {

	public static Queue<Integer> queue = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for (int i = 1; i <= num; i++) {
			queue.add(i);
		}//ī ֱ
		
		for (int i = 1; i <= num; i++) {
			if (queue.size()==1) {
				System.out.println(queue.poll());
				break;
			}
			else {
				queue.poll();
				queue.add(queue.poll());
			}
		}
	}
}
