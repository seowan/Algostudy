import java.util.ArrayList;
import java.util.Scanner;

public class bj_2635_���̾�� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		int num = sc.nextInt(); //ù �����Է�
		int answer = 0; //���� ���� ����
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (int i = num/2; i <= num; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(num); //ù��° ���� ����
			temp.add(i); //�ι�° ���� ����
			int count = 2; //ù ī��Ʈ ����
			
			while (true) {
				int nextnum = temp.get(count-2) - temp.get(count-1);
				if (nextnum<0) { //���� ���ڰ� �������
					if (count>answer) { //�׵��� �����ڰ����� ���䰹���� ���Ͽ�
						answer=count; 
						result=temp;
					}
					break; //�����϶� ����
				}
				temp.add(nextnum); //������ �ƴ϶�� �������ڸ� �迭�� ����
				count++; //ī��Ʈ�� �ϳ� �÷��ش�
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
