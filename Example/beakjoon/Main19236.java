package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main19236 {
	
	public static int [][] dist = {
			{0,0},
			{-1,0},
			{-1,-1},
			{0,-1},
			{1,-1},
			{1, 0},
			{1,1},
			{0,1},
			{-1,1},
	};
	
	public static FishB [] fishs;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		
		
		FishB[][] arr = new FishB[4][];
		fishs = new FishB[17];
		
		for ( int i = 0 ; i < 4 ; ++ i ) {
			str = br.readLine().split(" ");
			arr[i] = new FishB[4];
			
			for (int j = 0 ; j< 4 ; ++ j ) {
				FishB temp = new FishB(Integer.parseInt(str[j*2]),Integer.parseInt(str[j*2 +1]),true);
				temp.x = i;
				temp.y = j;
				fishs[temp.no] = temp;
				arr[i][j] = temp;
			}
		}
		int startNo = arr[0][0].no;
		fishs[arr[0][0].no] = null;
		arr[0][0] = new FishB(0,arr[0][0].dist,false);
		
		System.out.println(answer(arr,0,0) + startNo);
	}
	
	
	
	private static int answer(FishB[][] arr, int x0, int y0) {
		
		int max = 0;
		
		
		FishB[][] moved = move(arr);
		FishB[] tFishs = new FishB[17];
		for(int i=1; i< 17;++i) {
			if(fishs[i] != null ) {
				FishB temp = new FishB(fishs[i].no,fishs[i].dist,fishs[i].fish);
				temp.x = fishs[i].x;
				temp.y = fishs[i].y;
				tFishs[i] = temp;
			}else {
				tFishs[i] = null;
			}
		}
		
		for ( int i =0; i < 4; ++i) {
			int di = moved[x0][y0].dist;
			int dx = x0 + (dist[di][0] * (i+1));
			int dy = y0 + (dist[di][1] * (i+1));
			if(0<= dx && 0<= dy && dx < 4 && dy < 4) {
				if(moved[dx][dy]!=null) {
					FishB temp = moved[dx][dy];
					int oldDi = moved[x0][y0].dist;
					fishs[moved[dx][dy].no] = null;
					moved[dx][dy] = moved[x0][y0];
					moved[x0][y0] = null;
					moved[dx][dy].dist = temp.dist;
					int val = answer(moved,dx,dy) + temp.no;
					fishs[moved[dx][dy].no] = temp;
					moved[x0][y0] = moved[dx][dy];
					moved[dx][dy] = temp;
					moved[x0][y0].dist = oldDi;
					for( int j = 1; j< 17;++j) {
						if(tFishs[j] != null) {
							if(fishs[j] == null ) {
								fishs[j] = moved[tFishs[j].x][tFishs[j].y];
							} 
							fishs[j].no = tFishs[j].no;
							fishs[j].dist = tFishs[j].dist;
							fishs[j].fish = tFishs[j].fish;
							fishs[j].x = tFishs[j].x;
							fishs[j].y = tFishs[j].y;
						}
						
					}
					
					if(val > max) {
						max = val;
					}
				}
			}else {
				break;
			}
		}
		return max;
	}



	private static FishB[][] move(FishB[][] arr) {
		FishB[][] moved = new FishB[4][];
		
		for ( int i = 0 ; i < 4 ; ++ i ) {
			moved[i] = new FishB[4];			
			for (int j = 0 ; j< 4 ; ++ j ) {
				moved[i][j] = arr[i][j];
			}
		}
		
		for (int i = 1 ; i< fishs.length; ++i) {
			if ( fishs[i] != null) {
				for(int j = 0; j < 8; ++j) {
					int di = fishs[i].dist+j;
					if(di > 8) {
						di-=8;
					}
					int dx = fishs[i].x + dist[di][0];
					int dy = fishs[i].y + dist[di][1];
					
					if(0<= dx && 0<= dy && dx < 4 && dy < 4) {
						if(moved[dx][dy] != null ) {
							if(moved[dx][dy].fish) {
								FishB temp = moved[fishs[i].x][fishs[i].y];
								moved[fishs[i].x][fishs[i].y] = moved[dx][dy];
								moved[dx][dy] =temp;
								
								moved[fishs[i].x][fishs[i].y].x = fishs[i].x;
								moved[fishs[i].x][fishs[i].y].y = fishs[i].y;
								
								fishs[i].x = dx;
								fishs[i].y = dy;
								fishs[i].dist = di;
								break;
							}
						}else {
							moved[fishs[i].x][fishs[i].y] = null;
							moved[dx][dy] = fishs[i];
							fishs[i].x = dx;
							fishs[i].y = dy;
							fishs[i].dist = di;
							break;
						}
					}
				}
			}
		}
		return moved;
	}



	public static class FishB{
		int no;
		int dist;
		int x;
		int y;
		boolean fish;
		
		FishB(int n ,int d ,boolean isf ){
			no = n;
			dist = d;
			fish = isf;
		}
		
		public String toString() {
			return "(" +no+","+dist+")";
		}
		
	}
	
	
	
}


