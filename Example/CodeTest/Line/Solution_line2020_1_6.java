import java.util.*;


public class Solution_line2020_1_6 {

	public static void main(String[] args) {
		String s ="/";
		String[] str =s.split("/");
		for(String t:str) {
			System.out.println(t);
		}
		
		String[] di = {"/"};
		String[] com = {
"mkdir /a",
"mkdir /a/b",
"mkdir /a/b/c",
"cp /a/b /",
"rm /a/b/c"
	};
//		solution(di,com);
		

	}
	
	public  String[] solution(String[] directory, String[] command) {
        String[] answer = {};
        tree root = new tree("");
        
        for(int i=0;i<directory.length;++i) {
        	add(root,directory[i]);
        }
        
        for(int i=0;i<command.length;++i) {
        	String[] str =command[i].split(" ");
        	if(str[0].equals("mkdir")) {
        		add(root,str[1]);
        	}
        	else if(str[0].equals("cp")) {
        		copy(root,str[1],str[2]);
        	}
        	else if(str[0].equals("rm")) {
        		remove(root,str[1]);
        	}	
        	
        }
        ArrayList<String> directorys =new ArrayList<String>();
        directorys.add("/");
        
        for(tree t:root.childs) {
        	print(t,directorys,"/");
        }
        
        answer=new String[directorys.size()];
        int idx=0;
        for(String s:directorys) {
        	answer[idx++]=s;
        }
        

        return answer;
    }
	
	private  void print(tree root, ArrayList<String> directorys,String value) {
		directorys.add(value+root.val);
		
		for(tree t:root.childs) {
        	print(t,directorys,value+root.val+"/");
        }
	}

	public  void copy(tree root, String source, String dist) {
		String[] depth = dist.split("/");
    	
    	tree target=root;
    	for(int j=1;j<depth.length-1;++j) {
    		int idx=target.childs.indexOf(new tree(depth[j]));
    		tree child = target.childs.get(idx);
    		target=child;
    	}
    	
    	
    	depth = source.split("/");
    	tree values = root;
    	for(int j=1;j<depth.length;++j) {
    		int idx=values.childs.indexOf(new tree(depth[j]));
    		tree child = values.childs.get(idx);
    		values=child;
    	}
    	
    	cp(target,values);
	}
	
	private  void cp(tree target, tree values) {
		tree child = new tree(values.val);
		target.childs.add(child);
		
		for(int i=0;i<values.childs.size();i++) {
			tree next = values.childs.get(i);
			cp(child,next);
		}
	}

	public  void add(tree root, String val) {
		String[] depth = val.split("/");
    	tree target=root;
    	for(int j=1;j<depth.length-1;++j) {
    		int idx=target.childs.indexOf(new tree(depth[j]));
    		tree child = target.childs.get(idx);
    		target=child;
    	}
    	if(depth.length!=0) {
    		target.childs.add(new tree(depth[depth.length-1]));
    	}
    	
    	
	}
	
	public  void remove(tree root, String val) {
		String[] depth = val.split("/");
    	
    	tree target=root;
    	for(int j=1;j<depth.length-1;++j) {
    		int idx=target.childs.indexOf(new tree(depth[j]));
    		tree child = target.childs.get(idx);
    		target=child;
    	}
    	int idx = target.childs.indexOf(new tree(depth[depth.length-1]));
    	target.childs.remove(idx);
	}
	
	
	
	 class tree{
		String val="";
		ArrayList<tree> childs;
		tree(String a){
			val=a;
			childs = new ArrayList<>();
		}
		

		
		

		public boolean equals(Object obj) {
			tree other = (tree) obj;
			if (val == null) {
				if (other.val != null)
					return false;
			} else if (!val.equals(other.val))
				return false;
			return true;
		}
		
		public boolean equals(String obj) {
			return val.equals(obj);
		}

	}

}
