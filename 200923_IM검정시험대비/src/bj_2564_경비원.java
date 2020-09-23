import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2564_경비원 {
	static class sp{
		public int x,y,dir;

		public sp(int x, int y,int dir) {
			super();
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken()); //가로길이
		int R = Integer.parseInt(st.nextToken()); //세로길이
		int store = Integer.parseInt(br.readLine()); //상점갯수
		ArrayList<sp> arr = new ArrayList<sp>();
		
		for (int i = 0; i <= store; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); //방향
			int point = Integer.parseInt(st.nextToken()); //거리
			switch (dir) {//방향에따라 좌표를 계산하여 배열에 저장
			case 1:
				arr.add(new sp(0, point,dir));
				break;
			case 2:
				arr.add(new sp(R, point,dir));
				break;
			case 3:
				arr.add(new sp(point, 0,dir));
				break;
			case 4:
				arr.add(new sp(point, C,dir));
				break;
			}
		}//상점 & 동근위치 입력 끝
		
		int answer=0; //총 거리
		int xx = arr.get(store).x;
		int yy = arr.get(store).y;
		int dir = arr.get(store).dir;
		int dista,distb; //비교할 두 거리 저장
		for (int i = 0; i < store; i++) {
			if ((dir==1&&arr.get(i).dir==2) ||  //남쪽과 북쪽
					(dir==2&&arr.get(i).dir==1)) {
				dista = arr.get(i).y+yy+R;
				distb = C-arr.get(i).y+C-yy+R;
				answer+=Math.min(dista, distb);
				
			}else if ((dir==3&&arr.get(i).dir==4) || 
					(dir==4&&arr.get(i).dir==3)) {
				dista = arr.get(i).x+xx+C;
				distb = R-arr.get(i).x+R-xx+C;
				answer+=Math.min(dista, distb);
			}else { //서로 마주보는 방향이 아닐경우
				answer+=Math.abs(xx-arr.get(i).x) + Math.abs(yy-arr.get(i).y);
			}
		}
		
		System.out.println(answer);
		
	}

}
