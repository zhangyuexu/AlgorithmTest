/**
 * 求1000以内的完数
 *一个数如果恰好等于它的因子之和，这个数被称为完数
 */
public class WanShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1000以内的完数有：");
		for(int i=1;i<1000;i++){
			int t=0;
			for(int j=1;j<=i/2;j++){
				if(i%j==0){
					t=t+j;
				}
			}
			if(t==i){
				System.out.print(i+" ");
			}
		}
	}

}
