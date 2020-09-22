import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_2309_¿œ∞ˆ≥≠¿Ô¿Ã {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int person[] = new int[9];
		int sum=0;
		
		for (int i = 0; i < 9; i++) {
			person[i] = Integer.parseInt(br.readLine());
			sum+=person[i];
		}
		
		Arrays.sort(person);
		
		for (int i = 8; i >= 0 ; i--) {
			for (int j = i-1; j >= 0; j--) {
				if (sum-person[i]-person[j]==100) {
					for (int z = 0; z < 9; z++) {
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
