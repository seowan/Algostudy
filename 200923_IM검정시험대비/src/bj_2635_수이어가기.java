import java.util.ArrayList;
import java.util.Scanner;

public class bj_2635_수이어가기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int num = sc.nextInt(); //첫 숫자입력
		int answer = 0; //정답 저장 변수
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = num/2; i <= num; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(num); //첫번째 숫자 저장
			temp.add(i); //두번째 숫자 저장
			int count = 2; //첫 카운트 지정
			
			while (true) {
				int nextnum = temp.get(count-2) - temp.get(count-1);
				if (nextnum<0) { //다음 숫자가 음수라면
					if (count>answer) { //그동안 센숫자갯수와 정답갯수를 비교하여
						answer=count; 
						result=temp;
					}
					break; //음수일때 종료
				}
				temp.add(nextnum); //음수가 아니라면 다음숫자를 배열에 저장
				count++; //카운트도 하나 올려준다
			}
		}
		System.out.println(answer);
		for (int i = 0; i < result.size(); i++) {
			if (i==(result.size()-1)) {
				System.out.print(result.get(i));
				continue;
			}
			System.out.print(result.get(i)+" ");
		}
		sc.close();
	}

}
