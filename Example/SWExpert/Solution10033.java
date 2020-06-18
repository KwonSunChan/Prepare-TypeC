import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution10033 {

	public static char[] bws = {};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int TestCase = Integer.parseInt(str[0]);
		long sum = 0;
		int start = -1;
		StringBuilder sb = new StringBuilder();
		
		for ( int test = 0 ; test < TestCase ; ++test) {
			str = br.readLine().split(" ");
			sum = 0;
			start = -1;
			bws = str[0].toCharArray();
			for ( int i = 0 ; i < bws.length; ++ i ) {
				if(bws[i] == 'W') {
					sum+=i-++start;
				}
			}
			sb.append("#"+(test+1) + " " + sum +"\n");
		}
		System.out.print(sb);

	}
	

}
