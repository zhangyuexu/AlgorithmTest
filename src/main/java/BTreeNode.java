import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class BTreeNode {
	char val;
	BTreeNode left=null;
	BTreeNode right=null;
	BTreeNode(char _val){
		this.val=_val;
	}

	//��������߶�
	public int getHight(BTreeNode root){
		if(root==null){
			return 0;
		}
		else{
			int left=getHight(root.left);
			int right=getHight(root.right);
			return 1+Math.max(left, right);
		}
	}
	
	//�ǵݹ�ʵ�� �߶�
	  public int findDeep2(BTreeNode root)  
	  {  
	     if(root == null)  
	         return 0;  
	      
	     BTreeNode current = null;  
	     LinkedList<BTreeNode> queue = new LinkedList<BTreeNode>();  
	     queue.offer(root);  
	     int cur,last;
	     int level = 0;
	     while(!queue.isEmpty())  
	     {  
	         cur = 0;//��¼�����Ѿ������Ľڵ����  
	         last = queue.size();//�������굱ǰ���Ժ󣬶�����Ԫ��ȫ����һ���Ԫ�أ����еĳ�������һ��Ľڵ�ĸ���  
	         while(cur < last)//����û�б������������һ���ڵ�ʱѭ��  
	         {  
	             current = queue.poll();//����һ��Ԫ��  
	             cur++;  
	             //�ѵ�ǰ�ڵ�����ҽڵ���ӣ�������ڵĻ���  
	             if(current.left != null)  
	             {  
	                 queue.offer(current.left);  
	             }  
	             if(current.right != null)  
	             {  
	                 queue.offer(current.right);  
	             }  
	         }  
	         level++;//ÿ������һ��level+1  
	     }  
	     return level;  
	  }  

	
	//�ǵݹ���������Ŀ��
	  public int getWeidth(BTreeNode root)  
	  {  
	     if(root == null)  
	         return 0;  
	      
	     BTreeNode current = null;  
	     LinkedList<BTreeNode> queue = new LinkedList<BTreeNode>();  
	     queue.offer(root);  
	     int cur,last = 0,max=0;;
	     while(!queue.isEmpty())  
	     {  
	         cur = 0;//��¼�����Ѿ������Ľڵ����  
	         last = queue.size();//�������굱ǰ���Ժ󣬶�����Ԫ��ȫ����һ���Ԫ�أ����еĳ�������һ��Ľڵ�ĸ���  
	        
	         while(cur < last)//����û�б������������һ���ڵ�ʱѭ��  
	         {  
	             current = queue.poll();//����һ��Ԫ��  
	             cur++;  
	             //�ѵ�ǰ�ڵ�����ҽڵ���ӣ�������ڵĻ���  
	             if(current.left != null)  
	             {  
	                 queue.offer(current.left);  
	             }  
	             if(current.right != null)  
	             {  
	                 queue.offer(current.right);  
	             }  
	         }
	         if(last>max){max=last;}
	     }  
	     System.out.println("��ȣ�"+last);
	     System.out.println("����ȣ�"+max);
	     return last;  
	  }  
	  
	//��������Ŀ��2
	public static int getWeight2(BTreeNode root){
		int result=0;
		if(root==null){
			return 0;
		}
		else if(root.left==null||root.right==null){
			return 1;
		}
		else{
			result=getWeight2(root.left)+getWeight2(root.right);
		}
		return result;
	}
	//��Ҷ�ӽڵ��õľ��ǲ�α���
	public static int countOfLeaf(BTreeNode root){
		if(root==null){
			return 0;
		}
		int count=0;
		Queue<BTreeNode> queue=new ArrayDeque<BTreeNode>();
		
		queue.offer(root);
		while(!queue.isEmpty()){
			BTreeNode bt=queue.poll();
			count++;
			if(bt.left!=null){queue.offer(bt.left);}
			if(bt.right!=null){queue.offer(bt.right);}
		}
		return count-1;
		
	}
	public static void main(String[] args){
		BTreeNode bt=new BTreeNode('a');
		bt.left=new BTreeNode('b');
		bt.right=new BTreeNode('c');
		bt.left.left=new BTreeNode('d');
		bt.left.right=new BTreeNode('e');
		bt.right.left=new BTreeNode('f');
		bt.right.right=new BTreeNode('g');
		System.out.println(bt.getHight(bt));
		System.out.println("�ǵݹ�߶ȣ�"+bt.findDeep2(bt));
		System.out.println(bt.getWeidth(bt));
		System.out.println("getWeight2:"+getWeight2(bt));
		System.out.println(countOfLeaf(bt));
	}

}
