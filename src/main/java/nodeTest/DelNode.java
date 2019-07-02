package nodeTest;

public class DelNode {
	public static class Node{
		public int data;
		public Node next;
		public Node(int data,Node next){
			this.data=data;
			this.next=next;
		}
	}
	public static Node delNode(Node head,Node node){
		if(node.next==null){
			while(head.next!=node){
				head=head.next;
			}
			head.next=null;
			return null;
		}
		else if(node==head){
			head=head.next;
			return head;
		}
		else{
			node.data=node.next.data;
			node.next=node.next.next;
			return head;
		}
		
	}

	public static void main(String[] args) {
		Node tail=new Node(4, null);
		Node c=new Node(3,tail);
		Node b=new Node(2,c);
		Node head=new Node(1,b);
		delNode(head, tail);
		Node result=delNode(head, head);
		while(result!=null){
			System.out.print(result.data+" ");
			result=result.next;
		}	
		

	}

}
