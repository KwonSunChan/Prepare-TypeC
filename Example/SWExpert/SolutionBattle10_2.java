import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SolutionBattle10_2 {

	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      String[] str = br.readLine().split(" ");
	      
	      int testCase=Integer.parseInt(str[0]);
	      
	      long A;
	      long M;
	      StringBuilder sb =new StringBuilder();
	      for(int test=0;test<testCase;++test) {
	    	  str = br.readLine().split(" ");
	    	  A=Long.parseLong(str[0]);
	    	  A*=2;
	    	  
	    	  M=(long)Math.sqrt(A);
	    	  if(M*M + M ==A) {
	    		  sb.append("#"+(test+1)+" "+M+"\n");
	    	  }else {
	    		  sb.append("#"+(test+1)+" -1\n");
	    	  }
	      }
	      System.out.print(sb);
	      
		
	}

}
