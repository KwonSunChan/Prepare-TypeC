import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_line2019_1_2 {
	public static void main(String[] args) throws IOException {
		
		long N;
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String str= br.readLine();
		N= Long.parseLong(str);
		
		for(int NN=0;NN<N;++NN) {
			str= br.readLine();
			
			String[] names = new String[100];
			int namesIdx=0;
			
			String[] cnts = new String[100];
			int cntsIdx=0;
			
			
			for(int i=0;i<str.length();++i) {
				char c= str.charAt(i);
				if('A'<=c && c<='Z') {
					if(names[namesIdx]==null) {
						names[namesIdx]="";
					}
					
					names[namesIdx++]+=c;
				}else if('a' <= c && c <= 'z') {
					if(namesIdx>0) {
						names[namesIdx-1]+=c;
					}else {
						break;
					}
				}else if(c =='0') {
					if(cntsIdx>0) {
						cnts[cntsIdx-1]+=c;
					}else {
						break;
					}
				}else {
					if(cnts[cntsIdx]==null) {
						cnts[cntsIdx]="";
					}
					cnts[cntsIdx++]+=c;
				}
			}
			
			
			if(namesIdx != cntsIdx) {
				System.out.println("error");
			}else {
				StringBuilder sb =new StringBuilder();
				for(int i=0;i<namesIdx;++i) {
					sb.append(names[i]);
					if(!cnts[i].equals("1")) {
						sb.append(cnts[i]);
					}
				}
				System.out.println(sb);
				
				
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
