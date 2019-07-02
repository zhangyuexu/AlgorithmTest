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

	//求二叉树高度
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
	
	//非递归实现 高度
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
	         cur = 0;//记录本层已经遍历的节点个数  
	         last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数  
	         while(cur < last)//当还没有遍历到本层最后一个节点时循环  
	         {  
	             current = queue.poll();//出队一个元素  
	             cur++;  
	             //把当前节点的左右节点入队（如果存在的话）  
	             if(current.left != null)  
	             {  
	                 queue.offer(current.left);  
	             }  
	             if(current.right != null)  
	             {  
	                 queue.offer(current.right);  
	             }  
	         }  
	         level++;//每遍历完一层level+1  
	     }  
	     return level;  
	  }  

	
	//非递归求二叉树的宽度
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
	         cur = 0;//记录本层已经遍历的节点个数  
	         last = queue.size();//当遍历完当前层以后，队列里元素全是下一层的元素，队列的长度是这一层的节点的个数  
	        
	         while(cur < last)//当还没有遍历到本层最后一个节点时循环  
	         {  
	             current = queue.poll();//出队一个元素  
	             cur++;  
	             //把当前节点的左右节点入队（如果存在的话）  
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
	     System.out.println("宽度："+last);
	     System.out.println("最大宽度："+max);
	     return last;  
	  }  
	  
	//求二叉树的宽度2
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
	//求叶子节点用的就是层次遍历
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
		System.out.println("非递归高度："+bt.findDeep2(bt));
		System.out.println(bt.getWeidth(bt));
		System.out.println("getWeight2:"+getWeight2(bt));
		System.out.println(countOfLeaf(bt));
	}

}
