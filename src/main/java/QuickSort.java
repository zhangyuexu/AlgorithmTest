import java.util.Arrays;

public class QuickSort {
	
	public static void main(String[] args){
		int[] arr={12,20,5,16,15,1,30,45,23,9};
		quickSort(arr,0,arr.length-1);

		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr,int left,int right){
		if(left>right){
			return;
		}
		int pivot=arr[left];
		int i=left;
		int j=right;
		
		while(i<j){
			while(arr[j]>=pivot && i<j){//i��jͬʱ�ߣ�j�ҵ��Ȼ�׼ֵС��
				j--;
				if(arr[j]<=pivot){
					int tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
			while(arr[i]<=pivot && i<j){//i��jͬʱ�ߣ�i�ҵ��Ȼ�׼ֵ���
				i++;
				if(arr[i]>=pivot){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
			
		}
		arr[left]=arr[i];//i��jͬʱ�ߣ�i��j���ҵ��Ȼ�׼ֵС�ʹ��ֵʱ����a[i]�ͻ�׼ֵ����
		arr[i]=pivot;
		//Ȼ��Ի�׼ֵ�������ߵ��������������ظ�����Ĳ���(�ֶ���֮)
		quickSort(arr,left,i-1);//����ߵ���������п�������
		quickSort(arr,i+1,right);//���ұߵ���������п�������
		
	}

}
