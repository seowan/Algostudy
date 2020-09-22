import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2309_일곱난쟁이 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int person[] = new int[9]; //난쟁이 키 입력받을 배열
		int sum=0; //난쟁이 키 합을 저장할 배열
		
		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
			sum+=person[i];
		} //난쟁이 키입력 종료
		
		Arrays.sort(person);
		
		for (int i = 8; i >= 0 ; i--) {
			for (int j = i-1; j >= 0; j--) { //키가 큰순서로 난쟁이 두명을 뽑아서
				if (sum-person[i]-person[j]==100) { //합이 100이되면
					for (int z = 0; z < 9; z++) { //난쟁이 키 출력
						if (z!=i && z!=j) {
							System.out.println(person[z]);
						}
					}
					j=-1;
					i=-1;
				}
			}
		}
	}

}
