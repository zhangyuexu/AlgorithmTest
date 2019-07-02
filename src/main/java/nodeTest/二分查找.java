package nodeTest;

import java.util.Arrays;
import java.util.Scanner;

public class 二分查找 {

	public static void main(String[] args) {
		int[] arr={5,2,6,8,3,1};
		Arrays.sort(arr);//数组必须是从小到大的顺序，这样才能进行后面的二分查找
		System.out.println(Arrays.toString(arr));
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		scanner.close();
		int target=Integer.parseInt(s);
		System.out.println(getSearch(arr, target));

	}
	public static int getSearch(int[] arr,int target){
		int min=0,max=arr.length-1;
		int index=-1;
		while(min<=max){
			int mid=(min+max)/2;
			if(arr[mid]==target){
				index=mid;
				break;
			}
			else if(arr[mid]>target){
				max=mid-1;
			}
			else{
				min=mid+1;
			}
		}
		return index;
	}

}
