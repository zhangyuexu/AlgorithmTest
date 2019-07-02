package nodeTest;

import java.util.Stack;

public class NodeImplement {
	class Node{
		//此处的两个成员变量不能是private，因为private的权限是仅对本类访问
		int data;//数据域
		Node next;//指针域
		public Node(int data){
			this.data=data;
		}
	}
	
	private Node head;
	private Node current;
	//向链表中添加数据
	public void add(int data){
		if(head==null){
			head=new Node(data);
			current=head;
		}
		else{
			current.next=new Node(data);
			current=current.next;
		}
	}
	
	//O(1)时间删除链表节点
	public void deleteNode(Node head,Node node){
		//删除尾结点
		if(node.next==null){
			while(head!=node){
				head=head.next;
			}
			//head.next=null;
			head=null;
		}
		//删除头结点
		else if(node==head){
			head=null;
		}
		//删除中间的普通结点
		else{
			node.data=node.next.data;
			node.next=node.next.next;
		}
	}
	//遍历链表
	public void print(Node node){
		if(node==null){
			return;
		}
		current=node;
		while(current!=null){
			System.out.print(current.data+" ");
			current=current.next;
		}
	}
	//求单链表的长度
	public int getLength(Node head){
		if(head==null){
			return 0;
		}
		int length=0;
		Node current=head;
		while(current!=null){
			length++;
			current=current.next;
		}
		return length;
	}
	//查找单链表中的倒数第k个结点
	public int findLastKNode1(int index){
		//第一次遍历得到链表的长度
		if(head==null){
			System.out.println("该链表为空");
			return -1;
		}
		int length=0;
		current=head;
		while(current!=null){
			length++;
			current=current.next;
		}
		//第二次遍历，输出倒数第index个节点的数据
		current=head;
		for(int i=0;i<length-index;i++){
			current=current.next;
		}
		return current.data;
	}
	//查找单链表中的倒数第k个结点(面试官不允许你遍历链表的长度)
	/**
	 * 这里需要声明两个指针：即两个结点型的变量first和second,首先让first和second都指向第一个结点
	 * 然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置
	 * 然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
	 */
	public Node findLastKNode(Node head,int k){
		if(k==0||head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		//让second结点往后挪k-1个位置
		for(int i=0;i<k-1;i++){
			second=second.next;
		}
		if(second==null){//说明k的值已经大于链表的长度了
			throw new NullPointerException(k+"值已经超过了链表的长度");
			//return null;
		}
		//让first和second再整体后移,直到second节点走到最后一个结点
		while(second!=null){
			first=first.next;
			second=second.next;
		}
		//当second走到最后一个节点时，此时first所指向的节点就是我们要找的节点
		return first;
		
	}
	//查找单链表中的中间结点
	/**
	 *同样，面试官不允许你算出链表的长度，该怎么做呢？
     * 思路：
     * 和上面一样，也是设置两个指针first和second都同时指向head
     * 只不过这里是，两个指针同时向前走，second指针每次走两步，first指针每次走一步
     * 直到second指针走到最后一个结点时，此时first指针所指的结点就是中间结点。
     * 注意链表为空，链表结点个数为1和2的情况。时间复杂度为O（n）
     * 当n为偶数时，得到的中间结点是第n/2 + 1个结点。比如链表有6个节点时，得到的是第4个节点。
	 */
	public Node findMidNode(Node head){
		if(head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		//每次移动时，让first指针走一步，second指针走两步，
		while(second!=null&&second.next!=null){
			first=first.next;
			second=second.next.next;
		}
		//直到second结点移动到null时，此时first指针指向的位置就是中间结点的位置
		return first;
	}
	
	//两个参数代表的是两个链表的头结点
    public Node mergeLinkList(Node head1, Node head2) {

        if (head1 == null && head2 == null) {  //如果两个链表都为空
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head; //新链表的头结点
        Node current;  //current结点指向新链表

        // 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;  //新链表中，current指针的下一个结点对应较小的那个数据
                current = current.next; //current指针下移
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //合并剩余的元素
        if (head1 != null) { //说明链表2遍历完了，是空的
            current.next = head1;
        }

        if (head2 != null) { //说明链表1遍历完了，是空的
            current.next = head2;
        }

        return head;
    }
    
	//链表反转
	public Node reverseList(Node head) {
		//如果链表为空或者只有一个节点，无需反转，直接返回原链表的头结点
		 if (head == null || head.next == null) {
		 return head;
		}
		Node prev = null;
        while(head!=null){
            Node tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
	}
	//方法：从尾到头打印单链表
	public void reversePrint(Node head) {
		 
		if (head == null) {
		 return;
		 }
		 
		 Stack<Node> stack = new Stack<Node>(); //新建一个栈
		 Node current = head;
		 
		 //将链表的所有结点压栈
		 while (current != null) {
		 stack.push(current); //将当前结点压栈
		 current = current.next;
		}
		 
		 //将栈中的结点打印输出即可
		while (stack.size() > 0) {
		 System.out.println(stack.pop().data); //出栈操作
		}
	}
	
	//方法：判断单链表是否有环
	public boolean hasCycle(Node head) {
	 
	 if (head == null) {
	 return false;
	 }
	 
	 Node first = head;
	 Node second = head;
	 
	 while (second != null) {
	 first = first.next; //first指针走一步
	 second = second.next.next; //second指针走两步
	 
	 if (first == second) { //一旦两个指针相遇，说明链表是有环的
	  return true;
	 }
	}
	 
	 return false;
	}
	public static void main(String[] args) {
		NodeImplement LinkList=new NodeImplement();
		for(int i=0;i<10;i++){
			LinkList.add(i);
		}
		LinkList.print(LinkList.head);
		System.out.println();
//		System.out.println(LinkList.hasCycle(LinkList.head));
		Node result=LinkList.reverseList(LinkList.head);
		LinkList.print(result);

	}

}
