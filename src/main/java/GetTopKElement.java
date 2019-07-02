import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang3.ArrayUtils;

public class GetTopKElement {

	public static void main(String[] args) {
		getTopKElement(10);
	}
	public static void getTopKElement(int k){
		int[] maxarr={};
		int[] targetarr={};
		for(int i=0;i<100;i++){
			targetarr=ArrayUtils.add(targetarr, i, new Random().nextInt(100));//也可以写成ArrayUtils.add(targetarr,new Random().nextInt(100))
			
		}
		System.out.println(Arrays.toString(targetarr));
		for(int i=0;i<k;i++){
			maxarr=ArrayUtils.add(maxarr, i,targetarr[i]);//也可以写成ArrayUtils.add(maxarr,targetarr[i])
		}
		maxarr=sort(maxarr);
		//System.out.println(Arrays.toString(maxarr));
		for(int i=k;i<targetarr.length;i++){
			if(targetarr[i]>maxarr[k-1]){
				maxarr=ArrayUtils.remove(maxarr, k-1);
				maxarr=ArrayUtils.add(maxarr, targetarr[i]);//默认是从最后添加
				maxarr=sort(maxarr);
			}
		}
		System.out.println(Arrays.toString(maxarr));
		
	}
	public static int[] sort(int[] arr){
		int[] arr2={};
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;i--){
			arr2=ArrayUtils.add(arr2,arr[i]);
		}
		return arr2;
	}

}
