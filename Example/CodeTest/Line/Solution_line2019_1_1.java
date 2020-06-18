import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_line2019_1_1 {
	public static void main(String[] args) throws IOException {
		
		long N;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String str= br.readLine();
		N= Long.parseLong(str);
		
		
		int target=0;
		for(int i=1;i<=3162277;++i) {
			if(i*i<=N) {
				target=i;
			}else {
				break;
			}
		}
		
		for(int i=target;i>=1;--i) {
			if(N%i==0) {
				System.out.println(i +" - "+(N/i));
				System.out.println(Math.abs(i-(N/i)));
				break;
			}
		}
		
		
		
		
		
		
		
	}

}
