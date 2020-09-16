import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class bj_2751_수정렬하기2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		for (int i = 0; i < count; i++) {
			num.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(num);
		
		for (int i = 0; i < count; i++) {
			System.out.println(num.get(i));
		}
	}
}