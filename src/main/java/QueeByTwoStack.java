import java.util.Stack;
//使用两个栈实现一个队列
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
		System.out.println(n+"已入队列");
	}
	public void out() throws Exception{
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		if(stack2.isEmpty()){
			System.out.println("队列为空，不能删除");
		}
		
		int m=stack2.pop();
		System.out.println(m+"出队列");
		
	}
}
