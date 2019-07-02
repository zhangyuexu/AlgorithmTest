import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 ǰ��ݹ�����㷨�����ʸ����-->�ݹ����������������-->�ݹ����������������
 ����ݹ�����㷨���ݹ����������������-->���ʸ����-->�ݹ����������������
 ����ݹ�����㷨���ݹ����������������-->�ݹ����������������-->���ʸ����
 ���������                ���϶��£������������������Ľ��Ĺ��̾��ǲ������
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
	    * ǰ��������ݹ�ʵ��
	    * */
	    public void PreOrder(TreeNode node) {
	        if (node != null) {
	            System.out.print(node.data);
	            PreOrder(node.left);
	            PreOrder(node.right);
	        }
	    }
	
	/*
	    * ǰ��������ǵݹ�ʵ��
	    * 1������ջ���ڵ㣬������ڵ�valֵ�����Ⱥ���ջ���ҽڵ㡢���㣻
	    * 2����ջ��ڵ㣬�����valֵ������ջ����ڵ���ҽڵ㡢��ڵ㣻ֱ�����������ڵ�����������
	    * 3���ٳ�ջ�ҽڵ㣬�����valֵ������ջ���ҽڵ���ҽڵ㡢��ڵ㣻ֱ����������ҽڵ�����������
	    * */
	    public void PreOrder1(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        if (root != null) {
	            stack.push(root);
	        }
	        while (!stack.empty()) {
	            TreeNode node = stack.pop();
	            System.out.print(node.data);
	            //�ҽ������ջ���������ջ
	            if (node.right != null) stack.push(node.right);
	            if (node.left != null) stack.push(node.left);
	        }
	    }
	
	    
	    /*
	     * ����������ݹ�ʵ��
	     * */
	     public void InOrder(TreeNode node) {
	         if (node != null) {
	             InOrder(node.left);
	             System.out.print(node.data);
	             InOrder(node.right);
	         }
	     }
	     
	     /*
	      * ����������ǵݹ�ʵ��
	      * 1�����ȴӸ��ڵ����һ·������ջ���е���ڵ㣻
	      * 2����ջһ���ڵ㣬����ýڵ�valֵ����ѯ�ýڵ��Ƿ�����ҽڵ㣬
	      * ��������Ӹ��ҽڵ����һ·������ջ���ҽڵ������������е���ڵ㣻
	      * 3�����������ҽڵ㣬���ջ��һ���ڵ㣬����ڵ�valֵ��ͬ����2������
	      * 4��ֱ���ڵ�Ϊnull����ջΪ�ա�
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
	        * ����������ݹ�ʵ��
	        * */
	        public void PostOrder(TreeNode node) {
	            if (node != null) {
	                PostOrder(node.left);
	                PostOrder(node.right);
	                System.out.print(node.data);
	            }
	        }
	        /*
		     * ����������ǵݹ�ʵ��
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
	         * ���������������ȱ�����
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
