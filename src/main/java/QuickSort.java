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
			while(arr[j]>=pivot && i<j){//i和j同时走，j找到比基准值小的
				j--;
				if(arr[j]<=pivot){
					int tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
			while(arr[i]<=pivot && i<j){//i和j同时走，i找到比基准值大的
				i++;
				if(arr[i]>=pivot){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
			
		}
		arr[left]=arr[i];//i和j同时走，i和j均找到比基准值小和大的值时，把a[i]和基准值交换
		arr[i]=pivot;
		//然后对基准值左右两边的两个子数组再重复上面的步骤(分而治之)
		quickSort(arr,left,i-1);//对左边的子数组进行快速排序
		quickSort(arr,i+1,right);//对右边的子数组进行快速排序
		
	}

}
