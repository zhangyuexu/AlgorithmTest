import java.util.Arrays;
/**
 *选择排序：最快的排序，比如一千万条记录，查找需要5次，那么两千万条，就只增加1次查找
 *这个思想是：
 *1、第一遍：第一个跟第二个比，符合条件交换位置；然后还是第一个跟第三个比，符合条件交换位置；以此类推。。。
 *2、第二遍：第二个跟第三个比，符合条件交换位置；然后还是第二个跟第四个比，符合条件交换位置；以此类推。。。
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
