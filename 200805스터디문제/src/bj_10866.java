import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class bj_10866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<Integer> deque = new LinkedList<>();
		int cnt = sc.nextInt();
		
		for (int i = 0; i < cnt; i++) {
			String input = sc.next();
			if (input.equals("push_back")) {
				int b = sc.nextInt();
				deque.addLast(b);
			}
			else if (input.equals("push_front")) {
				int b = sc.nextInt();
				deque.addFirst(b);
			}
			else if (input.equals("pop_front")) {
				System.out.println(deque.isEmpty()?-1:deque.pop());
			}
			else if (input.equals("pop_back")) {
				System.out.println(deque.isEmpty()?-1:deque.removeLast());
			}
			else if (input.equals("size")) {
				System.out.println(deque.size());
			}
			else if (input.equals("empty")) {
				System.out.println(deque.isEmpty()?1:0);
			}
			else if (input.equals("front")) {
				System.out.println(deque.isEmpty()?-1:deque.peek());
			}
			else if (input.equals("back")) {
				System.out.println(deque.isEmpty()?-1:deque.peekLast());
			}
		}
	}
}