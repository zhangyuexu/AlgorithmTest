import java.util.Arrays;
import java.util.Scanner;

public class binarySearch {
	public static void main(String[] args){
		int[] arr={2,5,6,7,9,11,13,14,19};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		int min=0;
		int max=arr.length-1;
		int index=-1;
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		sc.close();
		int num=Integer.parseInt(str);//字符串转整形
		//int num=Integer.valueOf(str); //或者用它
		while(min<=max){
			int mid=(min+max)/2;
			if(arr[mid]==num){
				index=mid;
				break;
			}
			else if(arr[mid]>num){
				max=mid-1;
			}
			else{
				min=mid+1;
			}
		}
		System.out.println("查找的数的索引是："+index);
	}
}
