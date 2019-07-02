import java.util.LinkedList;
//使用两个队列实现一个栈
public class StackByTwoQueue {
	public static void main(String[] args) {
		StackByTwoQueue sbq=new StackByTwoQueue();
		for(int i=0;i<10;i++){
			sbq.push(i);
		}
		for(int i=0;i<20;i++){
			System.out.println(sbq.pop()+"弹出栈");
		}
	}
	
	private LinkedList<Integer> queue1=new LinkedList<Integer>();
	private LinkedList<Integer> queue2=new LinkedList<Integer>();
	public void push(Integer n){
		if(queue1.isEmpty()){
			queue2.add(n);
			System.out.println(n+"压入栈");
		}
		if(queue2.isEmpty()){
			queue1.add(n);
			System.out.println(n+"压入栈");
		}
	}
	public int pop(){
		if(queue1.isEmpty()&&queue2.isEmpty()){
			try{
				System.out.println("stack is empty");
			}catch(Exception e){}
			
		}
		if(queue1.isEmpty()){
			while(queue2.size()>1){
				queue1.add(queue2.poll());
			}
			return queue2.poll();
		}
		if(queue2.isEmpty()){
			while(queue1.size()>1){
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return -1;
	}

}
