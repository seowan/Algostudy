import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_9935_문자열폭발 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		String target = br.readLine();
		
		char answer[] = new char[1000001];
		int index=0;
		
		boolean check=false;
		
		for (int i = 0; i < input.length(); i++) {
			answer[index++] = input.charAt(i);
			
			if (answer[index-1]==target.charAt(target.length()-1)) {
				int point = index-2;
				
				for (int j = target.length()-2; j >= 0; j--) {
					if (answer[point--]==target.charAt(j)) {
						check = true;
					}else {
						check=false;
						break;
					}
				}
				
				if (check) {
					index = index-target.length();
				}
			}
		}
		
		if (index==0) {
			System.out.println("FRULA");
		}else {
			for (int i = 0; i < index; i++) {
				System.out.print(answer[i]);
			}
		}
	}

}
