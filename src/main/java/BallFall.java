
public class BallFall {
	static double height=100;
	static double distance=100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++){
			distance=distance+height;
			height=height/2.0;
		}
		System.out.println("10次总共经过的距离是："+distance);
		System.out.println("第10次反弹的高度是："+height/2);//height在原来基础上还得除2
	}

}
