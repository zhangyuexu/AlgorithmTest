
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
	public static void main(String[] args) {
		NodeImplement LinkList=new NodeImplement();
		for(int i=0;i<10;i++){
			LinkList.add(i);
		}
		LinkList.print(LinkList.head);

	}

}
