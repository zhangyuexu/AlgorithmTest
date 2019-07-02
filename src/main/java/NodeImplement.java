
public class NodeImplement {
	class Node{
		//�˴���������Ա����������private����Ϊprivate��Ȩ���ǽ��Ա������
		int data;//������
		Node next;//ָ����
		public Node(int data){
			this.data=data;
		}
	}
	
	private Node head;
	private Node current;
	//���������������
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
	//��������
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
