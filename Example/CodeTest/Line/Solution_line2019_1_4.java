import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_line2019_1_4 {
	public static void main(String[] args) throws IOException {
		
		
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		String str;
		
		int N;
		
		str= br.readLine();
		N=Integer.parseInt(str);
		
		int[] arr =new int[N];
		for(int i=0;i<N;i++) {
			str= br.readLine();
			arr[i]=Integer.parseInt(str);
		}
		
		int max=0;
		
		Solution_line2019_1_4_stack stack =new Solution_line2019_1_4_stack();
		
		for(int i=N-1;i>=0;--i) {
			int top = stack.peek();
			
			while(top!=-1&&arr[top] <arr[i]) {
				stack.pop();
				top=stack.peek();
			}
			stack.push(i);
		}
		
		int old = stack.pop();
		
		while(old!=-1) {
			int nOld = stack.pop();
			if(nOld!=-1) {
				if(max<nOld-old) {
					max=nOld-old;
				}
			}
			old=nOld;
		}
		
		
		
		stack =new Solution_line2019_1_4_stack();
		
		for(int i=0;i<N;++i) {
			int top = stack.peek();
			
			while(top!=-1&&arr[top] <arr[i]) {
				stack.pop();
				top=stack.peek();
			}
			stack.push(i);
		}
		
		old = stack.pop();
		
		while(old!=-1) {
			int nOld = stack.pop();
			if(nOld!=-1) {
				if(max<nOld-old) {
					max=nOld-old;
				}
			}
			old=nOld;
		}

		System.out.println(max);

		
		
	}

	
	 public static class Solution_line2019_1_4_stack{
		int[] arr;
		int top;
		int len;
		
		Solution_line2019_1_4_stack(){
			len=1000005;
			arr=new int[len];
			top=0;
		}
		
		public void push(int i) {
			if(top<len) {
				arr[top++]=i;
			}
		}
		
		public int pop() {
			if(top>0) {
				return arr[--top];
			}
			return -1;
		}
		
		public int peek() {
			if(top>0) {
				return arr[top-1];
			}
			return -1;
		}
	}
	

}
