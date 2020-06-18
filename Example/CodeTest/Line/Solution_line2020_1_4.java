import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Solution_line2020_1_4 {

	public static void main(String[] args) {
		 String[][] aa = {
	        		{"ACCOUNT1", "100"}, 
	        		{"ACCOUNT2", "150"}
	        };
		 
		 
		 String[][] bb = {
				 {"1", "SAVE", "ACCOUNT2", "100"},
                 {"2", "WITHDRAW", "ACCOUNT1", "50"}, 
                 {"1", "SAVE", "ACCOUNT2", "100"}, 
                 {"4", "SAVE", "ACCOUNT3", "500"}, 
                 {"3", "WITHDRAW", "ACCOUNT2", "30"}
		 };
		 String[][] ret = solution(aa,bb);
		 for(int i=0; i<ret.length;i++) {
			 for(int j=0;j<ret[i].length;j++) {
				 System.out.print(ret[i][j]+" ");
			 }
			 System.out.println();
		 }
		 

	}
	
	
	public static String[][] solution(String[][] snapshots, String[][] transactions) {
        String[][] answer = {};
        
       
    
        
        

        
        
        HashMap<String,Integer> hm =new HashMap<>();
        
        boolean[] flags=new boolean[transactions.length+1];
        
        
        for(int i=0;i<snapshots.length;++i) {
        	hm.put(snapshots[i][0], Integer.parseInt(snapshots[i][1]));
        }
        
        for(int i=0;i<transactions.length;++i) {
        	int fidx = Integer.parseInt(transactions[i][0]);
        	if(!flags[fidx]) {
        		if(hm.containsKey(transactions[i][2])) {
        			int mul = 1;
        			if(transactions[i][1].equals("WITHDRAW")) {
        				mul=-1;
        			}
        			int val = hm.get(transactions[i][2]);
        			int pl = (Integer.parseInt(transactions[i][3])*mul);
        			
        			
        			hm.put(transactions[i][2],  val+pl );
        			
        			
        		}else {
        			int mul = 1;
        			if(transactions[i][1].equals("WITHDRAW")) {
        				mul=-1;
        			}
        			
        			hm.put(transactions[i][2], Integer.parseInt(transactions[i][3])*mul );
        		}
        		
        		
        		
        		
        		flags[fidx]=true;
        	}
        }
        TreeMap<String,Integer> tm = new TreeMap<>(hm);
        Iterator<String> its = tm.keySet().iterator();
        
        
        answer= new String[tm.size()][2];
        int idx=0;
        while(its.hasNext()) {
        	String key = its.next();
        	answer[idx][0]=key;
        	answer[idx++][1]=tm.get(key)+"";
        	
        }
        
        
        
        
        
        
        
        return answer;
    }

}
