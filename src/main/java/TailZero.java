/**
���п������β��0��ֻ��10�ı�����5�ı�����Ҳ������׳���ӵ�е�5�ĸ�����

���� 11 = 1��2��3��4��5��6��7��8��9��10��11��

�������ֽܷ������5������������0.

26 = 1��2��3��4��5��6��7��8��9��10��11��12��13��14��15��16��17��18��19��20��21��22��23��24��25��26��

5��10��15��20�ֽܷ��4��5��25�ֽܷ��2���壬���Խ��Ϊ6.

 * @author ASUS
 *
 */
public class TailZero {

	public static void main(String[] args) {
		System.out.println(getZero(105));
		System.out.println(getZero(26));

	}
	
	public static long getZero(long n){
		long result=0;
		long k=5;
		while(k<n){
			result+=n/k;
			k*=5;
		}
		return result;
	}

}
