
class Res01{
	public String name;
	public String sex;
	// Ϊtrue����� �����������д
	// Ϊfalse����� ����д�����ܶ���
	public boolean flag=false;
}

class Producer01 extends Thread{
	public Res01 res;
	public Producer01(Res01 res){
		this.res=res;
	}
	public void run(){
		int count=0;
		while (true) {
			synchronized (res) {
				if(res.flag){
					try {
						res.wait();// ጷŵ�ǰ������
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(count==0){
					res.name="С��";
					res.sex="��";
				}else{
					res.name="С��";
					res.sex="Ů";
				}
				count=(count+1)%2;
				res.flag=true;
				res.notify();// ���ѱ��ȴ����߳�
			}

		}
	}
}

class Consumer01 extends Thread{
	public Res01 res;
	public Consumer01(Res01 res){
		this.res=res;
	}
	
	public void run(){
		while(true){
			synchronized (res) {
				if(!res.flag){
					try {
						res.wait();
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(res.name+","+res.sex);
				res.flag=false;
				res.notify();
			}
		}
	}
}

public class ProducerAndConsumer01 {
	
	public static void main(String[] args) {
		Res01 res=new Res01();
		Producer01 producer=new Producer01(res);
		producer.start();
		Consumer01 consumer=new Consumer01(res);
		consumer.start();

	}

}
