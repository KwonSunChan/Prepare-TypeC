import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10032 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int TestCase = Integer.parseInt(str[0]);
		int N,K = N = 0;
		int ans = 0;
		
		StringBuilder sb = new StringBuilder();
		for(int test = 0; test < TestCase ; ++test) {
			str = br.readLine().split(" ");
			N = Integer.parseInt(str[0]);
			K = Integer.parseInt(str[1]);
			ans = 0;
			if(N%K != 0) {
				ans = 1;
			}
			sb.append("#"+(test+1)+" "+ans+"\n");
		}
		System.out.print(sb);
	}

}
