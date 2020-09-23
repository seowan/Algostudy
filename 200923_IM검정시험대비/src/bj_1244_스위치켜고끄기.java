import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1244_스위치켜고끄기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int swinum = Integer.parseInt(br.readLine()); //전체스위치 갯수
		int num[] = new int[swinum+1]; //스위치 상태를 저장하기위한 배열
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= swinum; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		} //스위치 상태 입력 종료
		
		int person = Integer.parseInt(br.readLine()); //학생수 입력 받음
		for (int i = 0; i < person; i++) { //학생별로 스위치 켜고끄기 실행
			st = new StringTokenizer(br.readLine());
			int kind = Integer.parseInt(st.nextToken()); //남,여 구분
			int given = Integer.parseInt(st.nextToken()); //스위치번호
			int index; 			
			switch (kind) { //남학생,여학생에 따라 다르게 스위치조작
			case 1: //남학생일 경우
				index=1;
				while (true) {
					if (index*given<=swinum) { //부여받은 번호의배수가 스위치안에있으면
						if (num[index*given]==0) { 
							num[index*given]=1;
						}else num[index*given]=0;
					index++; //스위치를 조작하고 인덱스 1증가
					}else break; //스위치범위 밖이면 종료
				}
				break; //해당 학생의 스위치 조작 종료

			case 2: //여학생일 경우
				index=1;
				if (num[given]==0) { //일단 부여받은 번호의 스위치를 조작
					num[given]=1;
				}else num[given]=0;
				
				while (true) {
					if ((given-index)>0 && (given+index)<=swinum && //주변 스위치가 범위안에있고
							num[given-index]==num[given+index]) { //스위치상태가 같다면
						if (num[given-index]==0) {
							num[given-index]=num[given+index]=1;
						}else num[given-index]=num[given+index]=0;
					index++; //스위치조작후 인덱스 증가
					}else break; //그렇지않으면 종료
				}
				break; //해당 학생의 스위치 조작 종료
			}
		}
		
		for (int i = 1; i <= swinum; i++) {
			sb.append(num[i]+" ");
			if (i%20==0) {
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
