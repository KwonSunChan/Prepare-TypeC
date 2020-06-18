package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main19237 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int N, M, K = M = N = 0;
		int item = 0;
		
		int[][] dist = {
				{0,0},
				{-1,0},
				{1,0},
				{0,-1},
				{0,1},
		};
		
		int[][][] pri;
		
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		K = Integer.parseInt(str[2]);
		
		
		
		Node19237[][] arr = new Node19237[N][];
		Sharck19237[] sharks = new Sharck19237[M + 1];
		Sharck19237[][] SharkArr = new Sharck19237[N][];
		
		for(int i = 0 ; i < N ; ++i ) {
			arr[i] = new Node19237[N];
			SharkArr[i] = new Sharck19237[N];
			str = br.readLine().split(" ");
			for( int j = 0 ; j < N ; ++ j  ) {
				item = Integer.parseInt(str[j]);
				if(item == 0 ) {
					SharkArr[i][j] = null;
					arr[i][j] = new Node19237(0,0);
				}else {
					arr[i][j] = new Node19237(item , K);
					sharks[item] = new Sharck19237(item,i,j);
					SharkArr[i][j] = sharks[item];
				}
			}
		}
		
		str = br.readLine().split(" ");
		for( int i = 0 ; i < M ; ++ i ) {
			sharks[i + 1].dist  = Integer.parseInt(str[i]);
		}
		
		
		pri = new int[M+1][5][4];
		
		for ( int i = 0 ; i < M ; ++ i ) {			
			for ( int j = 0 ; j < 4 ; ++ j ) {
				str = br.readLine().split(" ");
				for ( int k = 0 ; k < 4 ; ++ k ) {
					pri[i+1][j+1][k] = Integer.parseInt(str[k]);
				}
			}
		}
		
		int time = 0;
		int cnt = M;
		
		for(;cnt > 1;) {
			++time;
			if( time > 1000 ) {
				time = -1;
				break;
			}
			
			// move 
			{
				for(int i = 1 ; i < M + 1; ++ i) {
					if( sharks[i] != null ) {
						int mySmell = 0;
						int noSmell = 0;
						int dx=0,dy=0;
						for(int j = 0; j < 4 ; ++j ) {
							int d = pri[i][sharks[i].dist][j];
							dx = dist[d][0] + sharks[i].x;
							dy = dist[d][1] + sharks[i].y;
							
							if(0<= dx && 0<= dy && dx < N && dy < N) {
								if( arr[dx][dy].No == i && mySmell == 0  && time <= arr[dx][dy].time) {
									mySmell = d;
								}
								if( arr[dx][dy].time < time ) {
									noSmell = d;
									break;
								}
							}
						}
						
						if(noSmell != 0 ) {
							dx = dist[noSmell][0] + sharks[i].x;
							dy = dist[noSmell][1] + sharks[i].y;
						}else if(noSmell ==0 && mySmell != 0 ) {
							dx = dist[mySmell][0] + sharks[i].x;
							dy = dist[mySmell][1] + sharks[i].y;
							noSmell = mySmell;
						}
						
						if(noSmell !=0 || mySmell != 0 ) {
							SharkArr[sharks[i].x][sharks[i].y] = null;
							if(SharkArr[dx][dy] == null) {
								SharkArr[dx][dy] = sharks[i];
								sharks[i].dist = noSmell;
								sharks[i].x = dx;
								sharks[i].y = dy;
							} else {
								sharks[i] = null;
								--cnt;
							}
						}
					}
				}
			}
			
			// 냄새 남기기
			{
				for(int i = 1 ; i < M + 1; ++ i) {
					if( sharks[i] != null ) {
						arr[sharks[i].x][sharks[i].y].No = sharks[i].No;
						arr[sharks[i].x][sharks[i].y].time = time + K;
					}
				}
			}
			
//			if( time < 10 ) {
//				
//				for(int i = 0; i < N ; i ++ ) {
//					
//					for(int j=0;j < N; j ++) {
//						System.out.print(arr[i][j].time + "\t");
//					}
//					System.out.println();
//				}
//				System.out.println();
//				
//			}
			
			
		}
		
		System.out.println(time);
	}
	
	
	
	
	
	public static class Node19237 {
		int time ;
		int No;
		
		Node19237(){
			No = time = 0;
		}
		
		Node19237(int n,int t){
			No = n;
			time = t;
		}
	};
	
	public static class Sharck19237 {
		int No;
		int dist;
		int x;
		int y;
		Sharck19237(int n,int x,int y){
			No = n;
			this.x = x;
			this.y = y;
		}
	}
}


