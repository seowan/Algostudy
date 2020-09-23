import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj_2564_���� {
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
		
		int C = Integer.parseInt(st.nextToken()); //���α���
		int R = Integer.parseInt(st.nextToken()); //���α���
		int store = Integer.parseInt(br.readLine()); //��������
		ArrayList<sp> arr = new ArrayList<sp>();
		
		for (int i = 0; i <= store; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken()); //����
			int point = Integer.parseInt(st.nextToken()); //�Ÿ�
			switch (dir) {//���⿡���� ��ǥ�� ����Ͽ� �迭�� ����
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
		}//���� & ������ġ �Է� ��
		
		int answer=0; //�� �Ÿ�
		int xx = arr.get(store).x;
		int yy = arr.get(store).y;
		int dir = arr.get(store).dir;
		int dista,distb; //���� �� �Ÿ� ����
		for (int i = 0; i < store; i++) {
			if ((dir==1&&arr.get(i).dir==2) ||  //���ʰ� ����
					(dir==2&&arr.get(i).dir==1)) {
				dista = arr.get(i).y+yy+R;
				distb = C-arr.get(i).y+C-yy+R;
				answer+=Math.min(dista, distb);
				
			}else if ((dir==3&&arr.get(i).dir==4) || 
					(dir==4&&arr.get(i).dir==3)) {
				dista = arr.get(i).x+xx+C;
				distb = R-arr.get(i).x+R-xx+C;
				answer+=Math.min(dista, distb);
			}else { //���� ���ֺ��� ������ �ƴҰ��
				answer+=Math.abs(xx-arr.get(i).x) + Math.abs(yy-arr.get(i).y);
			}
		}
		
		System.out.println(answer);
		
	}

}
