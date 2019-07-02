
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class ProducerThread implements Runnable {
	private BlockingQueue<String> blockingQueue;
	private AtomicInteger count = new AtomicInteger();
	private volatile boolean FLAG = true;

	public ProducerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "�����߿�ʼ����....");
		while (FLAG) {
			String data = count.incrementAndGet() + "";
			try {
				boolean offer = blockingQueue.offer(data, 2, TimeUnit.SECONDS);
				if (offer) {
					System.out.println(Thread.currentThread().getName() + ",��������" + data + "�ɹ�..");
				} else {
					System.out.println(Thread.currentThread().getName() + ",��������" + data + "ʧ��..");
				}
				Thread.sleep(1000);
			} catch (Exception e) {

			}
		}
		System.out.println(Thread.currentThread().getName() + ",�������߳�ֹͣ...");
	}

	public void stop() {
		this.FLAG = false;
	}

}

class ConsumerThread implements Runnable {
	private volatile boolean FLAG = true;
	private BlockingQueue<String> blockingQueue;

	public ConsumerThread(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName() + "�����߿�ʼ����....");
		while (FLAG) {
			try {
				String data = blockingQueue.poll(2, TimeUnit.SECONDS);
				if (data == null) {
					FLAG = false;
					System.out.println("�����߳���2��ʱ��δ��ȡ����Ϣ.");
					return;
				}
				System.out.println("�����߻�ȡ��������Ϣ�ɹ�,data:" + data);

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println(Thread.currentThread().getName() + ",�������߳�ֹͣ...");
	}

}


public class ProducerAndConsumer03 {

	public static void main(String[] args) {
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>(3);
		ProducerThread producerThread = new ProducerThread(blockingQueue);
		ConsumerThread consumerThread = new ConsumerThread(blockingQueue);
		Thread t1 = new Thread(producerThread);
		Thread t2 = new Thread(consumerThread);
		t1.start();
		t2.start();
		//10��� ֹͣ�߳�..
		try {
			Thread.sleep(10*1000);
			producerThread.stop();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
