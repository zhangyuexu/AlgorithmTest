/**
 * ��1000���ڵ�����
 *һ�������ǡ�õ�����������֮�ͣ����������Ϊ����
 */
public class WanShu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1000���ڵ������У�");
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
