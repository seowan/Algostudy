import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_2477_참외밭 {

	//큰 사각형에서 빈부분을 빼는방식
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int num = Integer.parseInt(br.readLine());
		int dir[] = new int[6];
		int length[] = new int[6];
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			dir[i] = Integer.parseInt(st.nextToken());
			length[i] = Integer.parseInt(st.nextToken());
		} //6각 정보입력 끝
		
		int area=0,point=0;
		for (int i = 0; i < 6; i++) {
			if (area<length[i]*length[(i+1)%6]) {
				area=length[i]*length[(i+1)%6]; //제일큰 사각형넓이
				point=i; //제일큰 사각형의 기준점을 저장
			}
		}
		
		int subarea=0;
		//빈 사각형의 좌표는 항상 제일큰 사각형의 포인트의 +3,+4번째에나온다
		//참외밭은 항상 6각형이기 때문에)
		subarea=length[(point+3)%6]*length[(point+4)%6];
		//참외가 자랄수있는 최종 밭의 크기계산
		area = area-subarea;
		
		System.out.println(area*num);		
	}
}
