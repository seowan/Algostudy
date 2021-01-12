import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_9935_문자열폭발3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();//처음입력한 문자열
		String target = br.readLine();//폭발문자열
		
		char[] result = new char[input.length()];
		int index=0;
		
		for (int i = 0; i < input.length(); i++) {
			result[index] = input.charAt(i);//결과 배열에 문자삽입
			boolean flag = true;
			if (index<target.length()-1) {
				flag = false;
			}else {
				for (int j = 0; j < target.length(); j++) {
					if (target.charAt(j)!=result[index-target.length()+1+j]) {
						flag = false;
						break;
					}
				}
			}
			
			if (flag) {
				index-=target.length();
			}
			index++;
		}
		
		String answer = String.valueOf(result,0,index);
		
		if (answer.length()==0) {
			System.out.println("FRULA");
		}else {
			System.out.println(answer);
		}
	}

}
