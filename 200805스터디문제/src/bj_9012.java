import java.util.Scanner;
import java.util.Stack;

public class bj_9012 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int count = Integer.parseInt(sc.next());
		
		for (int i = 0; i < count; i++) {
			String input= sc.next();
			Stack<Integer> stack = new Stack<Integer>();
			String result = "YES";
			for (int j = 0; j < input.length(); j++) {
				char temp=input.charAt(j);
				if (temp=='(') {
					stack.push(1);
				}
				else if (temp==')') {
					if (stack.isEmpty()) {
						result = "NO";
						break;
					}
					else stack.pop();
				}
			}

			if (!stack.isEmpty()) {
				result = "NO";
			}
			System.out.println(result);
		}
	}
}
