import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_line2019_1_3 {
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		
		String[][] tableHeader =new String[2][];
		String[][][] tableData = new String[2][][];
		for(int tableNo=0;tableNo<2;++tableNo) {
			str= br.readLine();
			int N;
			N= Integer.parseInt(str);
			
			str= br.readLine();
			tableHeader[tableNo]=str.split(" ");
			
			tableData[tableNo]=new String[N-1][];
			
			for(int i=1;i<N;++i) {
				str= br.readLine();
				tableData[tableNo][i-1]=str.split(" ");
			}
			
			Quick(tableData[tableNo],0,N-2);
		}
		
		int t1=0;
		int t2=0;
		
		for(int i=0;i<tableData[0].length;) {
			
			if(t2<tableData[1].length) {
				int t11 = Integer.parseInt(tableData[0][i][0]);
				int t22 = Integer.parseInt(tableData[1][t2][0]);
				
								
				if(t11 ==t22) {
					for(int j=0;j<tableData[0][i].length;j++) {
						System.out.print(tableData[0][i][j]+" ");
					}
					for(int j=1;j<tableData[1][t2].length;j++) {
						System.out.print(tableData[1][t2][j]+" ");
					}
					System.out.println();
					t2++;
					i++;
				}else if(t11>t22) {
					
					
					t22++;
				}else {
					for(int j=0;j<tableData[0][i].length;j++) {
						System.out.print(tableData[0][i][j]+" ");
					}
					for(int j=1;j<tableData[1][0].length;j++) {
						System.out.print("NULL"+" ");
					}
					System.out.println();
					i++;
				}
			}else {
				for(int j=0;j<tableData[0][i].length;j++) {
					System.out.print(tableData[0][i][j]+" ");
				}
				for(int j=1;j<tableData[1][0].length;j++) {
					System.out.print("NULL"+" ");
				}
				System.out.println();
			}
		}
		

		
		
	}

	private static void Quick(String[][] str, int low, int high) {
		
		if(low >= high) {
			return;
		}
		
		int i,pivot = i = low;
		int j=high;
		
		while(i<j) {
			for(;;--j) {
				int J = Integer.parseInt(str[j][0]);
				int P = Integer.parseInt(str[pivot][0]);
				
				if(J<=P) {
					break;
				}
				
			}
			for(;i<j;++i) {
				int I = Integer.parseInt(str[i][0]);
				int P = Integer.parseInt(str[pivot][0]);
				
				if(I>P) {
					break;
				}
			}
			
			
			swap(str,i,j);
		}
		
		
		swap(str,i,pivot);
		Quick(str,low,i-1);
		Quick(str,i+1,high);
		
	}

	private static void swap(String[][] str, int i, int j) {
		String[] temp =str[i];
		str[i]=str[j];
		str[j]= temp;
	}

}
