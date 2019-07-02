import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 前序递归遍历算法：访问根结点-->递归遍历根结点的左子树-->递归遍历根结点的右子树
 中序递归遍历算法：递归遍历根结点的左子树-->访问根结点-->递归遍历根结点的右子树
 后序递归遍历算法：递归遍历根结点的左子树-->递归遍历根结点的右子树-->访问根结点
 层序遍历：                自上而下，自左至右逐层访问树的结点的过程就是层序遍历
 * @author ASUS
 *
 */
public class BinaryTree {
	class TreeNode{
		private int data;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(int data,TreeNode left,TreeNode right){
			this.data=data;
			this.left=left;
			this.right=right;
		}
	}
	
	 /*
	    * 前序遍历，递归实现
	    * */
	    public void PreOrder(TreeNode node) {
	        if (node != null) {
	            System.out.print(node.data);
	            PreOrder(node.left);
	            PreOrder(node.right);
	        }
	    }
	
	/*
	    * 前序遍历，非递归实现
	    * 1，先入栈根节点，输出根节点val值，再先后入栈其右节点、左结点；
	    * 2，出栈左节点，输出其val值，再入栈该左节点的右节点、左节点；直到遍历完该左节点所在子树。
	    * 3，再出栈右节点，输出其val值，再入栈该右节点的右节点、左节点；直到遍历完该右节点所在子树。
	    * */
	    public void PreOrder1(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        if (root != null) {
	            stack.push(root);
	        }
	        while (!stack.empty()) {
	            TreeNode node = stack.pop();
	            System.out.print(node.data);
	            //右结点先入栈，左结点后入栈
	            if (node.right != null) stack.push(node.right);
	            if (node.left != null) stack.push(node.left);
	        }
	    }
	
	    
	    /*
	     * 中序遍历，递归实现
	     * */
	     public void InOrder(TreeNode node) {
	         if (node != null) {
	             InOrder(node.left);
	             System.out.print(node.data);
	             InOrder(node.right);
	         }
	     }
	     
	     /*
	      * 中序遍历，非递归实现
	      * 1，首先从根节点出发一路向左，入栈所有的左节点；
	      * 2，出栈一个节点，输出该节点val值，查询该节点是否存在右节点，
	      * 若存在则从该右节点出发一路向左入栈该右节点所在子树所有的左节点；
	      * 3，若不存在右节点，则出栈下一个节点，输出节点val值，同步骤2操作；
	      * 4，直到节点为null，且栈为空。
	      * */
	       public void InOrder1(TreeNode root) {
	           Stack<TreeNode> stack = new Stack<TreeNode>();
	           while (root != null || !stack.empty()) {
	               while (root != null) {
	                   stack.push(root);
	                   root = root.left;
	               }
	               if (!stack.empty()) {
	                   TreeNode node = stack.pop();
	                   System.out.print(node.data);
	                   root = node.right;
	               }
	           }
	       }
	       
	       /*
	        * 后序遍历，递归实现
	        * */
	        public void PostOrder(TreeNode node) {
	            if (node != null) {
	                PostOrder(node.left);
	                PostOrder(node.right);
	                System.out.print(node.data);
	            }
	        }
	        /*
		     * 后序遍历，非递归实现
		     * */
	        public static void posOrderUnRecur1(TreeNode root){
	        	System.out.print("PosOrder:");
	        	if(root != null){
	        		Stack<TreeNode> s1 = new Stack<TreeNode>();
	        		Stack<TreeNode> s2 = new Stack<TreeNode>();
	        		s1.push(root);
	        		while(!s1.isEmpty()){
	        			root = s1.pop();
	        			s2.push(root);
	        			if(root.left != null){
	        				s1.push(root.left);
	        			}
	        			if(root.right != null){
	        				s1.push(root.right);
	        			}
	        		}
	        		while(!s2.isEmpty()){
	        			System.out.print(s2.pop().data + " ");
	        		}
	        	}

	        }
	        
	        /*
	         * 层序遍历（广度优先遍历）
	         * */
	         public void LayerOrder(TreeNode root) {
	        	 int leafCount=0;
	             Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
	             if (root != null) queue.offer(root);
	             while (!queue.isEmpty()) {
	                 TreeNode node = queue.poll();
	                 leafCount++;
	                 System.out.print(node.data);
	                 if (node.left != null) queue.offer(node.left);
	                 if (node.right != null) queue.offer(node.right);
	             }
	         }
	
}
