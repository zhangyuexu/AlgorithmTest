import java.util.Stack;
//ʹ������ջʵ��һ������
public class QueeByTwoStack {
	public static void main(String [] args) throws Exception{
		QueeByTwoStack qbs=new QueeByTwoStack();
		qbs.put(1);
		qbs.put(2);
		qbs.put(3);
		qbs.put(4);
		
		qbs.out();
		qbs.out();
		qbs.out();
		qbs.out();
		
	}
	private Stack<Integer> stack1=new Stack<Integer>();
	private Stack<Integer> stack2=new Stack<Integer>();
	
	public void put(Integer n){
		stack1.push(n);
		System.out.println(n+"�������");
	}
	public void out() throws Exception{
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		if(stack2.isEmpty()){
			System.out.println("����Ϊ�գ�����ɾ��");
		}
		
		int m=stack2.pop();
		System.out.println(m+"������");
		
	}
}
