import java.util.Arrays;

public class Bubble {
	/**
	 * ð������
	 * ���˼���ǣ�
     *1����һ�飺��һ�����ڶ����ȣ�������������λ�ã�Ȼ��ڶ������������ȣ�������������λ�ã�Ȼ������������ĸ��ȣ�������������λ�ã��Դ����ơ�����������һ�α�7��
     *2���ڶ��飺�ڶ��α�6��
	 */
	public static void main(String[] args) {
		int [] arr={3,1,2,5,4,7,6};
		for(int i=arr.length-1;i>=0;i--){
			for(int j=0;j<i;j++){
				if(arr[j]>arr[j+1]){
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}

		for(int x:arr){
			System.out.print(x+" ");
		}
		System.out.println();
		//�ɴ˿��������Ԫ�ؿ��Է����仯����������ĳ����ǹ̶��ģ����ܱ䣻
		System.out.println(Arrays.toString(arr));
	}

}
