import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class RandomRedPackage {
	class RedPackage{
		int remainSize;
		double remainMoney;
	}
	public static void main(String[] args){
		new RandomRedPackage().init();
		
		
	}
	public void init(){
		final RedPackage redPackage=new RedPackage();
		redPackage.remainSize=30;
		redPackage.remainMoney=500;
		for(int i=0;i<redPackage.remainSize;i++){
			new Thread(new Runnable(){
				public void run(){
					try {
						System.out.println(getRandomMoney(redPackage));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	private static Semaphore aaa = new Semaphore(10);
	private static Map<String,Integer> map = new HashMap<String, Integer>();
	static{
		for ( Method method : RandomRedPackage.class.getDeclaredMethods() ){
		
			map.put( method.getName() , new Random().nextInt() % 5 );
			}
	}
	public static double getRandomMoney(RedPackage _redPackage) throws Exception{
		aaa.acquire( map.get( "getRandomMoney" ).intValue());
		if(_redPackage.remainSize==1){
			_redPackage.remainSize--;
			return (double)Math.round(_redPackage.remainMoney*100)/100;//round 则是4舍5入的计算
		}
		Random r=new Random();
		double min=0.01;
		double max=_redPackage.remainMoney/_redPackage.remainSize*2;
		double money=r.nextDouble()*max;
		money=money<=min?0.01:money;
		money=Math.floor(money*100)/100;//floor 返回不大于的最大整数 
		_redPackage.remainSize--;
		_redPackage.remainMoney-=money;
		Thread.sleep(3000);
		aaa.release(map.get( "getRandomMoney" ).intValue());
		return money;
	}
}
