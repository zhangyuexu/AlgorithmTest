import java.util.Arrays;
/**
 *ѡ�������������򣬱���һǧ������¼��������Ҫ5�Σ���ô��ǧ��������ֻ����1�β���
 *���˼���ǣ�
 *1����һ�飺��һ�����ڶ����ȣ�������������λ�ã�Ȼ���ǵ�һ�����������ȣ�������������λ�ã��Դ����ơ�����
 *2���ڶ��飺�ڶ������������ȣ�������������λ�ã�Ȼ���ǵڶ��������ĸ��ȣ�������������λ�ã��Դ����ơ�����
 */
public class SelectSort {

	public static void main(String[] args) {
		int[] arr={3,1,2,4,5};
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));

	}

}
