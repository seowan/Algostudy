import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj_2605_�ټ���� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine()); //�л���
		ArrayList<Integer> person = new ArrayList<Integer>();//���� ������
		
		String temp[] = br.readLine().split(" "); //�л��̻����� �迭������
		for (int i = 1; i <= num; i++) {
			//�ǵ�(�迭ũ��)���� ���� ����ŭ �����οͼ� �ټ���
			person.add(person.size()-Integer.parseInt(temp[i-1]),i);
		}
		
		for (int i = 0; i < num; i++) {
			System.out.print(person.get(i)+" ");
		}
	}

}
