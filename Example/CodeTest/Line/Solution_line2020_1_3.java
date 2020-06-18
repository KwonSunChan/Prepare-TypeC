
public class Solution_line2020_1_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int solution(String road, int n) {
        int answer = -1;
        
        int[] TrueRoad = new int[150000];
        int[] FalseRoad = new int[150000];    
        int TRidx=0;
        int FRidx=0;
        
        int idx=0;
        boolean flag=true;
        if(road.charAt(0)=='0') {
        	flag=false;
        }
        
        for(int sum=0,tar=road.charAt(idx)-'0';idx<road.length();++idx) {
        	++sum;
        	char c =road.charAt(idx);
        	if(c!=('0'+tar)) {
        		if(tar ==0) {
        			FalseRoad[FRidx++]=sum;
        			tar=1;
        		}else {
        			TrueRoad[TRidx++]=sum;
        			tar=0;        			
        		}
        		sum=0;
        	}
        }
        
        
        
        
        
        
        
        
        
        return answer;
    }

}
