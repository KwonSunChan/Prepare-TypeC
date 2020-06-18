import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution8931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		
		int testCase = Integer.parseInt(str[0]);
		
		
		long sum=0;
		int idx=0;
		int[] arr =new int[100000];
		int k=0;
		int item=0;
		for(int test=0;test<testCase;++test) {
			sum=0;
			idx=0;
			str = br.readLine().split(" ");
			k=Integer.parseInt(str[0]);
			
			for(int i=0;i<k;++i) {
				str = br.readLine().split(" ");
				item=Integer.parseInt(str[0]);
				if(item==0) {
					sum-=arr[--idx];
				}else {
					sum+=item;
					arr[idx++]=item;
				}
			}
			System.out.println("#"+(test+1)+" "+sum);
		}
		
		
		
		

	}

}
