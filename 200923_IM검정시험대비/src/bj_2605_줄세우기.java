import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_2605_줄세우기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine()); //학생수
		ArrayList<Integer> person = new ArrayList<Integer>();//최종 줄저장
		
		String temp[] = br.readLine().split(" "); //학생이뽑은수 배열에저장
		for (int i = 1; i <= num; i++) {
			//맨뒤(배열크기)에서 뽑은 수만큼 앞으로와서 줄서기
			person.add(person.size()-Integer.parseInt(temp[i-1]),i);
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print(person.get(i)+" ");
		}
	}

}
