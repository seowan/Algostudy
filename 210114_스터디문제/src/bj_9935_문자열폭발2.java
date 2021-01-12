import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_9935_문자열폭발2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		String target = br.readLine();
		
		String answer = algo(input,target);
		
		System.out.println((answer.length()==0)?"FRULA": answer);
	}

	private static String algo(String input, String target) {
		char[] result = new char[input.length()];
		int index=0;
		
		for (int i = 0; i < input.length(); i++) {
			result[index] = input.charAt(i);
			if (check(result,index,target)) {
				index-=target.length();
			}
			index++;
		}
		return String.valueOf(result,0,index);
	}

	private static boolean check(char[] result, int index, String target) {
		if (index<target.length()-1) {
			return false;
		}
		
		for (int i = 0; i < target.length(); i++) {
			if (target.charAt(i)!=result[index-target.length()+1+i]) {
				return false;
			}
		}
		return true;
	}
}
