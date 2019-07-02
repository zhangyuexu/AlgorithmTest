import java.util.Arrays;

public class Bubble {
	/**
	 * 冒泡排序
	 * 这个思想是：
     *1、第一遍：第一个跟第二个比，符合条件交换位置；然后第二个跟第三个比，符合条件交换位置；然后第三个跟第四个比，符合条件交换位置；以此类推。。。这样第一次比7次
     *2、第二遍：第二次比6次
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
		//由此看出数组的元素可以发生变化，但是数组的长度是固定的，不能变；
		System.out.println(Arrays.toString(arr));
	}

}
