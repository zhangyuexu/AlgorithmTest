
public class BallFall {
	static double height=100;
	static double distance=100;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<10;i++){
			distance=distance+height;
			height=height/2.0;
		}
		System.out.println("10���ܹ������ľ����ǣ�"+distance);
		System.out.println("��10�η����ĸ߶��ǣ�"+height/2);//height��ԭ�������ϻ��ó�2
	}

}
