import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution9780 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		
		int testCase = Integer.parseInt(str[0]);
		int N;
		int item;
		StringBuilder sb =new StringBuilder();
		long answer=0;
		long a,b;
		for(int test=0;test<testCase;++test) {
			str = br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
		
			str=br.readLine().split(" ");
			a=b=0;
			for(int i=0,j=0;i<N;++i) {
				
				item=Integer.parseInt(str[i]);
				
				if(i%2==0) {
					if(b<a+item) {
						a+=item;
					}else {
						a=b;
					}
					answer=a;
				}else {
					if(a<b+item) {
						b+=item;
					}else {
						b=a;
					}
					answer=b;
				}
			}
			if(a>b) {
				answer=a;
			}
			else {
				answer=b;
			}

			sb.append("#"+(test+1)+" "+answer+"\n");
			
		}
		System.out.print(sb);
	}

}
