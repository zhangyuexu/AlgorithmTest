package nodeTest;

import java.util.Stack;

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
	
	//O(1)ʱ��ɾ������ڵ�
	public void deleteNode(Node head,Node node){
		//ɾ��β���
		if(node.next==null){
			while(head!=node){
				head=head.next;
			}
			//head.next=null;
			head=null;
		}
		//ɾ��ͷ���
		else if(node==head){
			head=null;
		}
		//ɾ���м����ͨ���
		else{
			node.data=node.next.data;
			node.next=node.next.next;
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
	//������ĳ���
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
	//���ҵ������еĵ�����k�����
	public int findLastKNode1(int index){
		//��һ�α����õ�����ĳ���
		if(head==null){
			System.out.println("������Ϊ��");
			return -1;
		}
		int length=0;
		current=head;
		while(current!=null){
			length++;
			current=current.next;
		}
		//�ڶ��α��������������index���ڵ������
		current=head;
		for(int i=0;i<length-index;i++){
			current=current.next;
		}
		return current.data;
	}
	//���ҵ������еĵ�����k�����(���Թٲ��������������ĳ���)
	/**
	 * ������Ҫ��������ָ�룺����������͵ı���first��second,������first��second��ָ���һ�����
	 * Ȼ����second�������Ųk-1��λ�ã���ʱfirst��second�ͼ����k-1��λ��
	 * Ȼ����������ƶ��������ڵ㣬ֱ��second�ڵ��ߵ����һ������ʱ�򣬴�ʱfirst�ڵ���ָ���λ�þ��ǵ�����k���ڵ��λ�á�ʱ�临�Ӷ�ΪO��n��
	 */
	public Node findLastKNode(Node head,int k){
		if(k==0||head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		//��second�������Ųk-1��λ��
		for(int i=0;i<k-1;i++){
			second=second.next;
		}
		if(second==null){//˵��k��ֵ�Ѿ���������ĳ�����
			throw new NullPointerException(k+"ֵ�Ѿ�����������ĳ���");
			//return null;
		}
		//��first��second���������,ֱ��second�ڵ��ߵ����һ�����
		while(second!=null){
			first=first.next;
			second=second.next;
		}
		//��second�ߵ����һ���ڵ�ʱ����ʱfirst��ָ��Ľڵ��������Ҫ�ҵĽڵ�
		return first;
		
	}
	//���ҵ������е��м���
	/**
	 *ͬ�������Թٲ��������������ĳ��ȣ�����ô���أ�
     * ˼·��
     * ������һ����Ҳ����������ָ��first��second��ͬʱָ��head
     * ֻ���������ǣ�����ָ��ͬʱ��ǰ�ߣ�secondָ��ÿ����������firstָ��ÿ����һ��
     * ֱ��secondָ���ߵ����һ�����ʱ����ʱfirstָ����ָ�Ľ������м��㡣
     * ע������Ϊ�գ����������Ϊ1��2�������ʱ�临�Ӷ�ΪO��n��
     * ��nΪż��ʱ���õ����м����ǵ�n/2 + 1����㡣����������6���ڵ�ʱ���õ����ǵ�4���ڵ㡣
	 */
	public Node findMidNode(Node head){
		if(head==null){
			return null;
		}
		Node first=head;
		Node second=head;
		//ÿ���ƶ�ʱ����firstָ����һ����secondָ����������
		while(second!=null&&second.next!=null){
			first=first.next;
			second=second.next.next;
		}
		//ֱ��second����ƶ���nullʱ����ʱfirstָ��ָ���λ�þ����м����λ��
		return first;
	}
	
	//������������������������ͷ���
    public Node mergeLinkList(Node head1, Node head2) {

        if (head1 == null && head2 == null) {  //�����������Ϊ��
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head; //�������ͷ���
        Node current;  //current���ָ��������

        // һ��ʼ��������current���ָ��head1��head2�н�С�����ݣ��õ�head���
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
                current.next = head1;  //�������У�currentָ�����һ������Ӧ��С���Ǹ�����
                current = current.next; //currentָ������
                head1 = head1.next;
            } else {
                current.next = head2;
                current = current.next;
                head2 = head2.next;
            }
        }

        //�ϲ�ʣ���Ԫ��
        if (head1 != null) { //˵������2�������ˣ��ǿյ�
            current.next = head1;
        }

        if (head2 != null) { //˵������1�������ˣ��ǿյ�
            current.next = head2;
        }

        return head;
    }
    
	//����ת
	public Node reverseList(Node head) {
		//�������Ϊ�ջ���ֻ��һ���ڵ㣬���跴ת��ֱ�ӷ���ԭ�����ͷ���
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
	//��������β��ͷ��ӡ������
	public void reversePrint(Node head) {
		 
		if (head == null) {
		 return;
		 }
		 
		 Stack<Node> stack = new Stack<Node>(); //�½�һ��ջ
		 Node current = head;
		 
		 //����������н��ѹջ
		 while (current != null) {
		 stack.push(current); //����ǰ���ѹջ
		 current = current.next;
		}
		 
		 //��ջ�еĽ���ӡ�������
		while (stack.size() > 0) {
		 System.out.println(stack.pop().data); //��ջ����
		}
	}
	
	//�������жϵ������Ƿ��л�
	public boolean hasCycle(Node head) {
	 
	 if (head == null) {
	 return false;
	 }
	 
	 Node first = head;
	 Node second = head;
	 
	 while (second != null) {
	 first = first.next; //firstָ����һ��
	 second = second.next.next; //secondָ��������
	 
	 if (first == second) { //һ������ָ��������˵���������л���
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
