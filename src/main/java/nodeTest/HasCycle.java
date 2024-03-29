package nodeTest;

public class HasCycle {
	static class Node {
		  //注：此处的两个成员变量权限不能为private，因为private的权限是仅对本类访问。
		  int data; //数据域
		  Node next;//指针域
		  
		  public Node(int data) {
		  this.data = data;
		  }
		 }
	
	 public Node head;
	 public Node current;
	  
	 //方法：向链表中添加数据
	 public void add(int data) {
	  //判断链表为空的时候
	  if (head == null) {//如果头结点为空，说明这个链表还没有创建，那就把新的结点赋给头结点
	  head = new Node(data);
	  current = head;
	 } else {
	  //创建新的结点，放在当前节点的后面（把新的结点合链表进行关联）
	  current.next = new Node(data);
	  //把链表的当前索引向后移动一位
	  current = current.next;
	  }
	 }
	  
	  
	 //方法重载：向链表中添加结点
	 public void add(Node node) {
	  if (node == null) {
	  return;
	  }
	  
	  if (head == null) {
	  head = node;
	  current = head;
	  } else {
	  current.next = node;
	  current = current.next;
	  }
	 }
	  
	  
	 //方法：遍历链表（打印输出链表。方法的参数表示从节点node开始进行遍历
	 public void print(Node node) {
	  if (node == null) {
	  return;
	  }
	  
	  current = node;
	  while (current != null) {
	  System.out.println(current.data);
	  current = current.next;
	  }
	 }
	  
	 //方法：检测单链表是否有环
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
	  HasCycle list = new HasCycle();
	  //向LinkList中添加数据
	  for (int i = 0; i < 4; i++) {
	  list.add(i);
	  }
	  //list.print(list.head);
	  list.add(list.head); //将头结点添加到链表当中，于是，单链表就有环了。备注：此时得到的这个环的结构，是下面的第8小节中图1的那种结构。
	  list.print(list.head);
	  System.out.println(list.hasCycle(list.head));
	 }
}
