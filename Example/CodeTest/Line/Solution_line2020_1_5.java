import java.util.*;


public class Solution_line2020_1_5 {

	public static void main(String[] args) {
		 

	}
	
	public String[] solution(String[][] dataSource, String[] tags) {
        String[] answer = {};
        HashMap<String,String> hmv =new HashMap<>();
        HashMap<String,HashMap<String,String>> hm =new HashMap<>();
        
        for(int i=0;i<dataSource.length;++i) {
        	hmv =new HashMap<>();
        	for(int j=1;j<dataSource[i].length;++j) {
        		hmv.put(dataSource[i][j], "");
        	}
        	hm.put(dataSource[i][0], hmv);
        }
        
        int[] cnt =new int[dataSource.length];
        String[] keys =new String[dataSource.length];
        
        TreeMap<String,HashMap<String,String>> tm = new TreeMap<>(hm);
        Iterator<String> its = tm.keySet().iterator();
        int idx=0;
        int sum=0;
        while(its.hasNext()) {
        	String key = its.next();
        	hmv = tm.get(key);
        	keys[idx]=key;
        	boolean isEmpty=true;
        	for(int i=0;i<tags.length;++i) {
        		if(hmv.containsKey(tags[i])) {
        			++cnt[idx];
        			isEmpty=false;
        		}
        	}
        	if(!isEmpty) {
        		sum++;
        	}
        	
        	++idx;
        }
        
        int size = Integer.min(10, sum);
        
        answer=new String[size];
        idx=0;
        
        for(int i=tags.length;i>=1 && idx<size;--i) {
        	for(int j=0;j<cnt.length && idx<size;++j) {
        		if(cnt[j]==i) {
        			answer[idx++]=keys[j];
        		}
        	}
        	
        }

        
        return answer;
    }
	

}
