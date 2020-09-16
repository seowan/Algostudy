import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bj_10845 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> queue = new LinkedList<>();
		int b=0;
		int cnt = sc.nextInt();
		
		for (int i = 0; i < cnt; i++) {
			String input = sc.next();
			if (input.equals("push")) {
				b = sc.nextInt();
				queue.add(b);
			}
			else if (input.equals("front")) {
				System.out.println(queue.isEmpty()?-1:queue.peek());
			}
			else if (input.equals("back")) {
				System.out.println(queue.isEmpty()?-1:b);
			}
			else if (input.equals("size")) {
				System.out.println(queue.size());
			}
			else if (input.equals("pop")) {
				System.out.println(queue.isEmpty()?-1:queue.poll());
			}
			else if (input.equals("empty")) {
				System.out.println(queue.isEmpty()?1:0);
			}
		}
	}
}