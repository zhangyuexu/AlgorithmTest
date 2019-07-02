package nodeTest;

import java.util.Arrays;
import java.util.Scanner;

public class ���ֲ��� {

	public static void main(String[] args) {
		int[] arr={5,2,6,8,3,1};
		Arrays.sort(arr);//��������Ǵ�С�����˳���������ܽ��к���Ķ��ֲ���
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
