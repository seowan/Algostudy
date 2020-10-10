import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_12100_2048 {
//20.10.09 오후 7:40부터 풀이  3시간 20분제출
/*완전 dfs방식이 아닌 dfs방식과 시뮬레이션을 적절히 섞어서 구현해야했당
 * 맵을 상하좌우로 이동한후 그이동한 맵을 또 상하좌우로 해야하므로 dfs
 * 맵을 움직일때는 상하좌우 방향에 따라서 인덱스가 다르므로 시뮬레이션방식이었당
 * 처음에는 쉬워보였지만.....생각보다 상하좌우 움직이고 공백을 처리하는 것을 생각못해서 시간이 너무오래걸렸다
 * 시간을 단축하기위해서는 일단 먼저 직관적으로 구현을 하는 습관을 들여야겠당*/
	static int N,answer,map[][]; //N : 지도크기 , answer : 정답 , map[][] : 맵

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} //입력끝
		
		dfs(map,0); //dfs식으로 해서 상하좌우별 지도를 가지고 또 상하좌우 연산을 한다. => 5번까지
		System.out.println(answer); //정답출력
		
	}

	private static void dfs(int map[][],int count) {
		if (count==5) {
			//최대크기 비교
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					answer = Math.max(answer, map[i][j]);
				}
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			dfs(slide(map, i),count + 1); //맨처음 상하좌우 호출
		}
		
	}

	private static int[][] slide(int[][] map, int dir) { //밀기
		int[][] tempmap = map; //넘겨받은 맵정보를 임시변수에 저장하여 임시변수를 계속 변화시켜준다
        switch (dir) { //상하좌우에따라서 인덱스가 바뀌므로 for문말고 switch-case문으로 한다
            case 0: //상
                for (int i = 0; i < N - 1; i++) {
                    for (int j = 0; j < N; j++) {
                        int next = i + 1;
                        if (tempmap[i][j] == tempmap[next][j]) {
                            tempmap[i][j] += tempmap[next][j];
                            tempmap[next][j] = 0;
                        }
                    }
                }
                //0인블록이 있을수있으므로 밀어준다
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tempmap[i][j] == 0) {
                            int next = i + 1;
                            while (next < tempmap.length) {
                                if (tempmap[next][j] != 0) {
                                	tempmap[i][j] = tempmap[next][j];
                                	tempmap[next][j] = 0;
                                    break;
                                }
                                next++;
                            }
                        }
                    }
                }
                break;
            case 1: //하
                for (int i = N - 1; i >= 1; i--) {
                    for (int j = 0; j < N; j++) {
                        int next = i - 1;
                        if (tempmap[i][j] == tempmap[next][j]) {
                            tempmap[i][j] += tempmap[next][j];
                            tempmap[next][j] = 0;
                        }
                    }
                }
              //0인블록이 있을수있으므로 밀어준다
                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {
                        if (tempmap[i][j] == 0) {
                            int next = i - 1;
                            while (next >= 0) {
                                if (tempmap[next][j] != 0) {
                                	tempmap[i][j] = tempmap[next][j];
                                	tempmap[next][j] = 0;
                                    break;
                                }
                                next--;
                            }
                        }
                    }
                }
                break;
            case 2: //좌
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N - 1; j++) {
                        int next = j + 1;
                        if (tempmap[i][next] == tempmap[i][j]) {
                            tempmap[i][j] += tempmap[i][next];
                            tempmap[i][next] = 0;
                        }
                    }
                }
              //0인블록이 있을수있으므로 밀어준다
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (tempmap[i][j] == 0) {
                            int next = j + 1;
                            while (next < N) {
                                if (tempmap[i][next] != 0) {
                                	tempmap[i][j] = tempmap[i][next];
                                	tempmap[i][next] = 0;
                                    break;
                                }
                                next++;
                            }
                        }
                    }
                }
                break;
            case 3: //우
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        int next = j - 1;
                        if (tempmap[i][next] == tempmap[i][j]) {
                            tempmap[i][j] += tempmap[i][next];
                            tempmap[i][next] = 0;
                        }
                    }
                }
              //0인블록이 있을수있으므로 밀어준다
                for (int i = 0; i < N; i++) {
                    for (int j = N - 1; j > 0; j--) {
                        if (tempmap[i][j] == 0) {
                            int next = j - 1;
                            while (next >= 0) {
                                if (tempmap[i][next] != 0) {
                                	tempmap[i][j] = tempmap[i][next];
                                	tempmap[i][next] = 0;
                                    break;
                                }
                                next--;
                            }
                        }
                    }
                }
                break;
        }
        return tempmap;
	}

}