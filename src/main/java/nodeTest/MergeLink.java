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
			if(head1==null && head2==null){//˵����������Ϊ��
				return null;
			}
			if(head1==null){
				return head2;
			}
			if(head2==null){
				return head1;
			}
			Node head;//�������ͷ���
			Node current;//current���ָ�������� 
			// һ��ʼ��������current���ָ��head1��head2�н�С�����ݣ��õ�head���
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
			//�ϲ�ʣ���Ԫ��
			if(head1!=null){//˵������2�������ˣ��ǿյ�
				current.next=head1;
			}
			if(head2!=null){//˵������1�������ˣ��ǿյ�
				current.next=head2;
			}
			return head;
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
		//���������������
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
