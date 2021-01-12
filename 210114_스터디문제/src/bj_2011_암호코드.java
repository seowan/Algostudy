import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_2011_암호코드 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String target = br.readLine();
		int answer[] = new int[target.length()+1];
		answer[0] = answer[1]=1;
		
		if (target.charAt(0)=='0') { //0이 입력되었을경우
			System.out.println(0);
		}else if (target.charAt(target.length()-1)=='0' && target.charAt(target.length()-2)!='1' && target.charAt(target.length()-2)!='2') {//10이나 20으로 끝나지않을떄
			System.out.println(0);
		}else {
		for (int i = 2; i <= target.length(); i++) {
			int point = i-1;
			if (target.charAt(point)>'0') { //한자리수
				answer[i] = answer[i-1];
			}
			int temp=(target.charAt(point-1)-'0') *10 +(target.charAt(point)-'0');
			if (temp>=10 && temp<=26) { //두자리수 파악
				answer[i] = (answer[i]+answer[i-2])%1000000;
			}
		}
		
		System.out.println(answer[target.length()]);
		}
	}

}
