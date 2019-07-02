package nodeTest;

import java.util.Arrays;

public class 快速排序 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr={5,2,6,8,3,1};
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quickSort(int[] arr,int left,int right){
		if(left>right){//一定要加上这句话，否则递归会导致栈要溢出
			return;
		}
		
		int pivot=arr[left];
		int i=left;
		int j=right;
		while(i<j){
			while(arr[j]>=pivot && i<j){
				j--;
				if(arr[j]<=pivot){
					int tmp=arr[j];
					arr[j]=arr[i];
					arr[i]=tmp;
				}
			}
			while(arr[i]<=pivot && i<j){
				i++;
				if(arr[i]>=pivot){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		
		arr[left]=arr[i];
		arr[i]=pivot;
		quickSort(arr, left, i-1);
		quickSort(arr, i+1, right);
	}

}
