import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SolutionBattle10_1 {

	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String[] str = br.readLine().split(" ");
	      
	      int[] ans = {
	    	1,2,3,4,5,6,7,8,9,
	    	12,23,34,45,56,67,78,89,
	    	123,234,345,456,567,678,789,
	    	1234,2345,3456,4567,5678,6789,
	    	12345,23456,34567,45678,56789,
	    	123456,234567,345678,456789,
	    	1234567,2345678,3456789,
	    	12345678,23456789,
	    	123456789,
	      };
	      
	      int testCase = Integer.parseInt(str[0]);
	      int[] arr;
	      int N;
	      boolean hasAns=false;
	      StringBuilder sb =new StringBuilder();
	      
	      for(int test=0;test<testCase;++test) {
	    	  str = br.readLine().split(" ");
	    	  N=Integer.parseInt(str[0]);
	    	  arr=new int[N];
	    	  hasAns=false;
	    	  
	    	  str = br.readLine().split(" ");
	    	  for(int i=0;i<N;++i) {
	    		  arr[i]=Integer.parseInt(str[i]);
	    	  }
	    	  
	    	  for(int i=ans.length-1;i>=0 &&!hasAns;--i) {
	    		  for(int j=0;j<N&&!hasAns;++j) {
	    			  if(ans[i]%arr[j]==0) {
	    				  for(int k=0;k<N;++k) {
	    					  if(j!=k && ans[i]/arr[j]==arr[k]) {
	    						  hasAns=true;
	    						  sb.append("#"+(test+1)+" "+ans[i]+"\n");
	    						  break;
	    					  }
	    				  }
	    				  
	    			  }
	    		  }
	    		  
	    	  }
	    	  
	    	  if(!hasAns) {
	    		  sb.append("#"+(test+1)+" -1\n");
	    	  }
	      }
	      System.out.print(sb);
	      
	      
		
	}

}
