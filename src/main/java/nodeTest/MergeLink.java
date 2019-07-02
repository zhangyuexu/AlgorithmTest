package nodeTest;

public class MergeLink {
	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data=data;
		}
	}
		private Node head;
		private Node current;
		public Node mergeLinkList(Node head1,Node head2){
			if(head1==null && head2==null){//说明两个链表都为空
				return null;
			}
			if(head1==null){
				return head2;
			}
			if(head2==null){
				return head1;
			}
			Node head;//新链表的头结点
			Node current;//current结点指向新链表 
			// 一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
			if(head1.data<head2.data){
				head=head1;
				current=head1;
				head1=head1.next;
			}
			else{
				head=head2;
				current=head2;
				head2=head2.next;
			}
			while(head1!=null && head2!=null){
				if(head1.data<head2.data){
					current.next=head1;
					current=current.next;
					head1=head1.next;
				}
				else{
					current.next=head2;
					current=current.next;
					head2=head2.next;
				}
			}
			//合并剩余的元素
			if(head1!=null){//说明链表2遍历完了，是空的
				current.next=head1;
			}
			if(head2!=null){//说明链表1遍历完了，是空的
				current.next=head2;
			}
			return head;
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
		//向链表中添加数据
		public void add(int data){
			if(head==null){
				head=new Node(data);
				current=head;
			}
			current.next=new Node(data);
			current=current.next;
		}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLink link1=new MergeLink();
		MergeLink link2=new MergeLink();
		MergeLink link3=new MergeLink();
		for(int i=0;i<4;i++){
			link1.add(i);
		}
		for(int i=3;i<8;i++){
			link2.add(i);
		}
		link3.head=link3.mergeLinkList(link1.head, link2.head);
		link3.print(link3.head);
	}

}
