

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Res02{
	public String name;
	public String sex;
	
	public boolean flag=false;
	public Lock lock=new ReentrantLock();
	public Condition condition=lock.newCondition();
	
}

class Producer02 extends Thread{
	public Res02 res;
	public Producer02(Res02 res){
		this.res=res;
	}
	
	public void run(){
		int count=0;
		while (true) {
			try {
				res.lock.lock();
				if(res.flag){
					res.condition.await();
				}
				if(count==0){
					res.name="小军";
					res.sex="男";
				}else{
					res.name="小红";
					res.sex="女";
				}
				count=(count+1)%2;
				res.flag=true;
				res.condition.signal();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				res.lock.unlock();
			}
			
		}
	}
}

class Consumer02 extends Thread{
	public Res02 res;
	public Consumer02(Res02 res){
		this.res=res;
	}
	
	public void run(){
		while(true){
			try {
				res.lock.lock();
				if(!res.flag){
					res.condition.await();
				}
				System.out.println(res.name+","+res.sex);
				Thread.sleep(2000);
				res.flag=false;
				res.condition.signal();
				
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				res.lock.unlock();
			}
		}
	}
	
}
public class ProducerAndConsumer02 {

	public static void main(String[] args) {
		Res02 res=new Res02();
		Producer02 producer=new Producer02(res);
		producer.start();
		Consumer02 consumer=new Consumer02(res);
		consumer.start();
		

	}

}
