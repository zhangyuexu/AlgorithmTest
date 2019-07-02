package nodeTest;

public class HasCycle {
	static class Node {
		  //ע���˴���������Ա����Ȩ�޲���Ϊprivate����Ϊprivate��Ȩ���ǽ��Ա�����ʡ�
		  int data; //������
		  Node next;//ָ����
		  
		  public Node(int data) {
		  this.data = data;
		  }
		 }
	
	 public Node head;
	 public Node current;
	  
	 //���������������������
	 public void add(int data) {
	  //�ж�����Ϊ�յ�ʱ��
	  if (head == null) {//���ͷ���Ϊ�գ�˵���������û�д������ǾͰ��µĽ�㸳��ͷ���
	  head = new Node(data);
	  current = head;
	 } else {
	  //�����µĽ�㣬���ڵ�ǰ�ڵ�ĺ��棨���µĽ���������й�����
	  current.next = new Node(data);
	  //������ĵ�ǰ��������ƶ�һλ
	  current = current.next;
	  }
	 }
	  
	  
	 //�������أ�����������ӽ��
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
	  
	  
	 //����������������ӡ������������Ĳ�����ʾ�ӽڵ�node��ʼ���б���
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
	  
	 //��������ⵥ�����Ƿ��л�
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
	  HasCycle list = new HasCycle();
	  //��LinkList���������
	  for (int i = 0; i < 4; i++) {
	  list.add(i);
	  }
	  //list.print(list.head);
	  list.add(list.head); //��ͷ�����ӵ������У����ǣ���������л��ˡ���ע����ʱ�õ���������Ľṹ��������ĵ�8С����ͼ1�����ֽṹ��
	  list.print(list.head);
	  System.out.println(list.hasCycle(list.head));
	 }
}
