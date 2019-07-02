/**
所有可能造成尾部0的只有10的倍数，5的倍数，也就是求阶乘中拥有的5的个数。

例如 11 = 1，2，3，4，5，6，7，8，9，10，11。

因数中能分解出两个5，所以有两个0.

26 = 1，2，3，4，5，6，7，8，9，10，11，12，13，14，15，16，17，18，19，20，21，22，23，24，25，26。

5，10，15，20能分解出4个5，25能分解出2个五，所以结果为6.

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
