import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution9940 {
	
	
	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String[] str = br.readLine().split(" ");
	      int testCase =Integer.parseInt(str[0]);
	      
	      int N;
	      boolean[] CNT;
	      int cnt;
	      
	      StringBuilder sb = new StringBuilder();
	      for(int test=0;test<testCase;++test) {
	    	  str = br.readLine().split(" ");
	    	  N=Integer.parseInt(str[0]);
	    	  CNT = new boolean[N+1];
	    	  cnt =0;
	    	  
	    	  str = br.readLine().split(" ");
	    	  for(int i=0;i<N;++i) {
	    		  int idx = Integer.parseInt(str[i]);
	    		  if(0<idx && idx <=N && !CNT[idx]) {
	    			  CNT[idx]=true;
	    			  cnt++;
	    		  }
	    	  }
	    	  if(cnt==N) {
	    		  sb.append("#"+(test + 1)+" Yes\n");
	    	  }else {
	    		  sb.append("#"+(test + 1)+" No\n");
	    	  }
	      }
	      System.out.print(sb);	      
	   }
	
	

}

